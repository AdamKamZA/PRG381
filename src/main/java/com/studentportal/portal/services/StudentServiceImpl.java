package com.studentportal.portal.services;

import org.springframework.stereotype.Service;

import com.studentportal.portal.models.Student;
import com.studentportal.portal.repos.studentRepo;

@Service
public class StudentServiceImpl implements StudentService{
    private studentRepo studentRep;
    
    @Override
    public Student saveStudent(Student student) {
       return studentRep.save(student);
    }
    
    public StudentServiceImpl(com.studentportal.portal.repos.studentRepo studentRepo) {
        this.studentRep = studentRepo;
    }
    
}
