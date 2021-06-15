package com.nicootech.foodrecipes.viewmodel;


import com.nicootech.foodrecipes.models.Recipe;

import com.nicootech.foodrecipes.repositories.RecipeRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;
    private boolean mIsViewingRecipes;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeRepository.getRecipes();
    }

    public void searchRecipeApi(String query, int pageNumber){
        mIsViewingRecipes = true;
        mRecipeRepository.searchRecipeApi(query,pageNumber);
    }

    public boolean isIsViewingRecipes(){
        return mIsViewingRecipes;
    }

    public void setIsViewingRecipes(boolean isViewingRecipes) {
        mIsViewingRecipes = isViewingRecipes;
    }
    public boolean onBackButtonPressed(){
        if(mIsViewingRecipes){
           mIsViewingRecipes = false;
           return false;
        }
        return true;
    }

}
