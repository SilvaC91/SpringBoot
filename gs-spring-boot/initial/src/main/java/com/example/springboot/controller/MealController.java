package com.example.springboot.controller;

import com.example.springboot.entity.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController

public class MealController {
    private MealService mealService;
    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping ("/meals")
    public ResponseEntity<?> getMeal(){
       try{
           return ResponseEntity.ok(mealService.getMeals());
       }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping ("/meal/{name}")
    public ResponseEntity<?> getMealByName(@PathVariable("name") String name){
        try{
            return ResponseEntity.ok(mealService.getMealByName(name));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping ("/meal/description-match/{phrase}")
    public ResponseEntity<?> getMealByWordInDescription(@PathVariable("phrase") String description){
        try{
            return ResponseEntity.ok(mealService.getMealByWordInDescription(description));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping ("/meal/price")
    public ResponseEntity<?> getMealByPrice(
            @RequestParam("minPrice") double min,
            @RequestParam("maxPrice") double max){
        try{
            return ResponseEntity.ok(mealService.getMealByPrice(min, max));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
