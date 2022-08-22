package com.prgproject.studportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    //Routing for home page:
    @GetMapping("/")
    public String index(){
        return "index"; //returning static index html page
    }
    @GetMapping("/student")
    public String student(){
        return "student"; //returning static student html page
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin"; //returning static admin html page
    }

}
