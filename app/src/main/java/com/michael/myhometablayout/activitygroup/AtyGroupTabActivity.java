package com.michael.myhometablayout.activitygroup;

import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.myhometablayout.R;

/**
 * Desc activityGroup实现tab
 * Created by Michael on 2018/3/13.
 */
public class AtyGroupTabActivity extends ActivityGroup {
    @SuppressWarnings("unused")
    private FrameLayout flBodyView;
    private LinearLayout llTabOne, llTabTwo, llTabThree, llTabFour;
    private ImageButton ibTabOne, ibTabTwo, ibTabThree, ibTabFour;
    private TextView tvTabOne, tvTabTwo, tvTabThree, tvTabFour;
    private int flag = 0; // 通过标记跳转不同的页面，显示不同的菜单项

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitygroup_tab);
        initMainView();
        // 显示标记页面
        showView(flag);
        llTabOne.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                flag = 0;
                showView(flag);
            }
        });
        llTabTwo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                flag = 1;
                showView(flag);
            }
        });
        llTabThree.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                flag = 2;
                showView(flag);
            }
        });
        llTabFour.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                flag = 3;
                showView(flag);
            }
        });

    }

    /**
     * 初始化主界面
     */
    public void initMainView() {
        flBodyView = (FrameLayout) findViewById(R.id.body);
        llTabOne = (LinearLayout) findViewById(R.id.ll_tab_one);
        llTabTwo = (LinearLayout) findViewById(R.id.ll_tab_two);
        llTabThree = (LinearLayout) findViewById(R.id.ll_tab_three);
        llTabFour = (LinearLayout) findViewById(R.id.ll_tab_four);

        ibTabOne = (ImageButton) findViewById(R.id.ib_tab_one_img);
        ibTabTwo = (ImageButton) findViewById(R.id.ib_tab_two_img);
        ibTabThree = (ImageButton) findViewById(R.id.ib_tab_three_img);
        ibTabFour = (ImageButton) findViewById(R.id.ib_tab_four_img);

        tvTabOne = (TextView) findViewById(R.id.tv_tab_one);
        tvTabTwo = (TextView) findViewById(R.id.tv_tab_two);
        tvTabThree = (TextView) findViewById(R.id.tv_tab_three);
        tvTabFour = (TextView) findViewById(R.id.tv_tab_four);
    }

    /**
     * 切换显示页面
     *
     * @param flag
     */
    public void showView(int flag) {
        switch (flag) {
            case 0:
                flBodyView.removeAllViews();
                flBodyView.addView(getLocalActivityManager().startActivity("llTabOne",
                        new Intent(AtyGroupTabActivity.this, AGOneActivity.class)).getDecorView());
                ibTabOne.setImageResource(R.mipmap.tab_one_pressed);
                ibTabTwo.setImageResource(R.mipmap.tab_two_normal);
                ibTabThree.setImageResource(R.mipmap.tab_three_normal);
                ibTabFour.setImageResource(R.mipmap.tab_four_normal);
                tvTabOne.setTextColor(Color.parseColor("#1296db"));
                tvTabTwo.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabThree.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabFour.setTextColor(Color.parseColor("#8a8a8a"));
                break;
            case 1:
                flBodyView.removeAllViews();
                flBodyView.addView(getLocalActivityManager().startActivity("two",
                        new Intent(AtyGroupTabActivity.this, AGTwoActivity.class))
                        .getDecorView());
                ibTabOne.setImageResource(R.mipmap.tab_one_normal);
                ibTabTwo.setImageResource(R.mipmap.tab_two_pressed);
                ibTabThree.setImageResource(R.mipmap.tab_three_normal);
                ibTabFour.setImageResource(R.mipmap.tab_four_normal);
                tvTabOne.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabTwo.setTextColor(Color.parseColor("#1296db"));
                tvTabThree.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabFour.setTextColor(Color.parseColor("#8a8a8a"));
                break;
            case 2:
                flBodyView.removeAllViews();
                flBodyView.addView(getLocalActivityManager().startActivity(
                        "three", new Intent(AtyGroupTabActivity.this, AGThreeActivity.class))
                        .getDecorView());
                ibTabOne.setImageResource(R.mipmap.tab_one_normal);
                ibTabTwo.setImageResource(R.mipmap.tab_two_normal);
                ibTabThree.setImageResource(R.mipmap.tab_three_pressed);
                ibTabFour.setImageResource(R.mipmap.tab_four_normal);
                tvTabOne.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabTwo.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabThree.setTextColor(Color.parseColor("#1296db"));
                tvTabFour.setTextColor(Color.parseColor("#8a8a8a"));
                break;
            case 3:
                flBodyView.removeAllViews();
                flBodyView.addView(getLocalActivityManager().startActivity(
                        "four", new Intent(AtyGroupTabActivity.this, AGFourActivity.class))
                        .getDecorView());
                ibTabOne.setImageResource(R.mipmap.tab_one_normal);
                ibTabTwo.setImageResource(R.mipmap.tab_two_normal);
                ibTabThree.setImageResource(R.mipmap.tab_three_normal);
                ibTabFour.setImageResource(R.mipmap.tab_four_pressed);
                tvTabOne.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabTwo.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabThree.setTextColor(Color.parseColor("#8a8a8a"));
                tvTabFour.setTextColor(Color.parseColor("#1296db"));
                break;
            default:
                break;
        }
    }
}