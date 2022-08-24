package com.studentportal.portal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class apiStudent {

    //Student JSON keys
    private String student_name, student_address, student_email, student_password;

    public apiStudent(){}

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }
    @Override
    public String toString(){
        return String.format("{'name':%s , 'address':%s , 'email':%s , 'password':%s}", student_name, student_address, student_email, student_password);
    }
}
