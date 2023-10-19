package com.example.srez.ui.cats;

import android.content.Context;


import com.example.srez.data.model.CatResponsePOJOKt;
import com.example.srez.data.repository.CatsRepositoryKt;
import com.example.srez.data.repository.ICatsRepositoryKt;
import com.example.srez.ui.model.CatMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsPresenter implements ICatsPresenter {

    private CatsView catsView;
    private final ICatsRepositoryKt catsRepository;

    public CatsPresenter(CatsView catsView, Context context) {
        this.catsView = catsView;
        catsRepository = new CatsRepositoryKt(context);
    }

    @Override
    public void getCats() {
        catsRepository.loadCats().enqueue(new Callback<List<CatResponsePOJOKt>>() {

            @Override
            public void onResponse(Call<List<CatResponsePOJOKt>> call, Response<List<CatResponsePOJOKt>> response) {
                if (response.body() != null) {
                    catsRepository.setLocalCats(response.body());
                    catsView.showCats(CatMapper.mapList(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<CatResponsePOJOKt>> call, Throwable t) {
                catsView.showToast();
                List<CatResponsePOJOKt> list = catsRepository.getFromLocalCats();
                if (list != null) {
                    if (!list.isEmpty()) {
                        catsView.showCats(CatMapper.mapList(list));
                    } else {
                        catsView.showNoData();
                    }
                } else {
                    catsView.showNoData();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        catsView = null;
    }
}
