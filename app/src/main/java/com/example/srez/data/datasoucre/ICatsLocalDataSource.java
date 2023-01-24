package com.example.srez.data.datasoucre;

import com.example.srez.data.model.CatResponsePOJO;

import java.util.List;

public interface ICatsLocalDataSource {

    List<CatResponsePOJO> getCats();

    void setCats(List<CatResponsePOJO> list);
}
