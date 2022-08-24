package com.studentportal.portal.controllers;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import com.studentportal.portal.apiStudent;

@Controller
public class PageController {

    // Routing for home page:
    @GetMapping("/")
    public String index() {
        return "index"; // returning static index html page
    }

    @GetMapping("/student")
    public String student(@RequestParam(value = "email", required = true) String email, Model model) {
        // will be replaced with student details of the object, was only a test
        String uri = String.format("http://localhost:8080/api/students/email/%s", email);
        RestTemplate rt = new RestTemplate();
        apiStudent student = rt.getForObject(uri, apiStudent.class);
        JSONObject JSON_Student = new JSONObject(student.toString());

        model.addAttribute("student", JSON_Student);
        return "student"; // returning static student html page
    }

    @GetMapping("/admin")
    public String admin(Model model) { // Model model
        // fetch all students

        String uri = "http://localhost:8080/api/students/all";
        RestTemplate rt = new RestTemplate();
        apiStudent[] arr_Students = rt.getForObject(uri, apiStudent[].class);
        ArrayList<JSONObject> JSON_ARR_Students = new ArrayList<JSONObject>();
        for(apiStudent student:arr_Students){
            JSONObject JSON_Student = new JSONObject(student.toString());
            JSON_ARR_Students.add(JSON_Student);
        }
        model.addAttribute("students", JSON_ARR_Students);
        return "admin"; // returning static admin html page
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
