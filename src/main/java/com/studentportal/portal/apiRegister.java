package com.studentportal.portal;

public class apiRegister {
    private String student_name, student_address, student_email, student_password, course_name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public apiRegister(){}

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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString(){
        //Handling names without a surname, prevent templating errors
        if(student_name.indexOf(" ")==-1){
            student_name = student_name + " None";
        }
        return String.format("{'id':%d, 'name':%s , 'address':%s , 'email':%s , 'password':%s, 'course':%s}", id, student_name, student_address, student_email, student_password, course_name);
    }

}
