package com.studentportal.portal.services;

import java.util.List;

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
        if(admin.getEmail()!=null){
            if(admin.getEmail().equalsIgnoreCase(email)){
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
    public admins updateAdmins(String email, admins admin) {
        try{
            admins oldData = deleteAdmin(email);
            if(oldData!=null){
            admins newAdmin = saveAdmin(admin);
            return newAdmin;
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
