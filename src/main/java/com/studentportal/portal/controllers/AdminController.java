package com.studentportal.portal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.portal.models.admins;

import com.studentportal.portal.services.AdminService;





@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private AdminService adminServ;

    public AdminController(AdminService adminServ) {
        super();
        this.adminServ = adminServ;
    }

    //rest
    @PostMapping
    public ResponseEntity<admins> saveRegister(@RequestBody admins admin){
        return new ResponseEntity<admins>(this.adminServ.saveAdmin(admin), HttpStatus.CREATED);
    }

   
    

    
}
