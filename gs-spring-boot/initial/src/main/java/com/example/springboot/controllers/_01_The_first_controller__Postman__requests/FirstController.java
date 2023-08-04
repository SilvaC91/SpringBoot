package com.example.springboot.controllers._01_The_first_controller__Postman__requests;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FirstController {

    @GetMapping ("/hello")
    public String string(){
        return "Hello world!";
    }

    @GetMapping ("/greeting")
    public ResponseEntity <String> string2(){
        return new ResponseEntity("Good afternoon!", HttpStatusCode.valueOf(200));
    }

    @GetMapping ("/info")
    public ResponseEntity <String> string3() {
        return ResponseEntity.ok().build();
    }

    @GetMapping ("/random")
    public ResponseEntity <String> string4() {
        boolean random = new Random().nextBoolean();
        if(random) {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
