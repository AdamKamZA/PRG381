package com.studentportal.portal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.portal.models.Student;

import com.studentportal.portal.services.StudentService;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    

    //rest api
    @PostMapping(value = "/api/students/save") //add student
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(this.studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/students/all") //return all students
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<List<Student>>(this.studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/api/students/email/{email}") //search by student email
    public ResponseEntity<Student> findStudentByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Student>(studentService.getStudent(email), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/api/students/delete/{email}") //delete by email
    public ResponseEntity<Student> deleteStudent(@PathVariable("email") String email){
        return new ResponseEntity<Student>(studentService.deleteStudent(email), HttpStatus.OK);
    }

    
    @PutMapping(value = "/api/students/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
       
        return new ResponseEntity<Student>(this.studentService.update(student), HttpStatus.OK);
    }

    //crud complete
}
  