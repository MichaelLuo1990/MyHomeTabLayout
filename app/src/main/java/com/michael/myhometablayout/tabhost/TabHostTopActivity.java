package com.michael.myhometablayout.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TabHost;

import com.michael.myhometablayout.R;

/**
 * Desc tabHost-顶部显示
 * Created by Michael on 2018/3/14.
 */

public class TabHostTopActivity extends Activity {

    private TabHost tabhost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost_top);
        //得到TabHost对象实例
        tabhost =(TabHost) findViewById(R.id.mytab);
        //调用 TabHost.setup()
        tabhost.setup();
        //创建Tab标签
        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("红色").setContent(R.id.widget_layout_red));
        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("黄色").setContent(R.id.widget_layout_yellow));
    }
}
