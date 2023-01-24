package com.example.srez.ui.model;

import com.example.srez.data.model.CatResponsePOJO;

import java.util.ArrayList;
import java.util.List;

public class CatMapper {

    public static Cat map(CatResponsePOJO pojo) {

        return new Cat(pojo.getId(), pojo.getUrl());
    }

    public static List<Cat> mapList(List<CatResponsePOJO> list) {
        List<Cat> cats = new ArrayList<>();
        for (CatResponsePOJO pojo : list) {
            cats.add(map(pojo));
        }
        return cats;
    }
}
