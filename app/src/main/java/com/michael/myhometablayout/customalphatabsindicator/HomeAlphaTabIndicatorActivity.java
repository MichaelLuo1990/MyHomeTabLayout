package com.michael.myhometablayout.customalphatabsindicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.michael.myhometablayout.R;
import com.michael.myhometablayout.customalphatabsindicator.alphatabs.AlphaTabsIndicator;
import com.michael.myhometablayout.customalphatabsindicator.alphatabs.OnTabChangedListner;

/**
 * Desc 点击/滑动底部tab渐变+指示器显示方式
 * reference https://github.com/yingLanNull/AlphaTabsIndicator
 * Created by Michael on 2018/3/15.
 */
public class HomeAlphaTabIndicatorActivity extends AppCompatActivity {

    private AlphaTabsIndicator alphaTabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_tabs_indicator);

        ViewPager mViewPger = (ViewPager) findViewById(R.id.mViewPager);//获取viewpager实例
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager());//实例化tabFragment显示页面适配器
        //tabFragment选中监听事件
        tabFragmentAdapter.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
//                Log.i("logInfo", "curSelectedTabNub:" + tabNum);
                switch (tabNum) {
                    case 0:
                        alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);//指示器数量-1操作
                        break;
                    case 2:
                        alphaTabsIndicator.getCurrentItemView().removeShow();//清除当前tab指示器提示数量
                        break;
                    case 3:
                        alphaTabsIndicator.removeAllBadge();//清空所有指示器提示数量
                        break;
                }
            }
        });
        mViewPger.setAdapter(tabFragmentAdapter);//适配器与viewpager绑定
        mViewPger.addOnPageChangeListener(tabFragmentAdapter);//viewpager添加页面切换改变监听事件
        //初始化自定义指示器&设置指示器
        alphaTabsIndicator = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPger);
        alphaTabsIndicator.getTabView(0).showNumber(6);
        alphaTabsIndicator.getTabView(1).showNumber(888);
        alphaTabsIndicator.getTabView(2).showNumber(88);
        alphaTabsIndicator.getTabView(3).showPoint();
    }

}
