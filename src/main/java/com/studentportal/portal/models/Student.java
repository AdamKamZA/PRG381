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
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name = "student_name", nullable = true)
    private String student_name;

    @Column(name = "student_address", nullable = true)
    private String student_address;

    @Column(name = "student_email", nullable = true)
    private String student_email;

    @Column(name = "student_password", nullable = true)
    private String student_password;

    // public String getEmail(){
    //     return this.student_email;
    // }

    // public int getID(){
    //     return this.student_id;
    // }

    // public void setName(String name){
    //     this.student_name = name;
    // }

    // public void setAddress(String addr){
    //     this.student_address = addr;
    // }

    // public void setEmail(String email){
    //     this.student_email = email;
    // }

    // public void setPassword(String Pass){
    //     this.student_password = Pass;       
    // }
    
}
