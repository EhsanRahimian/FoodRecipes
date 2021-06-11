package com.nicootech.foodrecipes.request;

import com.nicootech.foodrecipes.request.responses.RecipeResponse;
import com.nicootech.foodrecipes.request.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //SEARCH => https://recipesapi.herokuapp.com/api/v2/recipes
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("q") String query,
            @Query("page") String page
    );

    //GET => https://recipesapi.herokuapp.com/api/get?rId=41470
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("rId") String recipe_id
    );
}
