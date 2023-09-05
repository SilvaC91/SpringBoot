package com.example.springboot.service;

import com.example.springboot.entity.Ingredient;
import com.example.springboot.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class IngredientService {
    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredient(Ingredient ingredient){
    ingredientRepository.save(ingredient);
    }
    public Ingredient getIngredient(Long Id){
    return ingredientRepository.findById(Id).get();
    }
    public Optional<Ingredient> updateIngredient(Long id, Ingredient ingredient){
        Optional<Ingredient> ingredientToUpdate = ingredientRepository.findById(id);
        if(ingredientToUpdate.isPresent()){
            ingredientToUpdate.get().setName(ingredient.getName());
            ingredientToUpdate.get().setVegetarian(ingredient.isVegetarian());
            ingredientToUpdate.get().setVegan(ingredient.isVegan());
            ingredientToUpdate.get().setGlutenFree(ingredient.isGlutenFree());
            ingredientToUpdate.get().setLactoseFree(ingredient.isLactoseFree());
            ingredientRepository.save(ingredientToUpdate.get());
        }else{ return Optional.empty();}
        return ingredientToUpdate;
    }
    public void deleteIngredient(Long Id){
    ingredientRepository.deleteById(Id);
    }

}
