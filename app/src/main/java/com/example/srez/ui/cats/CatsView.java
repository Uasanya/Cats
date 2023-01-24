package com.example.srez.ui.cats;

import com.example.srez.ui.model.Cat;

import java.util.List;

public interface CatsView {

    void showCats(List<Cat> cats);

    void showNoData();

    void showToast();
}
