package com.nicootech.foodrecipes.request;

import com.nicootech.foodrecipes.AppExecutors;
import com.nicootech.foodrecipes.models.Recipe;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import static com.nicootech.foodrecipes.util.Constants.NETWORK_TIMEOUT;

public class RecipeApiClient {
    private static RecipeApiClient instance;

    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeApiClient getInstance(){
        if(instance == null){
            instance = new RecipeApiClient();
        }
        return instance;
    }

    private RecipeApiClient(){
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipes;
    }

    public void searchRecipeApi(){
        final Future handler = AppExecutors.getInstance().networkIO().submit(new Runnable() {
            @Override
            public void run() {
                // Retrieve data from api
                // mRecipe.postValue();
            }
        });

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //let the user know its timed out
                handler.cancel(true);
            }
        } , NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }


}
