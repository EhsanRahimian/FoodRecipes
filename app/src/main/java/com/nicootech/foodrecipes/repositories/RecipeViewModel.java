package com.nicootech.foodrecipes.repositories;

import com.nicootech.foodrecipes.models.Recipe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<Recipe> getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId){
        mRecipeRepository.searchRecipeById(recipeId);
    }
}
