package com.example.srez.data.datasoucre;

import com.example.srez.data.model.CatResponsePOJO;
import com.example.srez.data.network.NetworkService;

import java.util.List;

import retrofit2.Call;

public class CatsRemoteDataSource implements ICatsRemoteDataSource {
    @Override
    public Call<List<CatResponsePOJO>> getCallCats() {
        return NetworkService.getInstance().getCatsApi().getCats();
    }
}
