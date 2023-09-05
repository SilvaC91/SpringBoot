package com.example.springboot.repository;

import com.example.springboot.entity.Ingredient;
import com.example.springboot.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
