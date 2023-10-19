package com.example.srez.ui.catsinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.srez.R;
import com.example.srez.ui.base.BaseFragment;
import com.example.srez.ui.model.Cat;
import com.example.srez.ui.utils.GlideUtils;

import java.io.Serializable;


public class CatInfoFragment extends BaseFragment implements Serializable {

    private Cat cat;
    private static final String ARG_PARAM = "key";

    public static Fragment newInstance(Cat cat) {
        CatInfoFragment catInfoFragment = new CatInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, cat);
        catInfoFragment.setArguments(args);
        return catInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cat = (Cat) getArguments().getSerializable(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cat_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvCatId = view.findViewById(R.id.tv_cat_id);
        ImageView ivCat = view.findViewById(R.id.iv_cat);
        tvCatId.setText(cat.getId());
        GlideUtils.loadImage(ivCat, cat.getImage());
        Button back = view.findViewById(R.id.b_back);
        back.setOnClickListener(view1 -> {
            navigateBack();
        });
    }
}