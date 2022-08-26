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
@Table(name="administrator")
public class admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "admin_name")
    private String admin_name;

    @Column(name = "admin_email")
    private String admin_email;

    @Column(name = "password")
    private String admin_password;

    @Column(name = "contact")
    private String contact;

   
}
