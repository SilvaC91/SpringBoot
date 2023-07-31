package com.example.springboot.controllers._03_Request_body__Post__autoserialization_issues;

import com.example.springboot.model.Meal;
import com.example.springboot.service.Meal_service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Meal_controller_2 {

    private Meal_service ms = new Meal_service();

    @PutMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        this.ms.addMeal(meal);
        return ResponseEntity.ok ("Pasto aggiunto!");
    }

    @PutMapping("/meal/{name}")
    public ResponseEntity<String> modifyMealName(@PathVariable String name,
                                          @RequestBody Meal meal) {
        if(this.ms.getMealByName(name) == null){
            return ResponseEntity.badRequest().body("Pasto non trovato");
        }else{
            this.ms.setMealByName(name, meal);
            return ResponseEntity.ok("Pasto modificato!");
        }
    }

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        if(this.ms.getMealByName(name) == null){
            return ResponseEntity.badRequest().body("Pasto non trovato");
        }else{
            this.ms.removeMeal(this.ms.getMealByName(name));
            return ResponseEntity.ok("Pasto rimosso!");
        }
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        this.ms.deleteMealAbovePrice(price);
            return ResponseEntity.ok("Pasti rimossi!");
    }

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> modifyMeal(@PathVariable String name,
                                             @RequestBody double price) {
        if(this.ms.getMealByName(name) == null){
            return ResponseEntity.badRequest().body("Pasto non trovato");
        }else{
            this.ms.getMealByName(name).setPrice(price);
            return ResponseEntity.ok("Pasto modificato!");
        }
    }
}
