package com.nicootech.foodrecipes.viewmodel;


import com.nicootech.foodrecipes.models.Recipe;

import java.util.List;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {

    private MutableLiveData<List<Recipe>> mRecipe = new MutableLiveData<>();

    public RecipeListViewModel() {

    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipe;

    }
}