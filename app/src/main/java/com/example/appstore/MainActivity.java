package com.example.appstore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;


public class MainActivity extends BaseActivity implements BaseMainFragment.OnBackToFirstListener {

    public FragmentManager fragmentManager;
    public static int mFragCurrentIndex = 0;

    private FragmentEight fragmentEight;
    private FragmentSeven fragmentSeven;
    private FragmentTab fragmentTab;
    private BottomNavigationView navigation;

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


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switchFragment(mFragCurrentIndex,true);
    }


    private void switchFragment(int index, boolean isFirst) {
        if (mFragCurrentIndex == index && !isFirst) {
            //清空全部
            if (index == 0){
                if (fragmentEight.fragmentManager.getBackStackEntryCount() >= 1){
                    fragmentEight.fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }else if (index == 1){
                if (fragmentSeven.fragmentManager.getBackStackEntryCount() >= 1){
                    fragmentSeven.fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }else if (index == 2){
                if (fragmentTab.fragmentManager.getBackStackEntryCount() >= 1){
                    fragmentTab.fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
        ISupportFragment activeFragment = SupportHelper.getActiveFragment(getSupportFragmentManager());
        if (dispatchBackPressedEvent(activeFragment)){
            return;
        }
        super.onBackPressed();
    }

    /**
     * Dispatch the pop-event. Priority of the top of the stack of Fragment
     */
    boolean dispatchBackPressedEvent(ISupportFragment activeFragment) {
        if (activeFragment != null) {
            boolean result = activeFragment.onBackPressedSupport();
            if (result) {
                return true;
            }

            Fragment parentFragment = ((Fragment) activeFragment).getParentFragment();
            if (dispatchBackPressedEvent((BaseMainFragment) parentFragment)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackToFirstFragment() {
        navigation.setSelectedItemId(R.id.navigation_home);

    }
}
