package com.onistech.user.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.onistech.user.fragments.FragmentProducts;

public class Pageradapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public Pageradapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentProducts();
            case 1:
                return new FragmentProducts();
            case 2:
                return new FragmentProducts();
            default:
                return new FragmentProducts();
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}