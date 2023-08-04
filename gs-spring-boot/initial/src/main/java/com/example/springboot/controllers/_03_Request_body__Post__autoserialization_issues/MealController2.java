package com.example.springboot.controllers._03_Request_body__Post__autoserialization_issues;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealController2 {
    private MealService mealService;
    @Autowired
    public MealController2(MealService mealService) {
        this.mealService = mealService;
    }

    @PutMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        try{
            mealService.addMeal(meal);
            return ResponseEntity.ok ("Pasto aggiunto!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/meal/{name}")
    public ResponseEntity<String> setMealByName(@PathVariable String name,
                                                @RequestBody Meal meal) {
        try {
            mealService.setMealByName(name, meal);
            return ResponseEntity.ok("Pasto modificato!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        try {
            mealService.deleteMeal(name);
            return ResponseEntity.ok("Pasto rimosso!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        try{
            mealService.deleteMealAbovePrice(price);
            return ResponseEntity.ok("Pasti rimossi!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> modifyMeal(@PathVariable String name,
                                             @RequestBody double price) {
        try{
            mealService.getMealByName(name).setPrice(price);
            return ResponseEntity.ok("Prezzo del pasto modificato!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
