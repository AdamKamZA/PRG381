package com.studentportal.portal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentportal.portal.exceptions.ResourceNotFound;
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

    @Override
    public List<Student> getAllStudents() {
        return studentRep.findAll();
        
    }

    @Override
    public Student getStudent(String email) {
        List<Student> stdns = getAllStudents();
      
        for(Student s : stdns){
            if(s.getEmail()!=null){
                if(s.getEmail().equalsIgnoreCase(email)){
                    System.out.println("email found");
                    return s;
                }
            }

        }
        throw new ResourceNotFound(email, "email", email);
    }

    @Override
    public Student deleteStudent(String email) {
        try{
        Student s = getStudent(email);
        studentRep.delete(s);
        return s;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Student update(String email,Student newStudentData) {
      try{
        Student oldStudentData = deleteStudent(email);
        if(oldStudentData!=null){
        Student newStudent = saveStudent(newStudentData);
        return newStudent;
        }
        else{
            throw new Exception("student not found");
        }
        

      }
      catch(Exception e){
        System.out.println(e);
        return null;
      }
    }


    
    
}
