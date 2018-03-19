package com.michael.myhometablayout.customalphatabsindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.michael.myhometablayout.customalphatabsindicator.alphatabs.OnTabChangedListner;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc tab fragment内容页面适配器
 * Created by Michael on 2018/3/15.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = {"Chats", "Contacts", "Discover", "Me"};
    private OnTabChangedListner onTabChangedListner;

    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(TextFragment.newInstance(titles[0]));
        fragments.add(TextFragment.newInstance(titles[1]));
        fragments.add(TextFragment.newInstance(titles[2]));
        fragments.add(TextFragment.newInstance(titles[3]));
    }

    public void setOnTabChangedListner(OnTabChangedListner onTabChangedListner) {
        this.onTabChangedListner = onTabChangedListner;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        onTabChangedListner.onTabSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
