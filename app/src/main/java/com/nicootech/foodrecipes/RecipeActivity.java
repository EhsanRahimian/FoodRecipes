package com.nicootech.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.nicootech.foodrecipes.models.Recipe;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class RecipeActivity extends BaseActivity {

    private static final String TAG = "RecipeActivity";

    private AppCompatImageView mRecipeImage;
    private TextView mRecipeTitle, mRecipeRank;
    private LinearLayout mRecipeIngredientsContainer;
    private ScrollView mScrollView;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeTitle =findViewById(R.id.recipe_title);
        mRecipeRank = mRecipeTitle =findViewById(R.id.recipe_social_score);
        mRecipeIngredientsContainer = findViewById(R.id.ingredients_container);
        mScrollView = findViewById(R.id.parent);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
      if(getIntent().hasExtra("recipe")){
          Recipe recipe = getIntent().getParcelableExtra("recipe");
          Log.d(TAG, "getIncomingIntent: "+recipe.getTitle());
      }
    }
}
