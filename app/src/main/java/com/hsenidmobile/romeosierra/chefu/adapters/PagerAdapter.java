package com.hsenidmobile.romeosierra.chefu.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hsenidmobile.romeosierra.chefu.fragments.TabFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private TabFragment tabFragment;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        this.tabFragment = null;
        switch (position) {
            case 0:
                this.tabFragment = new TabFragment().setContent("http://demo7836701.mockable.io/food/favorite");
                break;

            case 1:
                this.tabFragment = new TabFragment().setContent("http://demo7836701.mockable.io/food/popular");
                break;

            case 2:
                this.tabFragment = new TabFragment().setContent("http://demo7836701.mockable.io/food/recents");
                break;
        }
        return this.tabFragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}