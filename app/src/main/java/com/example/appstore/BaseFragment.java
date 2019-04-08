package com.example.appstore;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BaseFragment extends Fragment implements ISupportFragment{

    protected FragmentManager fragmentManager;
    protected BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        mActivity = (BaseActivity) context;
        super.onAttach(context);
    }

    /**
     * 添加 Fragment
     *
     * @param fragment
     */
    protected void loadRootFragment( Fragment fragment, String tag) {
        fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_container_two, fragment, tag);
        fragmentTransaction.commitAllowingStateLoss();

    }
    /**
     * 添加 Fragment
     *
     * @param fragment
     */
    protected void addFragment( Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.animator.fragment_slide_left_enter,
                R.animator.fragment_slide_left_exit,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit);
        fragmentTransaction.add(R.id.fl_container_two, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();

    }
    /**
     * 获取栈内的fragment对象
     */
    public <T extends ISupportFragment> T findChildFragment(Class<T> fragmentClass) {
        return SupportHelper.findFragment(getChildFragmentManager(), fragmentClass);
    }
    @Override
    public boolean onBackPressedSupport() {
        return false;
    }
}
