package com.nicootech.foodrecipes.viewmodel;

import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.viewmodel.repositories.RecipeRepository;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeRepository.getRecipes();
    }

    public void searchRecipeApi(String query, int pageNumber){
        mRecipeRepository.searchRecipeApi(query,pageNumber);
    }



}
