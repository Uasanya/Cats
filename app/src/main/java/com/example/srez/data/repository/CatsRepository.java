package com.example.srez.data.repository;

import android.content.Context;

import com.example.srez.data.datasoucre.CatsLocalDataSource;
import com.example.srez.data.datasoucre.CatsRemoteDataSource;
import com.example.srez.data.datasoucre.ICatsLocalDataSource;
import com.example.srez.data.datasoucre.ICatsRemoteDataSource;
import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

import retrofit2.Call;

public class CatsRepository implements ICatsRepository {

    private final ICatsRemoteDataSource remoteDataSource = new CatsRemoteDataSource();
    private final ICatsLocalDataSource localDataSource;

    public CatsRepository(Context context) {
        localDataSource = new CatsLocalDataSource(context);
    }

    @Override
    public void setToLocalCats(List<CatResponsePOJO> list) {
        localDataSource.setCats(list);
    }

    @Override
    public Call<List<CatResponsePOJO>> loadCats() {
        return remoteDataSource.getCallCats();
    }

    @Override
    public List<CatResponsePOJO> getFromLocalCats() {
        return localDataSource.getCats();
    }

}

