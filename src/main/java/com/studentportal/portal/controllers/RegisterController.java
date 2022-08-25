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

import com.studentportal.portal.models.Register;

import com.studentportal.portal.services.RegisterService;



@RestController

public class RegisterController {
    private RegisterService regserv;

    public RegisterController(RegisterService regserv){
        super();
        this.regserv = regserv;
    }


    //rest

    @PostMapping(value = "/api/registration/save")
    public ResponseEntity<Register> saveRegister(@RequestBody Register register){
        return new ResponseEntity<Register>(this.regserv.saveRegister(register), HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/api/registration/delete/email/{email}/course/{course}")
    public ResponseEntity<Register> deleteStudentReg(@PathVariable("email") String email, @PathVariable("course") String course){
        return new ResponseEntity<Register>(this.regserv.deleteRegistration(email, course), HttpStatus.OK);
    }

    @GetMapping(value = "/api/registration/all")
    public ResponseEntity<List<Register>> getAllReg(){
        return new ResponseEntity<List<Register>>(this.regserv.getAllRegistratrions(), HttpStatus.OK);
    }

    @GetMapping(value="/api/registration/email/{email}")
    public ResponseEntity<List<Register>> getMethodName(@PathVariable("email") String email) {
        return new ResponseEntity<List<Register>>(this.regserv.getRegisteredStudent(email), HttpStatus.FOUND);
    }

    @PutMapping(value = "/api/Registration/update")
    public ResponseEntity<Register> update(@RequestBody Register register){
        return new ResponseEntity<Register>(this.regserv.updateRegistration(register.getEmail(), register.getCourse(), register), HttpStatus.OK);

    }
    
    @GetMapping(value = "/api/registration/courses/{course}")
    public ResponseEntity<List<Register>> allCourses(@PathVariable("course") String course){
        return new ResponseEntity<List<Register>>(this.regserv.getAllCourses(course), HttpStatus.OK);
    }

}
