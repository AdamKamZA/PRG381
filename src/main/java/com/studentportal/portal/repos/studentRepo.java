package com.studentportal.portal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentportal.portal.models.Student;


public interface studentRepo extends JpaRepository<Student, Integer> {
    
}
