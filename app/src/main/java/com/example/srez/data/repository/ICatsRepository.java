package com.example.srez.data.repository;

import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

import retrofit2.Call;

public interface ICatsRepository {

    void setToLocalCats(List<CatResponsePOJO> list);

    Call<List<CatResponsePOJO>> loadCats();

    List<CatResponsePOJO> getFromLocalCats();
}
