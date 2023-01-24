package com.example.srez.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService instance;
    private Retrofit mRetrofit;
    private static final String BASE_URL = "https://api.thecatapi.com";

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        instance = new NetworkService();
        return instance;
    }

    public CatsApi getCatsApi() {
        return mRetrofit.create(CatsApi.class);
    }
}
