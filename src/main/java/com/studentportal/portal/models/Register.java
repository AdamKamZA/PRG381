package com.studentportal.portal.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", nullable = true)
    private String student_name;

    @Column(name = "student_address", nullable = true)
    private String student_address;

    @Column(name = "student_email", nullable = true)
    private String student_email;

    @Column(name = "student_password", nullable = true)
    private String student_password;

    @Column(name = "course_name", nullable = false)
    private String course_name;

    
}
