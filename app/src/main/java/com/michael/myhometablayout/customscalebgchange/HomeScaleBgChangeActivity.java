package com.michael.myhometablayout.customscalebgchange;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.michael.myhometablayout.R;
import com.michael.myhometablayout.customscalebgchange.bottomnavigation.BottomNavigationItem;
import com.michael.myhometablayout.customscalebgchange.bottomnavigation.BottomNavigationView;
import com.michael.myhometablayout.customscalebgchange.bottomnavigation.OnBottomNavigationItemClickListener;

/**
 * Desc 点击底部tab缩放+背景颜色改变显示方式
 * reference https://github.com/armcha/LuseenBottomNavigation
 * Created by Michael on 2018/3/15.
 */
public class HomeScaleBgChangeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_bgchange);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Record");
        button = (Button) findViewById(R.id.button);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(false);
            // bottomNavigationView.activateTabletMode();
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
            bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));
            bottomNavigationView.setFont(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Noh_normal.ttf"));
        }

        //tab图标
        int[] image = {R.drawable.vector_ic_mic_black_24dp, R.drawable.vector_ic_favorite_black_24dp,
                R.drawable.vector_ic_book_black_24dp, R.drawable.vector_github_circle};
        //底部导航栏背景色
        int[] color = {ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.thirdColor), ContextCompat.getColor(this, R.color.fourthColor)};

        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("Record", color[0], image[0]);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("Like", color[1], image[1]);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("Books", color[2], image[2]);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("GitHub", color[3], image[3]);

        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);

        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        textView.setText("Record");
                        break;
                    case 1:
                        textView.setText("Like");
                        break;
                    case 2:
                        textView.setText("Books");
                        break;
                    case 3:
                        textView.setText("GitHub");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.selectTab(2);
            }
        });
    }
}

