package com.example.recyclerretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataInterface {
    @GET("cars_list.json")
    Call<List<ModelClass>> getData();
    @GET("cars_list.json")
    Call<List<MoviesModel>> getMoveis();
}
