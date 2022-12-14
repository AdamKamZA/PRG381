package com.studentportal.portal.services;

import com.studentportal.portal.models.Register;

import java.util.List;


public interface RegisterService {
    Register saveRegister(Register register);
    List<Register> getAllRegistrations();
    List<Register> getRegisteredStudent(String email) ;
   
    Register deleteRegistration(String email, String course); 
    Register updateRegistration(String email, String course, Register registration);
    List<Register> getAllCourses(String course);

    

    
}
