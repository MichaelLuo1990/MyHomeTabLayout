package com.michael.myhometablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.michael.myhometablayout.activitygroup.AtyGroupTabActivity;
import com.michael.myhometablayout.bottomnavigationviewvp.HomeBottomNavigationViewVPActivity;
import com.michael.myhometablayout.customalphatabsindicator.HomeATIOtherStyleActivity;
import com.michael.myhometablayout.customalphatabsindicator.HomeAlphaTabIndicatorActivity;
import com.michael.myhometablayout.customscalebgchange.HomeScaleBgChangeActivity;
import com.michael.myhometablayout.onlyfragment.HomeFragmentActivity;
import com.michael.myhometablayout.onlyviewpager.HomeViewPagerActivity;
import com.michael.myhometablayout.tabhost.HomeTabHostActivity;
import com.michael.myhometablayout.tablayoutviewpager.HomeTabLayoutVPActivity;
import com.michael.myhometablayout.viewpagerfragment.HomeViewPagerFragmentActivity;

/**
 * Desc 首页显示布局实现方式解析/测试（入口）
 * Created by Michael on 2018/3/11.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 显示viewpager实现方式
     *
     * @param view
     */
    public void toAtyGroupTabAtyClick(View view) {
        Intent intent = new Intent(this, AtyGroupTabActivity.class);
        startActivity(intent);
    }

    /**
     * 显示tabHost实现方式
     *
     * @param view
     */
    public void toTabHostAtyClick(View view) {
        Intent intent = new Intent(this, HomeTabHostActivity.class);
        startActivity(intent);
    }

    /**
     * 显示tabHost实现方式
     *
     * @param view
     */
    public void toOnlyViewPagerAtyClick(View view) {
        Intent intent = new Intent(this, HomeViewPagerActivity.class);
        startActivity(intent);
    }

    /**
     * 显示fragment实现方式
     *
     * @param view
     */
    public void toOnlyFragmentAtyClick(View view) {
        Intent intent = new Intent(this, HomeFragmentActivity.class);
        startActivity(intent);
    }

    /**
     * 显示viewpager+fragment实现方式
     *
     * @param view
     */
    public void toVpFgAtyClick(View view) {
        Intent intent = new Intent(this, HomeViewPagerFragmentActivity.class);
        startActivity(intent);
    }

    /**
     * 自定义alphaTabsIndicator+viewpager(绑定fragment)实现
     *
     * @param view
     */
    public void toCusATIAtyClick(View view) {
        Intent intent = new Intent(this, HomeAlphaTabIndicatorActivity.class);
        startActivity(intent);
    }

    /**
     * 其他布局风格样式-自定义alphaTabsIndicator
     *
     * @param view
     */
    public void toATIOtherStyleAtyClick(View view) {
        Intent intent = new Intent(this, HomeATIOtherStyleActivity.class);
        startActivity(intent);
    }

    /**
     * 其他布局风格样式-自定义bottomNavigation
     *
     * @param view
     */
    public void toScaleBgChangeAtyClick(View view) {
        Intent intent = new Intent(this, HomeScaleBgChangeActivity.class);
        startActivity(intent);
    }

    /**
     * 显示design包tabLayout方式
     *
     * @param view
     */
    public void toTabLayoutVPAtyClick(View view) {
        Intent intent = new Intent(this, HomeTabLayoutVPActivity.class);
        startActivity(intent);
    }

    /**
     * 显示design包bottomNavigation方式
     *
     * @param view
     */
    public void toBottomNavigationViewVPAtyClick(View view) {
        Intent intent = new Intent(this, HomeBottomNavigationViewVPActivity.class);
        startActivity(intent);
    }
}
