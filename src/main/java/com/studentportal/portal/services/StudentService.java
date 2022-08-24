package com.studentportal.portal.services;

import com.studentportal.portal.models.Student;
import java.util.List;



public interface StudentService {
    Student saveStudent(Student student);
    Student getStudent(String email);
    List<Student> getAllStudents();
   Student deleteStudent(String email);
    Student update(String email, Student student);


}
