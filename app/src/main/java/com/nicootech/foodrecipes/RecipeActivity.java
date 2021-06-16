package com.nicootech.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.repositories.RecipeViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class RecipeActivity extends BaseActivity {

    private static final String TAG = "RecipeActivity";

    private AppCompatImageView mRecipeImage;
    private TextView mRecipeTitle, mRecipeRank;
    private LinearLayout mRecipeIngredientsContainer;
    private ScrollView mScrollView;

    private RecipeViewModel mRecipeViewModel;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeTitle = findViewById(R.id.recipe_title);
        mRecipeRank = findViewById(R.id.recipe_social_score);
        mRecipeIngredientsContainer = findViewById(R.id.ingredients_container);
        mScrollView = findViewById(R.id.parent);

        mRecipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);

        subscribeObservers();
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("recipe")){
            Recipe recipe = getIntent().getParcelableExtra("recipe");
            Log.d(TAG, "getIncomingIntent: " + recipe.getTitle());
            mRecipeViewModel.searchRecipeById(recipe.getRecipe_id());
        }
    }
    private void subscribeObservers(){
        mRecipeViewModel.getRecipe().observe(this, new Observer<Recipe>() {
            @Override
            public void onChanged(@Nullable Recipe recipe) {

                if(recipe != null){
                    Log.d(TAG, "onChanged: ......................................... ");
                    Log.d(TAG, "onChanged: "+recipe.getTitle());
                    for(String ingredient : recipe.getIngredients()){
                        Log.d(TAG, "onChanged: "+ ingredient);
                    }
                }
            }
        });
    }
}
