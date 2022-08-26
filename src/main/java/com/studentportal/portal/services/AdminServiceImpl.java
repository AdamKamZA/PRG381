package com.studentportal.portal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentportal.portal.exceptions.ResourceNotFound;
import com.studentportal.portal.models.admins;
import com.studentportal.portal.repos.adminRepo;

@Service
public class AdminServiceImpl implements AdminService{
    private adminRepo adminRepo;

    @Override
    public admins saveAdmin(admins admin) {
        try{
        return this.adminRepo.save(admin);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AdminServiceImpl(com.studentportal.portal.repos.adminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public admins deleteAdmin(String email) {
       try{
        admins a = getAdmin(email);
        adminRepo.delete(a);
        return a;
       }
       catch(Exception e){
        System.out.println(e.getMessage());
        return null;
       }
    }

    @Override
    public admins getAdmin(String email) {
       List<admins> admnList = getAllAdmins();
       admins target = null;

       for(admins admin : admnList){
        if(admin.getAdmin_email()!=null){
            if(admin.getAdmin_email().equalsIgnoreCase(email)){
                target = admin;
                break;
            }
        }

       }

       if(target!=null){
        return target;
       }
       else{
        throw new ResourceNotFound("admin", "admin email",email);
       }
    }

    @Override
    public List<admins> getAllAdmins() {
      return adminRepo.findAll();
    }

    @Override
    public admins updateAdmins(admins admin) {
        try{
            
            Optional<admins> target = adminRepo.findById(admin.getId());
            
            if(target.isPresent()){
                admins targetAdmin = target.get();
                
                targetAdmin.setAdmin_name(admin.getAdmin_email());
                targetAdmin.setAdmin_name(admin.getAdmin_name());
                targetAdmin.setContact(admin.getContact());
                targetAdmin.setAdmin_password(admin.getAdmin_password());
                adminRepo.save(targetAdmin);
                return targetAdmin;
            }
            else{
                throw new Exception("admin not found");
            }
            
    
          }
          catch(Exception e){
            System.out.println(e);
            return null;
          }
    }


    
    
}
