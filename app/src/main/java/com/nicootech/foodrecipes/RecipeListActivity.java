package com.nicootech.foodrecipes;

import android.os.Bundle;
import android.util.Log;
import com.nicootech.foodrecipes.adapters.OnRecipeListener;
import com.nicootech.foodrecipes.adapters.RecipeRecyclerAdapter;
import com.nicootech.foodrecipes.models.Recipe;
import com.nicootech.foodrecipes.viewmodel.RecipeListViewModel;
import com.nicootech.foodrecipes.viewmodel.Testing;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class RecipeListActivity extends BaseActivity implements OnRecipeListener {
    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecyclerView = findViewById(R.id.recipe_list);
        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);

        initRecyclerView();
        subscribeObserver();
        testRetrofitRequest();

    }

    private void subscribeObserver(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if(recipes !=null) {

                    Testing.printRecipes(recipes, "recipes test");
                }
                mAdapter.setRecipes(recipes);
            }
        });
    }
    private void testRetrofitRequest(){
        mRecipeListViewModel.searchRecipeApi("bbq", 1);
    }

    private void initRecyclerView(){
        mAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRecipeClick(int position) {
        Log.d(TAG, "onRecipeClick: clicked. " + position);
    }

    @Override
    public void onCategoryClick(String category) {

    }
}
