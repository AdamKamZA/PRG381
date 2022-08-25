package com.studentportal.portal.services;

import java.util.List;
import java.util.Optional;

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
        
        Student target = null;

        for(Student s : stdns){
            if(s.getEmail()!=null){
                if(s.getEmail().equalsIgnoreCase(email)){
                    target=s;
                    break;    
                }
            }

        }
        if(target!=null){
            return target;
        }
        else{
            throw new ResourceNotFound(email, "email", email);
        }
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
    public Student update(Student student) {
      try{
        if(studentRep.findById(student.getStudent_id()).isPresent()){
            Optional<Student> oldData = studentRep.findById(student.getStudent_id());
            
            Student oldStudent = oldData.get();

            oldStudent.setStudent_address(student.getStudent_address());
            oldStudent.setStudent_email(student.getEmail());
            oldStudent.setStudent_name(student.getStudent_name());
            oldStudent.setStudent_password(student.getStudent_password());


            Student newStudent = saveStudent(oldStudent);
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
