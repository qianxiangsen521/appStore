package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTab3 extends BaseFragment {


    public static FragmentTab3 newInstance(){
        return new FragmentTab3();
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_tab3,null);
        final TextView viewById = view.findViewById(R.id.text);
        viewById  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewById.setText(FragmentTab3.class.getName());

            }
        });
        return view;
    }

}
