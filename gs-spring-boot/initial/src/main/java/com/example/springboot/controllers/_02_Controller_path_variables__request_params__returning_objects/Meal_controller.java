package com.example.springboot.controllers._02_Controller_path_variables__request_params__returning_objects;

import com.example.springboot.model.Meal;
import com.example.springboot.service.Meal_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Meal_controller {
    private Meal_service ms = new Meal_service();



    @GetMapping ("/meals")
    public ResponseEntity<List<Meal>> getMeal(){
        return ResponseEntity.ok(this.ms.getMeals());
    }


    @GetMapping ("/meal/{name}")
    public ResponseEntity<?> getMealByName(@PathVariable("name") String name){
        if(this.ms.getMealByName(name) == null){
                return ResponseEntity.badRequest().body("Pasto non trovato");
            }else{
            return ResponseEntity.ok(this.ms.getMealByName(name));
        }
    }

    @GetMapping ("/meal/description-match/{phrase}")
    public ResponseEntity<?> getMealByWordInDescription(@PathVariable("phrase") String description){
        if(this.ms.getMealByWordInDescription(description) == null){
            return ResponseEntity.badRequest().body("Pasto non trovato");
        }else{
            return ResponseEntity.ok(this.ms.getMealByWordInDescription(description));
        }
    }

    @GetMapping ("/meal/price")
    public ResponseEntity<?> getMealByPrice(
            @RequestParam("minPrice") int min,
            @RequestParam("maxPrice") int max){
        if(this.ms.getMealByPrice(min, max) == null){
            return ResponseEntity.badRequest().body("Pasto non trovato");
        }else{
            return ResponseEntity.ok(this.ms.getMealByPrice(min, max));
        }
    }

































}
