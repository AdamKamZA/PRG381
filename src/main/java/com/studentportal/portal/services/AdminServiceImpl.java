package com.studentportal.portal.services;

import org.springframework.stereotype.Service;

import com.studentportal.portal.models.admins;
import com.studentportal.portal.repos.adminRepo;

@Service
public class AdminServiceImpl implements AdminService{
    private adminRepo adminRepo;

    @Override
    public admins saveAdmin(admins admin) {
        return this.adminRepo.save(admin);
    }

    public AdminServiceImpl(com.studentportal.portal.repos.adminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    
    
}
