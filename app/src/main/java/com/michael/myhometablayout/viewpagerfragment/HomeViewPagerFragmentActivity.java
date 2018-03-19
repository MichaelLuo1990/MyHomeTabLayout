package com.michael.myhometablayout.viewpagerfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.myhometablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc viewpager+fragment方式实现
 * Created by Michael on 2018/3/11.
 */
public class HomeViewPagerFragmentActivity extends FragmentActivity implements OnClickListener {
    //声明ViewPager
    private ViewPager mViewPager;
    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;

    //声明四个Tab
    private LinearLayout llTabOne, llTabTwo, llTabThree, llTabFour;

    //声明四个ImageButton
    private ImageButton ibTabOne, ibTabTwo, ibTabThree, ibTabFour;

    //声明4个Tab的TextView
    private TextView tvTabOne, tvTabTwo, tvTabThree, tvTabFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewpager_fragment);
        initViews();//初始化控件
        initEvents();//初始化事件
        initDatas();//初始化数据
    }

    private void initDatas() {
        mFragments = new ArrayList<>();
        //将四个Fragment加入集合中
        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());
        mFragments.add(new FourFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };
        //不要忘记设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvents() {
        //设置四个Tab的点击事件
        llTabOne.setOnClickListener(this);
        llTabTwo.setOnClickListener(this);
        llTabThree.setOnClickListener(this);
        llTabFour.setOnClickListener(this);

    }

    //初始化控件
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        //初始化四个Tab的布局文件
        llTabOne = (LinearLayout) findViewById(R.id.ll_tab_one);
        llTabTwo = (LinearLayout) findViewById(R.id.ll_tab_two);
        llTabThree = (LinearLayout) findViewById(R.id.ll_tab_three);
        llTabFour = (LinearLayout) findViewById(R.id.ll_tab_four);
        //初始化四个ImageButton
        ibTabOne = (ImageButton) findViewById(R.id.ib_tab_one_img);
        ibTabTwo = (ImageButton) findViewById(R.id.ib_tab_two_img);
        ibTabThree = (ImageButton) findViewById(R.id.ib_tab_three_img);
        ibTabFour = (ImageButton) findViewById(R.id.ib_tab_four_img);

        //初始化四个TextView
        tvTabOne = (TextView) findViewById(R.id.tv_tab_one);
        tvTabTwo = (TextView) findViewById(R.id.tv_tab_two);
        tvTabThree = (TextView) findViewById(R.id.tv_tab_three);
        tvTabFour = (TextView) findViewById(R.id.tv_tab_four);

    }

    @Override
    public void onClick(View v) {
        //先将四个ImageButton置为灰色
        resetImgs();
        //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
        switch (v.getId()) {
            case R.id.ll_tab_one:
                selectTab(0);//当点击的是微信的Tab就选中微信的Tab
                break;
            case R.id.ll_tab_two:
                selectTab(1);
                break;
            case R.id.ll_tab_three:
                selectTab(2);
                break;
            case R.id.ll_tab_four:
                selectTab(3);
                break;
        }
    }

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                ibTabOne.setImageResource(R.mipmap.tab_one_pressed);
                tvTabOne.setTextColor(Color.parseColor("#1296db"));
                break;
            case 1:
                ibTabTwo.setImageResource(R.mipmap.tab_two_pressed);
                tvTabTwo.setTextColor(Color.parseColor("#1296db"));
                break;
            case 2:
                ibTabThree.setImageResource(R.mipmap.tab_three_pressed);
                tvTabThree.setTextColor(Color.parseColor("#1296db"));
                break;
            case 3:
                ibTabFour.setImageResource(R.mipmap.tab_four_pressed);
                tvTabFour.setTextColor(Color.parseColor("#1296db"));
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    //将四个ImageButton设置为灰色
    private void resetImgs() {
        ibTabOne.setImageResource(R.mipmap.tab_one_normal);
        ibTabTwo.setImageResource(R.mipmap.tab_two_normal);
        ibTabThree.setImageResource(R.mipmap.tab_three_normal);
        ibTabFour.setImageResource(R.mipmap.tab_four_normal);
        tvTabOne.setTextColor(Color.parseColor("#8a8a8a"));
        tvTabTwo.setTextColor(Color.parseColor("#8a8a8a"));
        tvTabThree.setTextColor(Color.parseColor("#8a8a8a"));
        tvTabFour.setTextColor(Color.parseColor("#8a8a8a"));
    }
}
