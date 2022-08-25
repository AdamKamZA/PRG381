package com.studentportal.portal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.studentportal.portal.exceptions.ResourceNotFound;
import com.studentportal.portal.models.Register;
import com.studentportal.portal.repos.RegisterRepo;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepo regRepo;

    @Override
    public Register saveRegister(Register register) {// add student
        return regRepo.save(register);
    }

    public RegisterServiceImpl(RegisterRepo regRepo) { // constructor
        this.regRepo = regRepo;
    }

    @Override
    public Register deleteRegistration(String email, String course) { // search via email, expecting list, filter again
                                                                      // via course then delete, deleteing all encounter
                                                                      // of the student
        try {
            List<Register> selectRegViaEmail = getRegisteredStudent(email);

            Register lastEncounter = null;

            for (Register reg : selectRegViaEmail) {
                if (reg.getCourse() != null) {
                    if (reg.getCourse().equalsIgnoreCase(course)) {
                        regRepo.delete(reg);
                        lastEncounter = reg;
                    }
                }
            }

            return lastEncounter; // return proof of deleted student
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Register> getAllRegistrations() {
        return regRepo.findAll();
    }

    @Override
    public List<Register> getRegisteredStudent(String email) {
        List<Register> reg = getAllRegistrations();
        ArrayList<Register> selectReg = new ArrayList<>();

        for (Register registration : reg) {
            if (registration.getEmail() != null) {
                if (registration.getEmail().equalsIgnoreCase(email)) {
                    selectReg.add(registration);
                }
            }
        }

        return (List<Register>) selectReg;
    }

    @Override
    public Register updateRegistration(String email, String course, Register registration) {
        try {
            List<Register> emailFiltered = getRegisteredStudent(email);

            ArrayList<Register> courseList = new ArrayList<>();

            for (Register reg : emailFiltered) {
                if (reg.getCourse() != null) {
                    if (reg.getCourse().equalsIgnoreCase(course)) {
                        courseList.add(reg);
                    }
                }
            }

            if (courseList.size() == 0) {
                throw new ResourceNotFound(email, course, courseList);
            } else {
                // only updating first match
                try {
                    Register match = courseList.get(0);
                    regRepo.delete(match);
                    saveRegister(registration);
                    return getRegisteredStudent(email).get(0);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    @Override
    public List<Register> getAllCourses(String course) {
        List<Register> allReg = regRepo.findAll();
        ArrayList<Register> courseList = new ArrayList<>();

        for (Register reg : allReg) {
            if (reg.getCourse() != null) {
                if (reg.getCourse().equalsIgnoreCase(course)) {
                    courseList.add(reg);
                }
            }
        }

        return (List<Register>) courseList;
    }

    // crud complete
}