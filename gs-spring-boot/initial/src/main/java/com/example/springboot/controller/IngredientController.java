package com.example.springboot.controller;

import com.example.springboot.entity.Ingredient;
import com.example.springboot.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class IngredientController {
    private IngredientService ingredientService;
    @Autowired
    IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping("/create-ingredient")
    public ResponseEntity<String> addNewIngredient(@RequestBody Ingredient ingredient){
        this.ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body("Nuovo ingrediente inserito!");
    }

    //Read
    @GetMapping("/retrieve-ingredient")
    public ResponseEntity<Ingredient> getIngredientById(@RequestParam Long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        return ResponseEntity.ok().body(ingredient);
    }

    //Update
    @PutMapping("/update-ingredient")
    public ResponseEntity<Ingredient> updateIngredientById(@RequestBody Ingredient ingredient, @RequestParam Long id){
        this.ingredientService.updateIngredient(id,ingredient);
        return ResponseEntity.ok().body(ingredient);
    }
    //Delete
    @DeleteMapping("/delete-ingredient")
    public ResponseEntity<String> deleteIngredient(@RequestParam Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().body("Ingrediente cancellato!");
    }
}
