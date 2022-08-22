package com.prgproject.studportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String student(Model model) {
        Student students = new Student();
        model.addAttribute("student", students);
        return "student"; // returning static student html page
    }

    @GetMapping("/admin")
    public String admin(Model model) { // Model model
        // fetch all students
        Student students = new Student();
        model.addAttribute("student", students);
        return "admin"; // returning static admin html page
    }

}
