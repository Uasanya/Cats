package com.example.srez.data.datasoucre;

import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

import retrofit2.Call;

public interface ICatsRemoteDataSource {

    Call<List<CatResponsePOJO>> getCallCats();
}
