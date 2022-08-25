package com.studentportal.portal.controllers;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.studentportal.portal.apiRegister;
import com.studentportal.portal.apiStudent;
import com.studentportal.portal.services.StudentServiceImpl;

@Controller
public class PageController {

    StudentServiceImpl studImpl;

    // Routing for home page:
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("studImp", studImpl);
        return "index"; // returning static index html page
    }

    @GetMapping("/student")
    public String student(@RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password, Model model) {
        // will be replaced with student details of the object, was only a test
        try {
            String uri = String.format("http://localhost:8080/api/students/email/%s", email);
            RestTemplate rt = new RestTemplate();
            apiStudent student = rt.getForObject(uri, apiStudent.class);
            JSONObject JSON_Student = new JSONObject(student.toString());

            // Check if the passwords match
            if (!JSON_Student.get("password").toString().equals(password)) {
                model.addAttribute("state", false); // tells page if its first time render or a redirect back
                return "index";
            }

            // Routing to the offficial student page, where they can update their password
            model.addAttribute("student", JSON_Student);
            return "student"; // returning static student html page
        } catch (HttpClientErrorException e) {
            // Redirect, as this means that bad credentials were entered
            model.addAttribute("state", false); // tells page if its first time render or a redirect back
            return "index";
        }
    }

    // @GetMapping("/admin")
    // public String admin(Model model) { // Model model
    // // fetch all students

    // String uri = "http://localhost:8080/api/students/all";
    // RestTemplate rt = new RestTemplate();
    // apiStudent[] arr_Students = rt.getForObject(uri, apiStudent[].class);
    // ArrayList<JSONObject> JSON_ARR_Students = new ArrayList<JSONObject>();
    // for (apiStudent student : arr_Students) {
    // JSONObject JSON_Student = new JSONObject(student.toString());
    // JSON_ARR_Students.add(JSON_Student);
    // }
    // System.out.println(JSON_ARR_Students.get(0));
    // model.addAttribute("students", JSON_ARR_Students);
    // return "admin"; // returning static admin html page
    // }

    @GetMapping("/admin")
    public String admin(Model model) { // Model model

        try {

            //See if admin exists
            //unfinished
            // String uri = String.format("http://localhost:8080/api/students/email/%s", email);
            // RestTemplate rt = new RestTemplate();
            // apiStudent student = rt.getForObject(uri, apiStudent.class);
            // JSONObject JSON_Student = new JSONObject(student.toString());

            // // Check if the passwords match
            // if (!JSON_Student.get("password").toString().equals(password)) {
            //     model.addAttribute("state", false); // tells page if its first time render or a redirect back
            //     return "index";
            // }
            
            String uri = "http://localhost:8080/api/registration/all";
            RestTemplate rt = new RestTemplate();
            apiRegister[] arr_Students = rt.getForObject(uri, apiRegister[].class);
            ArrayList<JSONObject> JSON_ARR_Students = new ArrayList<JSONObject>();
            for (apiRegister student : arr_Students) {
                JSONObject JSON_Student = new JSONObject(student.toString());
                JSON_ARR_Students.add(JSON_Student);
            }
            // System.out.println(JSON_ARR_Students.get(0));
            model.addAttribute("students", JSON_ARR_Students);
            return "admin"; // returning static admin html page
        } catch (HttpClientErrorException e) {
            // Redirect, as this means that bad credentials were entered
            model.addAttribute("state", false); // tells page if its first time render or a redirect back
            return "index";
        }
        // fetch all students

    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
