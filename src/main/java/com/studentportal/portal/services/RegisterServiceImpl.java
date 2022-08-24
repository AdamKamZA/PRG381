package com.studentportal.portal.services;

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

    
    
}
