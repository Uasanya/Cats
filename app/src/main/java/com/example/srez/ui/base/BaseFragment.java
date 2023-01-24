package com.example.srez.ui.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.srez.R;

public abstract class BaseFragment extends Fragment {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = requireActivity().getSupportFragmentManager();
        ft = fm.beginTransaction();
    }

    protected void navigate(Fragment fragment) {
        ft.replace(R.id.container, fragment).commit();
    }

    protected void showToast(@StringRes Integer res) {
        Toast.makeText(getActivity(), res, Toast.LENGTH_LONG).show();
    }
}
