package services;

import org.springframework.stereotype.Service;

import models.Student;
import repos.studentRepo;

@Service
public class StudentServiceImpl implements StudentService{
    private studentRepo studentRep;
    
    @Override
    public Student saveStudent(Student student) {
       return studentRep.save(student);
    }
    
    public StudentServiceImpl(repos.studentRepo studentRepo) {
        this.studentRep = studentRepo;
    }
    
}
