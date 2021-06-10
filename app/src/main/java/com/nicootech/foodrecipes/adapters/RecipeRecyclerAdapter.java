package com.nicootech.foodrecipes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicootech.foodrecipes.R;
import com.nicootech.foodrecipes.models.Recipe;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Recipe> mRecipe;
    private OnRecipeListener mOnRecipeListener;

    public RecipeRecyclerAdapter(List<Recipe> mRecipe, OnRecipeListener mOnRecipeListener) {
        this.mRecipe = mRecipe;
        this.mOnRecipeListener = mOnRecipeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent,false);
        return new RecipeViewHolder(view,mOnRecipeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecipeViewHolder)holder).title.setText(mRecipe.get(position).getTitle());
        ((RecipeViewHolder)holder).publisher.setText(mRecipe.get(position).getPublisher());
        ((RecipeViewHolder)holder).socialScore.setText(String.valueOf(Math.round(mRecipe.get(position).getSocial_rank())));

    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }

    public void setRecipe(List<Recipe>recipes){
        mRecipe = recipes;
        notifyDataSetChanged();
    }
}
