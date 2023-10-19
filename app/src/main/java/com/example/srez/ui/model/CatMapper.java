package com.example.srez.ui.model;

import com.example.srez.data.model.CatResponsePOJOKt;

import java.util.ArrayList;
import java.util.List;

public class CatMapper {

    public static Cat map(CatResponsePOJOKt pojo) {

        return new Cat(pojo.getId(), pojo.getUrl());
    }

    public static List<Cat> mapList(List<CatResponsePOJOKt> list) {
        List<Cat> cats = new ArrayList<>();
        for (CatResponsePOJOKt pojo : list) {
            cats.add(map(pojo));
        }
        return cats;
    }
}
