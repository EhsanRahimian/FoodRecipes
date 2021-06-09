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
import com.nicootech.foodrecipes.viewmodel.Testing;

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
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }

    private void subscribeObserver(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if(recipes !=null){
                    for(Recipe recipe:recipes){
                        Log.d(TAG, "onChanged: "+recipe.getTitle());
                        //the above log or the line below:
                        //Testing.printRecipes(recipes,"recipes test");
                    }
                }
            }
        });
    }
    private void searchRecipeApi(String query, int pageNumber){
        mRecipeListViewModel.searchRecipeApi(query,pageNumber);
    }
    private void testRetrofitRequest(){
        searchRecipeApi("chicken", 1);
    }



}