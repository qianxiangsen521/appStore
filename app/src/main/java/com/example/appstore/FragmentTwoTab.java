package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwoTab extends BaseFragment {


    public static FragmentTwoTab newInstance(){
        return new FragmentTwoTab();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_tab,null);
        view.findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(FragmentTab3.newInstance(), FragmentTab3.class.getName());
            }
        });
        return view;
    }

}
