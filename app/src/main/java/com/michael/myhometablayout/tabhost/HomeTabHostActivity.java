package com.michael.myhometablayout.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.michael.myhometablayout.R;

/**
 * Desc tabHost方式实现
 * 继承ActivityGroup（废弃）、TabActivity（废弃）、Activity（推荐）
 * Created by Michael on 2018/3/14.
 */
public class HomeTabHostActivity extends Activity implements OnCheckedChangeListener{
    private TabHost tabhost;
    private RadioGroup radioGroup;
    private RadioButton rbTabOne, rbTabTwo, rbTabThree, rbTabFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        radioGroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        rbTabOne = (RadioButton) findViewById(R.id.tab_icon_weixin);
        rbTabTwo = (RadioButton) findViewById(R.id.tab_icon_address);
        rbTabThree = (RadioButton) findViewById(R.id.tab_icon_friend);
        rbTabFour = (RadioButton) findViewById(R.id.tab_icon_setting);

        //方法一：继承ActivityGroup  ---》 this.getLocalActivityManager()  ---》  设置当前实例  ；  xml文件tabHost中id 定义 @+id/th_main
//        tabhost = (TabHost) findViewById(R.id.th_main);
//        tabhost.setup(this.getLocalActivityManager());
//        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this, THOneActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this, THTwoActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this, THThreeActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag4").setIndicator("3").setContent(new Intent(this, THFourActivity.class)));

        //方法二：继承TabActivity  ----》  获取当前实例   ； xml文件tabHost中id 定义  @android:id/tabhost
//        tabhost = getTabHost();//往TabWidget添加Tab
//        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this, THOneActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this, THTwoActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this, THThreeActivity.class)));
//        tabhost.addTab(tabhost.newTabSpec("tag4").setIndicator("3").setContent(new Intent(this, THFourActivity.class)));

        // 方法三：继承Activity（推荐使用，易拓展） ---》 tabhost.setup()   ---》  加载当前context中静态资源
        tabhost =(TabHost) findViewById(R.id.th_main);
        tabhost.setup();
        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("0").setContent(R.id.ll_tab_one));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("1").setContent(R.id.ll_tab_two));
        tabhost.addTab(tabhost.newTabSpec("tag3").setIndicator("2").setContent(R.id.ll_tab_three));
        tabhost.addTab(tabhost.newTabSpec("tag4").setIndicator("3").setContent(R.id.ll_tab_four));

        //设置监听事件
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.tab_icon_weixin:
                tabhost.setCurrentTab(0);//或tabhost.setCurrentTabByTag("tag1");
                rbTabOne.setTextColor(getResources().getColor(R.color.color_1296db));
                rbTabTwo.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabThree.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabFour.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                break;
            case R.id.tab_icon_address:
                tabhost.setCurrentTab(1);
                rbTabOne.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabTwo.setTextColor(getResources().getColor(R.color.color_1296db));
                rbTabThree.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabFour.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                break;
            case R.id.tab_icon_friend:
                tabhost.setCurrentTab(2);
                rbTabOne.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabTwo.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabThree.setTextColor(getResources().getColor(R.color.color_1296db));
                rbTabFour.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                break;
            case R.id.tab_icon_setting:
                tabhost.setCurrentTab(3);
                rbTabOne.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabTwo.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabThree.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                rbTabFour.setTextColor(getResources().getColor(R.color.color_1296db));
                break;
        }
    }
}
