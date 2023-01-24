package com.example.srez.ui.cats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srez.R;
import com.example.srez.ui.base.BaseFragment;
import com.example.srez.ui.catsinfo.CatInfoFragment;
import com.example.srez.ui.model.Cat;

import java.util.List;


public class CatsMVPFragment extends BaseFragment implements CatListener, CatsView {

    private TextView tvNoData;
    private RecyclerView rv;
    private ICatsPresenter iCatsPresenter;
    private CatAdapter catAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iCatsPresenter = new CatsPresenter(this, getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cats_mvp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNoData = view.findViewById(R.id.tv_no_data);
        catAdapter = new CatAdapter(getContext(), this);
        rv = view.findViewById(R.id.rv);
        rv.setAdapter(catAdapter);
        iCatsPresenter.getCats();
    }

    @Override
    public void onCatClick(Cat cat) {
        navigate(CatInfoFragment.newInstance(cat));
    }

    @Override
    public void showCats(List<Cat> cats) {
        catAdapter.setCats(cats);
    }

    @Override
    public void showNoData() {
        tvNoData.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
    }

    @Override
    public void showToast() {
        showToast(R.string.wrong);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iCatsPresenter.onDestroy();
    }
}