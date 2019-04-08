package com.example.appstore;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentationMagician;

public class BaseMainFragment extends BaseFragment {

    protected OnBackToFirstListener _mBackToFirstListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackToFirstListener) {
            _mBackToFirstListener = (OnBackToFirstListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _mBackToFirstListener = null;
    }




    public boolean onBackPressedSupport() {
        if (fragmentManager.getBackStackEntryCount() >= 1) {
            popChild(fragmentManager);
        } else {
            if (this instanceof FragmentEight) {   // 如果是 第一个Fragment 则退出app
                mActivity.finish();
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener.onBackToFirstFragment();
            }
        }
        return true;
    }

    private void popChild(FragmentManager fm) {
        FragmentationMagician.popBackStackAllowingStateLoss(fm);
        removeTopFragment(fm);
    }
    private void removeTopFragment(FragmentManager fm) {
        try { // Safe popBackStack()
            ISupportFragment top = SupportHelper.getBackStackTopFragment(fm);
            if (top != null) {
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .remove((Fragment) top)
                        .commitAllowingStateLoss();
            }
        } catch (Exception ignored) {

        }
    }
    public interface OnBackToFirstListener {
        void onBackToFirstFragment();
    }
}
