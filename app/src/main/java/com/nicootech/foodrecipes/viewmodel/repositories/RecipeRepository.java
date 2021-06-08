package com.nicootech.foodrecipes.viewmodel.repositories;

import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.request.RecipeApiClient;
import java.util.List;
import androidx.lifecycle.LiveData;

public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRepository getInstance(){
        if(instance == null){
            instance = new RecipeRepository();
        }
        return instance;
    }

    public RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }


}
