package com.nicootech.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.request.RecipeApi;
import com.nicootech.foodrecipes.request.ServiceGenerator;
import com.nicootech.foodrecipes.request.responses.RecipeResponse;
import com.nicootech.foodrecipes.request.responses.RecipeSearchResponse;
import com.nicootech.foodrecipes.viewmodel.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeListActivity extends BaseActivity {
    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);

        subscribeObserver();
    }

    private void subscribeObserver(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

            }
        });
    }
    private void testRetrofitRequest(){
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

//        Call<RecipeSearchResponse> responseCall = recipeApi
//                .searchRecipe(
//                        "chicken breast",
//                        "1"
//                );
//        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//            @Override
//            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                Log.d(TAG, "onResponse: server response: "+response.toString());
//                if(response.code() == 200) {
//                    Log.d(TAG, "onResponse: " + response.body().toString());
//                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
//                    for (Recipe recipe : recipes) {
//                        Log.d(TAG, "onResponse: " + recipe.getTitle());
//                    }
//                }
//                else{
//                    try {
//                        Log.d(TAG, "onResponse: "+response.errorBody().string());
//
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//            }
//        });
        Call<RecipeResponse> responseCall = recipeApi
                .getRecipe(
                        "41470"
                );
        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: server response: "+response.toString());
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "onResponse: RETRIEVED RECIPE: "+ recipe.toString());
                }
                else{
                    try {
                        Log.d(TAG, "onResponse: "+response.errorBody().string());

                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }



}