package com.studentportal.portal.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.portal.models.admins;

import com.studentportal.portal.services.AdminService;





@RestController

public class AdminController {
    private AdminService adminServ;

    public AdminController(AdminService adminServ) {
        super();
        this.adminServ = adminServ;
    }

    // added a email field to the administrator table as a means of
    //  identification as name and contact is not unique and the ID is
    //   system specific and not readable by humans
    //that is why admin_email is used


    //rest
    @PostMapping(value = "/api/admin/save") //add 
    public ResponseEntity<admins> saveRegister(@RequestBody admins admin){
        return new ResponseEntity<admins>(this.adminServ.saveAdmin(admin), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/admin/all") //all
    public ResponseEntity<List<admins>> getAllAdmins(){
        return new ResponseEntity<List<admins>>(this.adminServ.getAllAdmins(), HttpStatus.OK);
    }

    @GetMapping(value ="/api/admin/email/{email}") //specific admin
    public ResponseEntity<admins> getAdmin(@PathVariable("email") String email){
         return new ResponseEntity<admins>(this.adminServ.getAdmin(email), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/api/admin/delete/email/{email}")// delete via email
    public ResponseEntity<admins> deleteAdmin(@PathVariable("email") String email){
        return new ResponseEntity<admins>(this.adminServ.deleteAdmin(email), HttpStatus.OK);
    }

    //update by email, this is a put request because repo does not have a update function,
     //solution is to delete old data and save new data, this acts as update but drawback is ID changes

    @PutMapping(value="/api/admin/update")
    public ResponseEntity<admins> update(@RequestBody admins admin) {
        return  new ResponseEntity<admins>(this.adminServ.updateAdmins(admin.getEmail(), admin), HttpStatus.OK);

    }





}
