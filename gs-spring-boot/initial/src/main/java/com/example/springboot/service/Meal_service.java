package com.example.springboot.service;

import com.example.springboot.model.Meal;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

public class Meal_service {

    private List<Meal> mealsList = Arrays.asList(
            new Meal("Tagliatelle al ragù", "Pasta sottile all'uovo con sugo di pomodoro e macinato di carne", 12 ),
            new Meal("Rigatoni alla carbonara", "Pasta con crema di uovo e formaggio pecorino, e guanciale di maiale croccante", 10),
            new Meal("Risotto alla monzese", "Riso allo zafferano con luganega di maiale", 12)
    );

    public List<Meal> getMeals() {
        return this.mealsList;
    }

    public Meal getMealByName(String name){
        for (Meal m : this.mealsList) {
            if(m.getName() == name){
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

    public Meal getMealByPrice(int min, int max){
        List<Meal> lm = Arrays.asList();
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













}
