package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fragment.FragmentOne;
import com.example.fragment.FragmentThree;
import com.example.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;
    public static int mFragCurrentIndex = 0;

    private FragmentEight fragmentEight;
    private FragmentSeven fragmentSeven;
    private FragmentTab fragmentTab;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(0,false);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(1,false);
                    return true;
                case R.id.navigation_notifications:
                    switchFragment(2,false);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(0);
        switchFragment(mFragCurrentIndex,true);
    }


    private void switchFragment(int index, boolean isFirst) {
        if (mFragCurrentIndex == index && !isFirst) {
            //清空全部
            if (fragmentEight.fragmentManager != null){
                if (fragmentEight.fragmentManager.getBackStackEntryCount() >= 1){
                    fragmentEight.fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
            return;
        }
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        Fragment fragmentNow = fragmentManager.findFragmentByTag("home" + mFragCurrentIndex);
        if (fragmentNow != null) {

            fragmentManager.beginTransaction().hide(fragmentNow).commit();
        }
        Fragment fragment = fragmentManager.findFragmentByTag("home" + index);
        if (fragment == null) {
            fragment = createMainFragment(index);
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment, "home" +
                    index)
                    .commit();
        } else {
            fragmentManager.beginTransaction().show(fragment).commit();
        }
        mFragCurrentIndex = index;
    }

    private Fragment createMainFragment(int index) {
        Fragment fragment = null;
        switch (index) {
            case 0:
                if (fragmentEight == null) {
                    fragmentEight = FragmentEight.newInstance();
                }
                fragment = fragmentEight;

                break;
            case 1:
                if (fragmentSeven == null) {
                    fragmentSeven = FragmentSeven.newInstance();
                }
                fragment = fragmentSeven;
                break;
            case 2:
                if (fragmentTab == null) {
                    fragmentTab = FragmentTab.newInstance();
                }
                fragment = fragmentTab;
                break;

            default:
                break;
        }
        return fragment;
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
