package com.michael.myhometablayout.onlyfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.myhometablayout.R;

/**
 * Desc 纯fragment实现
 * Created by Michael on 2018/3/11.
 */
public class HomeFragmentActivity extends FragmentActivity implements View.OnClickListener {

    //声明四个Tab的布局文件
    private LinearLayout llTabOne, llTabTwo, llTabThree, llTabFour;

    //声明四个Tab的ImageButton
    private ImageButton ibTabOne, ibTabTwo, ibTabThree, ibTabFour;

    //声明4个Tab的TextView
    private TextView tvTabOne, tvTabTwo, tvTabThree, tvTabFour;

    //声明四个Tab分别对应的Fragment
    private Fragment fgTabOne, fgTabTwo, fgTabThree, fgTabFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_only);
        initViews();//初始化控件
        initEvents();//初始化事件
        selectTab(0);//默认选中第一个Tab
    }

    /**
     * 初始化四个Tab的点击事件
     */
    private void initEvents() {
        llTabOne.setOnClickListener(this);
        llTabTwo.setOnClickListener(this);
        llTabThree.setOnClickListener(this);
        llTabFour.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    private void initViews() {
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

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        //重置默认选中状态
        resetImgsText();
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

    /**
     * 选中Tab的处理
     *
     * @param i
     */
    private void selectTab(int i) {
        FragmentManager manager = getSupportFragmentManager();//获取FragmentManager对象
        FragmentTransaction transaction = manager.beginTransaction();//获取FragmentTransaction对象
        hideFragments(transaction);//隐藏所有的Fragment
        switch (i) {
            //当选中点击的是微信的Tab时
            case 0:
                ibTabOne.setImageResource(R.mipmap.tab_one_pressed);
                tvTabOne.setTextColor(Color.parseColor("#1296db"));
                if (fgTabOne == null) {
                    fgTabOne = new OneFragment();
                    transaction.add(R.id.id_content, fgTabOne);
                } else {
                    transaction.show(fgTabOne);
                }
                break;
            case 1:
                ibTabTwo.setImageResource(R.mipmap.tab_two_pressed);
                tvTabTwo.setTextColor(Color.parseColor("#1296db"));
                if (fgTabTwo == null) {
                    fgTabTwo = new TwoFragment();
                    transaction.add(R.id.id_content, fgTabTwo);
                } else {
                    transaction.show(fgTabTwo);
                }
                break;
            case 2:
                ibTabThree.setImageResource(R.mipmap.tab_three_pressed);
                tvTabThree.setTextColor(Color.parseColor("#1296db"));
                if (fgTabThree == null) {
                    fgTabThree = new ThreeFragment();
                    transaction.add(R.id.id_content, fgTabThree);
                } else {
                    transaction.show(fgTabThree);
                }
                break;
            case 3:
                ibTabFour.setImageResource(R.mipmap.tab_four_pressed);
                tvTabFour.setTextColor(Color.parseColor("#1296db"));
                if (fgTabFour == null) {
                    fgTabFour = new FourFragment();
                    transaction.add(R.id.id_content, fgTabFour);
                } else {
                    transaction.show(fgTabFour);
                }
                break;
        }
        //不要忘记提交事务
        transaction.commit();
    }

    //将四个的Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (fgTabOne != null) {
            transaction.hide(fgTabOne);
        }
        if (fgTabTwo != null) {
            transaction.hide(fgTabTwo);
        }
        if (fgTabThree != null) {
            transaction.hide(fgTabThree);
        }
        if (fgTabFour != null) {
            transaction.hide(fgTabFour);
        }
    }

    /**
     * 重置默认状态图片与文字
     */
    private void resetImgsText() {
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
