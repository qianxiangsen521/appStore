package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwoSix extends BaseFragment {


    public static FragmentTwoSix newInstance(){
        return new FragmentTwoSix();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_seven,null);
        view.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(FragmentTab2.newInstance(),FragmentTab2.class.getName());
            }
        });
        return view;
    }

}
