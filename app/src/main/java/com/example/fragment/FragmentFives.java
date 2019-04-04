package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentFives extends SupportFragment {


    public static FragmentFives newInstance(){
        return new FragmentFives();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_fives,null);

        return view;
    }


}
