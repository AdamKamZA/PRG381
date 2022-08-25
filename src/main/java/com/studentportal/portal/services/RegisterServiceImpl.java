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
                if (reg.getCourse_name() != null) {
                    if (reg.getCourse_name().equalsIgnoreCase(course)) {
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
            if (registration.getStudent_email() != null) {
                if (registration.getStudent_email().equalsIgnoreCase(email)) {
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
                if (reg.getCourse_name() != null) {
                    if (reg.getCourse_name().equalsIgnoreCase(course)) {
                        courseList.add(reg);
                    }
                }
            }

            if (courseList.size() == 0) {
                throw new ResourceNotFound(email, course, courseList);
            } else {
                // only updating first match

                Register match = courseList.get(0);
                match.setCourse_name(registration.getCourse_name());
                match.setStudent_address(registration.getStudent_address());
                match.setStudent_email(registration.getStudent_email());
                match.setStudent_password(registration.getStudent_password());
                match.setCourse_name(registration.getCourse_name());
                saveRegister(match);
                return match;
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
            if (reg.getCourse_name() != null) {
                if (reg.getCourse_name().equalsIgnoreCase(course)) {
                    courseList.add(reg);
                }
            }
        }
        return (List<Register>) courseList;

    }
    // crud complete
}