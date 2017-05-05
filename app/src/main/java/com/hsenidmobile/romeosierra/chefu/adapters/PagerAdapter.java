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
                this.tabFragment = new TabFragment().setContent(new String[]{"Pizza 1", "Pizza 2", "Pizza 3", "Pizza 4", "Pizza 5"});
                break;

            case 1:
                this.tabFragment = new TabFragment().setContent(new String[]{"Pizza 2", "Pizza 3", "Pizza 4", "Pizza 5"});
                break;

            case 2:
                this.tabFragment = new TabFragment().setContent(new String[]{"Pizza 1", "Pizza 2"});
                break;
        }
        return this.tabFragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}