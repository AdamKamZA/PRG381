package com.studentportal.portal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentportal.portal.models.Register;
import com.studentportal.portal.repos.RegisterRepo;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepo regRepo;

    @Override
    public Register saveRegister(Register register) {
        return regRepo.save(register);
    }

    public RegisterServiceImpl(RegisterRepo regRepo) {
        this.regRepo = regRepo;
    }

    @Override
    public List<Register> getAllRegistratrions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Register> getRegisteredStudent(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Register deleteRegistration(String email, String course) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Register updateRegistration(String email, String course) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
