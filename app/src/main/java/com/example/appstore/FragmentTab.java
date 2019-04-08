package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTab extends BaseMainFragment {


    public static FragmentTab newInstance() {
        return new FragmentTab();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, null);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (findChildFragment(FragmentTwoTab.class) == null) {
            loadRootFragment(FragmentTwoTab.newInstance(),FragmentTwoTab.class.getName());
        }
    }

}