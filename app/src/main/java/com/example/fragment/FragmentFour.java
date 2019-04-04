package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appstore.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FragmentFour extends SupportFragment {



    public static FragmentFour newInstance(){
        return new FragmentFour();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_four,null);
        view.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(FragmentFives.newInstance());
            }
        });
        return view;
    }


}
