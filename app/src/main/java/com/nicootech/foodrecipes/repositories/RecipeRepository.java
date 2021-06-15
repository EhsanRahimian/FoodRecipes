package com.nicootech.foodrecipes.repositories;

import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.request.RecipeApiClient;
import java.util.List;
import androidx.lifecycle.LiveData;

public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;
    private String mQuery;
    private int mPageNumber;

    public static RecipeRepository getInstance(){
        if(instance == null){
            instance = new RecipeRepository();
        }
        return instance;
    }

    private RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipeApi(String query, int pageNumber){
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mQuery = query;
        mPageNumber = pageNumber;
        mRecipeApiClient.searchRecipesApi(query,pageNumber);
    }
    public void searchNextPage(){
        searchRecipeApi(mQuery,mPageNumber+1);
    }

    public void cancelRequest(){
        mRecipeApiClient.cancelRequest();
    }


}
