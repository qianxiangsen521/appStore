//package com.example.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.appstore.FragmentSix;
//import com.example.appstore.R;
//
//import me.yokeyword.fragmentation.SupportFragment;
//
//
//public class FragmentTwo extends SupportFragment {
//
//
//    public static FragmentTwo newInstance(){
//        return new FragmentTwo();
//    }
//
//    private View view;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view  = inflater.inflate(R.layout.fragment_two,null);
//
//        return view;
//    }
//
//
//}