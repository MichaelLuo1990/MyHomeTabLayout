package com.michael.myhometablayout.tablayoutviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Desc fragment适配器
 * Created by Michael on 2018/3/16.
 */

public class MyVPFragmentPagerAdapter extends FragmentPagerAdapter{

    //Fragment 数组
    private final Fragment[] TAB_FRAGMENTS = new Fragment[]{new OneFragment(), new TwoFragment(), new ThreeFragment(), new FourFragment()};

    public MyVPFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TAB_FRAGMENTS[position];
    }

    @Override
    public int getCount() {
        return TAB_FRAGMENTS.length;
    }
}
