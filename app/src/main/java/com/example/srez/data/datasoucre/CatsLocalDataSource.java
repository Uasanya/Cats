package com.example.srez.data.datasoucre;

import android.content.Context;

import com.example.srez.data.local.Cache;
import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

public class CatsLocalDataSource implements ICatsLocalDataSource {

    private final Cache cache;

    public CatsLocalDataSource(Context context) {
        cache = new Cache(context);
    }

    @Override
    public List<CatResponsePOJO> getCats() {
        return cache.getCatsImages();
    }

    @Override
    public void setCats(List<CatResponsePOJO> list) {
        cache.putCatImages(list);
    }
}
