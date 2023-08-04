package com.example.springboot.controllers._02_Controller_path_variables__request_params__returning_objects;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
