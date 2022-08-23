package com.studentportal.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    class Student{
        String name="Adam";
        String surname="Kaminski";
        public Student(){}
    }
    // Routing for home page:
    @GetMapping("/")
    public String index() {
        return "index"; // returning static index html page
    }

    @GetMapping("/student")
    public String student(@RequestParam(value = "name", defaultValue = "Anon", required = true) String name, Model model) {
        //will be replaced with student details of the object, was only a test
        model.addAttribute("name",name);
        return "student"; // returning static student html page
    }

    @GetMapping("/admin")
    public String admin(Model model) { // Model model
        // fetch all students
        Student students = new Student();
        model.addAttribute("student", students);
        return "admin"; // returning static admin html page
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
