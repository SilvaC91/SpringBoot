package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class _02_Controller_path_variables__request_params__returning_objects {

    @GetMapping ("/meals")
    public List<Meal> meals(){
        List<Meal> listaPasti = new ArrayList<>();
        return listaPasti;
    }


}
