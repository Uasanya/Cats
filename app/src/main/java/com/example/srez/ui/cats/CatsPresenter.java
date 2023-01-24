package com.example.srez.ui.cats;

import android.content.Context;

import com.example.srez.data.model.CatResponsePOJO;
import com.example.srez.data.repository.CatsRepository;
import com.example.srez.data.repository.ICatsRepository;
import com.example.srez.ui.model.CatMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsPresenter implements ICatsPresenter {

    private CatsView catsView;
    private final ICatsRepository catsRepository;

    public CatsPresenter(CatsView catsView, Context context) {
        this.catsView = catsView;
        catsRepository = new CatsRepository(context);
    }

    @Override
    public void getCats() {
        catsRepository.loadCats().enqueue(new Callback<List<CatResponsePOJO>>() {

            @Override
            public void onResponse(Call<List<CatResponsePOJO>> call, Response<List<CatResponsePOJO>> response) {
                if (response.body() != null) {
                    catsRepository.setToLocalCats(response.body());
                    catsView.showCats(CatMapper.mapList(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<CatResponsePOJO>> call, Throwable t) {
                catsView.showToast();
                List<CatResponsePOJO> list = catsRepository.getFromLocalCats();
                if (list != null || !list.isEmpty()) {
                    catsView.showCats(CatMapper.mapList(list));
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
