package com.michael.myhometablayout.onlyviewpager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.myhometablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc 纯viewpager实现
 * Created by Michael on 2018/3/11.
 */
public class HomeViewPagerActivity extends Activity implements OnClickListener {
    //声明ViewPager
    private ViewPager mViewpager;

    //声明四个Tab
    private LinearLayout llTabOne, llTabTwo, llTabThree, llTabFour;

    //声明四个ImageButton
    private ImageButton ibTabOne, ibTabTwo, ibTabThree, ibTabFour;

    //声明4个Tab的TextView
    private TextView tvTabOne, tvTabTwo, tvTabThree, tvTabFour;

    //声明ViewPager的适配器
    private PagerAdapter mAdpater;
    //用于装载四个Tab的List
    private List<View> mTabs = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉TitleBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewpager_only);
        initViews();//初始化控件
        initDatas();//初始化数据
        initEvents();//初始化事件

    }

    private void initEvents() {
        //设置四个Tab的点击事件
        llTabOne.setOnClickListener(this);
        llTabTwo.setOnClickListener(this);
        llTabThree.setOnClickListener(this);
        llTabFour.setOnClickListener(this);

        //添加ViewPager的切换Tab的监听事件
        mViewpager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //获取ViewPager的当前Tab
                int currentItem = mViewpager.getCurrentItem();
                //将所以的ImageButton设置成灰色
                resetImgs();
                //将当前Tab对应的ImageButton设置成绿色
                switch (currentItem) {
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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化ViewPager的适配器
     */
    private void initDatas() {
        mAdpater = new PagerAdapter() {
            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mTabs.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
                container.removeView(mTabs.get(position));
            }
        };
        //设置ViewPager的适配器
        mViewpager.setAdapter(mAdpater);
    }

    //初始化控件
    private void initViews() {
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);

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

        //获取到四个Tab
        LayoutInflater inflater = LayoutInflater.from(this);
        View tab1 = inflater.inflate(R.layout.layout_tab_one, null);
        View tab2 = inflater.inflate(R.layout.layout_tab_two, null);
        View tab3 = inflater.inflate(R.layout.layout_tab_three, null);
        View tab4 = inflater.inflate(R.layout.layout_tab_four, null);

        //将四个Tab添加到集合中
        mTabs.add(tab1);
        mTabs.add(tab2);
        mTabs.add(tab3);
        mTabs.add(tab4);

    }

    @Override
    public void onClick(View v) {
        //先将四个ImageButton都设置成灰色
        resetImgs();
        switch (v.getId()) {
            case R.id.ll_tab_one:
                //设置viewPager的当前Tab
                mViewpager.setCurrentItem(0);
                ibTabOne.setImageResource(R.mipmap.tab_one_pressed);
                tvTabOne.setTextColor(Color.parseColor("#1296db"));
                break;
            case R.id.ll_tab_two:
                mViewpager.setCurrentItem(1);
                ibTabTwo.setImageResource(R.mipmap.tab_two_pressed);
                tvTabTwo.setTextColor(Color.parseColor("#1296db"));
                break;
            case R.id.ll_tab_three:
                mViewpager.setCurrentItem(2);
                ibTabThree.setImageResource(R.mipmap.tab_three_pressed);
                tvTabThree.setTextColor(Color.parseColor("#1296db"));
                break;
            case R.id.ll_tab_four:
                mViewpager.setCurrentItem(3);
                ibTabFour.setImageResource(R.mipmap.tab_four_pressed);
                tvTabFour.setTextColor(Color.parseColor("#1296db"));
                break;
        }
    }

    //将四个ImageButton设置成灰色
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
