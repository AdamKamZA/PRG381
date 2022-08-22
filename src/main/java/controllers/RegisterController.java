package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Register;
import services.RegisterService;

@RestController
@RequestMapping("/api/Registers")
public class RegisterController {
    private RegisterService regserv;

    public RegisterController(RegisterService regserv){
        super();
        this.regserv = regserv;
    }


    //rest
    @PostMapping
    public ResponseEntity<Register> saveRegister(@RequestBody Register register){
        return new ResponseEntity<Register>(this.regserv.saveRegister(register), HttpStatus.CREATED);
        
    }
}
