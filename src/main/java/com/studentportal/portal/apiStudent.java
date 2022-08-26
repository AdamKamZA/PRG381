package com.studentportal.portal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class apiStudent {

    //Student JSON keys
    private String student_name, student_address, student_email, student_password;
    private int student_id;

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

    public int getStudent_id(){
        return student_id;
    }
    public void setStudent_id(int student_id){
        this.student_id=student_id;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }
    @Override
    public String toString(){
        //Handling names without a surname, prevent templating errors
        if(student_name.indexOf(" ")==-1){
            student_name = student_name + " None";
        }
        return String.format("{'id':%d,'name':%s , 'address':%s , 'email':%s , 'password':%s}", student_id, student_name, student_address, student_email, student_password);
    }
}
