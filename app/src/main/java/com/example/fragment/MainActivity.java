package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.appstore.R;
import com.example.view.BottomBar;
import com.example.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends SupportActivity{
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;


    private SupportFragment[] mFragments = new SupportFragment[5];

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_activity_main);

        SupportFragment firstFragment = findFragment(FragmentOne.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FragmentOne.newInstance();
            mFragments[SECOND] = FragmentTwo.newInstance();
            mFragments[THIRD] = FragmentThree.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]
                );
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(FragmentTwo.class);
            mFragments[THIRD] = findFragment(FragmentThree.class);
        }

        initView();
    }

    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.index_zhuanqu,
                getString(R.string.app_recommend)))
                .addItem(new BottomBarTab(this, R.mipmap.index_zhibo,
                        getString(R.string.app_live)))
                .addItem(new BottomBarTab(this, R.mipmap.index_play, getString(R.string.app_classification))
                );

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
                // 如果不在该类别Fragment的主页,则回到主页;
                if (count > 1) {
                    if (currentFragment instanceof FragmentOne) {
                        currentFragment.popToChild(FragmentFour.class, false);
                    } else if (currentFragment instanceof FragmentTwo) {
//                        currentFragment.popToChild(ViewPagerFragment.class, false);
                    } else if (currentFragment instanceof FragmentThree) {
//                        currentFragment.popToChild(ShopFragment.class, false);
                    }
//
                    return;
                }

            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

}
