package com.example.springboot.repository;

import com.example.springboot.entity.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    private List<Meal> mealsList = new ArrayList<>();

    public List<Meal> getMeals(){
        return this.mealsList;
    }


    public Meal getMealByName(String name) {
        for (Meal m : this.mealsList) {
            if (m.getName() == name) {
                return m;
            }
        }
        return null;
    }

    public Meal getMealByWordInDescription(String word){
        for (Meal m : this.mealsList) {
            if(m.getDescription().matches(word)){
                return m;
            }
        }
        return null;
    }

    public Meal getMealByPrice(double min, double max){
        List<Meal> lm = new ArrayList<>();
        for (Meal m : this.mealsList) {
            if(m.getPrice() >= min && m.getPrice() <= max){
                lm.add(m);
            }
        }
        if(lm.isEmpty()){
            return null;
        }else {
            return (Meal) lm;
        }
    }

    public boolean deleteMeal(String name) {
        for (Meal m : this.mealsList) {
            if (m.getName() == name) {
                this.mealsList.remove(m);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMealAbovePrice(double price) {
        for (Meal m : this.mealsList) {
            if (m.getPrice() > price) {
                this.mealsList.remove(m);
                return true;
            }
        }
        return false;
    }


    public boolean setMealByName(String name, Meal meal){
        for (Meal m : this.mealsList) {
            if(m.getName() == name){
                m = meal;
                return true;
            }
        }
        return false;
    }

}
