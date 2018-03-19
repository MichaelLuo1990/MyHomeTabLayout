package com.michael.myhometablayout.customalphatabsindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.michael.myhometablayout.R;
import com.michael.myhometablayout.customalphatabsindicator.alphatabs.AlphaTabsIndicator;
import com.michael.myhometablayout.customalphatabsindicator.alphatabs.OnTabChangedListner;

/**
 * Desc 点击/滑动底部tab渐变+指示器(其他风格测试)显示方式
 * Created by Michael on 2018/3/15.
 */
public class HomeATIOtherStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_tabs_indicator_other);

        AlphaTabsIndicator alphaTabsIndicator0 = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);
        alphaTabsIndicator0.getTabView(0).showNumber(8);
        alphaTabsIndicator0.getTabView(1).showNumber(88);
        alphaTabsIndicator0.getTabView(2).showNumber(888);
        alphaTabsIndicator0.getTabView(3).showPoint();

        AlphaTabsIndicator alphaTabsIndicator1 = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator1);
        alphaTabsIndicator1.getTabView(0).showNumber(8);
        alphaTabsIndicator1.getTabView(1).showNumber(88);
        alphaTabsIndicator1.getTabView(2).showNumber(888);
        alphaTabsIndicator1.getTabView(3).showPoint();

        alphaTabsIndicator1.setTabCurrenItem(1);

        AlphaTabsIndicator alphaTabsIndicator2 = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator2);
        alphaTabsIndicator2.getTabView(0).showNumber(8);
        alphaTabsIndicator2.getTabView(1).showNumber(88);
        alphaTabsIndicator2.getTabView(2).showNumber(888);
        alphaTabsIndicator2.getTabView(3).showPoint();

        alphaTabsIndicator2.setTabCurrenItem(2);
        //tab选中的监听回调
        alphaTabsIndicator2.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                Toast.makeText(HomeATIOtherStyleActivity.this, "select~" + tabNum, Toast.LENGTH_SHORT).show();
            }
        });

        AlphaTabsIndicator alphaTabsIndicator3 = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator3);
        alphaTabsIndicator3.getTabView(0).showNumber(8);
        alphaTabsIndicator3.getTabView(1).showNumber(88);
        alphaTabsIndicator3.getTabView(2).showNumber(888);
        alphaTabsIndicator3.getTabView(3).showPoint();

        alphaTabsIndicator3.setTabCurrenItem(3);
    }
}
