package com.example.springboot.service;

import com.example.springboot.repository.MealRepository;
import com.example.springboot.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MealService {
    private MealRepository mealRepository;
    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getMeals() throws Exception {
        if (mealRepository.getMeals().size() == 0) {
            throw new Exception("Non ci sono pasti!");
        } else {
            return mealRepository.getMeals();
          }
    }

    public void addMeal(Meal m){
        if(m == null) {
            throw new IllegalArgumentException("Pasto non può essere null!");
        }
        if(m.getName() == null || m.getName().isEmpty()) {
            throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
        }
        if(m.getDescription() == null || m.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La descrizione del pasto non può essere null o vuota!");
        }
        if(m.getPrice() <= 0) {
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        mealRepository.save(m);
    }

    public Meal getMealByName(String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
        }
            if (mealRepository.getMealByName(name) == null){
                throw new Exception("Pasto non trovato!");
            } else {
                return mealRepository.getMealByName(name);
            }
        }

    public Meal getMealByWordInDescription(String word) throws Exception {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("La parola non può essere null o vuota!");
        }
        if (mealRepository.getMealByWordInDescription(word) == null) {
            throw new Exception("Pasto non trovato!");
        } else {
            return mealRepository.getMealByName(word);
        }
    }


    public Meal getMealByPrice(double min, double max) throws Exception {
        if(min <= 0 || max <= 0){
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        if(max < min){
            throw new IllegalArgumentException("Il limite superiore non può essere minore del limite inferiore!");
        }
        if(mealRepository.getMealByPrice(min, max) == null){
            throw new Exception("Nessun pasto trovato!");
        } else {
            return mealRepository.getMealByPrice(min, max);
        }
    }

        public void deleteMeal(String name) throws Exception {
            if(name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
            }
            if (mealRepository.deleteMeal(name) == false) {
                    throw new Exception("Pasto non trovato!");
            }else{
                mealRepository.deleteMeal(name);
            }
        }

    public void deleteMealAbovePrice(double price) throws Exception {
        if(price < 0){
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        if(mealRepository.deleteMealAbovePrice(price) == false){
                throw new Exception("Nessun pasto trovato!");
            }else {
                mealRepository.deleteMealAbovePrice(price);
            }
    }

    public void setMealByName(String name, Meal meal) throws Exception {
        if(meal == null) {
            throw new IllegalArgumentException("Pasto non può essere null!");
        }
        if(meal.getName() == null || meal.getName().isEmpty()) {
            throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
        }
        if(meal.getDescription() == null || meal.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La descrizione del pasto non può essere null o vuota!");
        }
        if(meal.getPrice() <= 0) {
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        if(mealRepository.setMealByName(name, meal) == false){
            throw new Exception("Pasto non trovato!");
        }else{
            mealRepository.setMealByName(name, meal);
        }
    }



}

