package com.nicootech.foodrecipes.viewmodel;


import android.widget.SearchView;

import com.nicootech.foodrecipes.models.Recipe;

import com.nicootech.foodrecipes.repositories.RecipeRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;
    private boolean mIsViewingRecipes;
    public boolean mIsPerformingQuery;


    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
        mIsPerformingQuery = false;
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeRepository.getRecipes();
    }

    public void searchRecipeApi(String query, int pageNumber){
        mIsViewingRecipes = true;
        mIsPerformingQuery = true;
        mRecipeRepository.searchRecipeApi(query,pageNumber);
    }


    public void searchNextPage(){
        if(!mIsPerformingQuery && mIsViewingRecipes){
            mRecipeRepository.searchNextPage();
        }
    }
    public boolean isPerformingQuery() {
        return mIsPerformingQuery;
    }

    public boolean isViewingRecipes(){
        return mIsViewingRecipes;
    }

    public void setIsViewingRecipes(boolean isViewingRecipes) {
        mIsViewingRecipes = isViewingRecipes;
    }
    public void setIsPerformingQuery(boolean isPerformingQuery) {
        mIsPerformingQuery = isPerformingQuery;
    }
    public boolean onBackButtonPressed(){
        if(mIsPerformingQuery){
           //cancel query
            mRecipeRepository.cancelRequest();
            mIsPerformingQuery = false;
        }
        if(mIsViewingRecipes){
           mIsViewingRecipes = false;
           return false;
        }
        return true;
    }


}
