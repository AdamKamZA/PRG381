package services;

import org.springframework.stereotype.Service;

import models.admins;
import repos.adminRepo;

@Service
public class AdminServiceImpl implements AdminService{
    private adminRepo adminRepo;

    @Override
    public admins saveAdmin(admins admin) {
        return this.adminRepo.save(admin);
    }

    public AdminServiceImpl(repos.adminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    
    
}
