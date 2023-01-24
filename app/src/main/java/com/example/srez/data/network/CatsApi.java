package com.example.srez.data.network;

import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatsApi {
    @GET("v1/images/search?limit=10")
    Call<List<CatResponsePOJO>> getCats();
}
