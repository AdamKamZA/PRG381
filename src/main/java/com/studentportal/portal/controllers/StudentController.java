package com.studentportal.portal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.portal.models.Student;

import com.studentportal.portal.services.StudentService;

import java.util.List;

@RestController

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    

    //rest api
    @PostMapping(value = "/api/students/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(this.studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/students/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<List<Student>>(this.studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/api/students/email/{email}")
    public ResponseEntity<Student> findStudentByEmail(String email){
        return new ResponseEntity<Student>(studentService.getStudent(email), HttpStatus.FOUND);
    }
}
  