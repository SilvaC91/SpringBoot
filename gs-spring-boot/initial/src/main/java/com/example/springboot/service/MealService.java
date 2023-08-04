package com.example.springboot.service;

import com.example.springboot.dao.MealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class MealService {
    private MealDao mealDao;
    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public List<Meal> getMeals() throws Exception {
        if (mealDao.getMeals().size() == 0) {
            throw new Exception("Non ci sono pasti!");
        } else {
            return mealDao.getMeals();
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
        mealDao.addMeal(m);
    }

    public Meal getMealByName(String name) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
        }
            if (mealDao.getMealByName(name) == null){
                throw new Exception("Pasto non trovato!");
            } else {
                return mealDao.getMealByName(name);
            }
        }

    public Meal getMealByWordInDescription(String word) throws Exception {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("La parola non può essere null o vuota!");
        }
        if (mealDao.getMealByWordInDescription(word) == null) {
            throw new Exception("Pasto non trovato!");
        } else {
            return mealDao.getMealByName(word);
        }
    }


    public Meal getMealByPrice(double min, double max) throws Exception {
        if(min <= 0 || max <= 0){
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        if(max < min){
            throw new IllegalArgumentException("Il limite superiore non può essere minore del limite inferiore!");
        }
        if(mealDao.getMealByPrice(min, max) == null){
            throw new Exception("Nessun pasto trovato!");
        } else {
            return mealDao.getMealByPrice(min, max);
        }
    }

        public void deleteMeal(String name) throws Exception {
            if(name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Il nome del pasto non può essere null o vuoto!");
            }
            if (mealDao.deleteMeal(name) == false) {
                    throw new Exception("Pasto non trovato!");
            }else{
                mealDao.deleteMeal(name);
            }
        }

    public void deleteMealAbovePrice(double price) throws Exception {
        if(price < 0){
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        if(mealDao.deleteMealAbovePrice(price) == false){
                throw new Exception("Nessun pasto trovato!");
            }else {
                mealDao.deleteMealAbovePrice(price);
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
        if(mealDao.setMealByName(name, meal) == false){
            throw new Exception("Pasto non trovato!");
        }else{
            mealDao.setMealByName(name, meal);
        }
    }



}

