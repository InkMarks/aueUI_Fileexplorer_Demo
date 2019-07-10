package com.aueui.clock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import com.aueui.clock.Activity.AddAlarm;
import com.aueui.clock.Adpters.AuePagerAdpter;
import com.aueui.clock.Utils.AnimationUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private TextView tv_alarm_clock, tv_time, tv_stopwatch, tv_timer, tv_date;
    private List<View> views;
    private View alarm, time, stopwatch, timer;
    private Button button;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTime();
    }

    @SuppressLint("SetTextI18n")
    private void initTime() {
        tv_date = time.findViewById(R.id.date);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        String[] str=new String[]{"","日","一","二","三","四","五","六"};
        tv_date.setText(simpleDateFormat.format(date)+"\t周"+str [Calendar.DAY_OF_WEEK]);
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewPager);
        tv_alarm_clock = findViewById(R.id.tv_alarm_clock);
        tv_time = findViewById(R.id.tv_time);
        tv_stopwatch = findViewById(R.id.tv_stopwatch);
        tv_timer = findViewById(R.id.tv_timer);
        button = findViewById(R.id.button);
        tv_alarm_clock.setOnClickListener(this);
        tv_time.setOnClickListener(this);
        tv_stopwatch.setOnClickListener(this);
        tv_timer.setOnClickListener(this);
        button.setOnClickListener(this);
        views = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        alarm = layoutInflater.inflate(R.layout.alarm, null);
        time = layoutInflater.inflate(R.layout.time, null);
        stopwatch = layoutInflater.inflate(R.layout.stopwatch, null);
        timer = layoutInflater.inflate(R.layout.timer, null);
        views.add(alarm);
        views.add(time);
        views.add(stopwatch);
        views.add(timer);
        mViewPager.setPageMargin(20);
        mViewPager.setAdapter(new AuePagerAdpter(views));
        mViewPager.setCurrentItem(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            boolean isFromTime = false;

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        tv_alarm_clock.setTextColor(getResources().getColor(R.color.blue));
                        tv_time.setTextColor(Color.WHITE);
                        tv_stopwatch.setTextColor(Color.WHITE);
                        tv_timer.setTextColor(Color.WHITE);
                        if (isFromTime) {
                            button.setVisibility(View.VISIBLE);
                            button.setAnimation(AnimationUtils.moveToViewLocation());
                        }
                        button.setText("+");
                        button.setTextSize(40);
                        isFromTime = false;
                        break;
                    case 1:
                        tv_alarm_clock.setTextColor(Color.WHITE);
                        tv_time.setTextColor(getResources().getColor(R.color.blue));
                        tv_stopwatch.setTextColor(Color.WHITE);
                        tv_timer.setTextColor(Color.WHITE);
                        button.setVisibility(View.GONE);
                        button.setAnimation(AnimationUtils.moveToViewBottom());
                        isFromTime = true;
                        break;
                    case 2:
                        tv_alarm_clock.setTextColor(Color.WHITE);
                        tv_time.setTextColor(Color.WHITE);
                        tv_stopwatch.setTextColor(getResources().getColor(R.color.blue));
                        tv_timer.setTextColor(Color.WHITE);
                        if (isFromTime) {
                            button.setVisibility(View.VISIBLE);
                            button.setAnimation(AnimationUtils.moveToViewLocation());
                        }
                        button.setText("开始");
                        button.setPadding(0, 2, 0, 0);
                        button.setTextSize(20);
                        isFromTime = false;
                        break;
                    case 3:
                        tv_alarm_clock.setTextColor(Color.WHITE);
                        tv_time.setTextColor(Color.WHITE);
                        tv_stopwatch.setTextColor(Color.WHITE);
                        tv_timer.setTextColor(getResources().getColor(R.color.blue));
                        if (isFromTime) {
                            button.setVisibility(View.VISIBLE);
                            button.setAnimation(AnimationUtils.moveToViewLocation());
                        }
                        button.setText("开始");
                        button.setPadding(0, 2, 0, 0);
                        button.setTextSize(20);
                        isFromTime = false;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_alarm_clock:
                tv_alarm_clock.setTextColor(getResources().getColor(R.color.blue));
                tv_time.setTextColor(Color.WHITE);
                tv_stopwatch.setTextColor(Color.WHITE);
                tv_timer.setTextColor(Color.WHITE);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tv_time:
                tv_alarm_clock.setTextColor(Color.WHITE);
                tv_time.setTextColor(getResources().getColor(R.color.blue));
                tv_stopwatch.setTextColor(Color.WHITE);
                tv_timer.setTextColor(Color.WHITE);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tv_stopwatch:
                tv_alarm_clock.setTextColor(Color.WHITE);
                tv_time.setTextColor(Color.WHITE);
                tv_stopwatch.setTextColor(getResources().getColor(R.color.blue));
                tv_timer.setTextColor(Color.WHITE);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tv_timer:
                tv_alarm_clock.setTextColor(Color.WHITE);
                tv_time.setTextColor(Color.WHITE);
                tv_stopwatch.setTextColor(Color.WHITE);
                tv_timer.setTextColor(getResources().getColor(R.color.blue));
                mViewPager.setCurrentItem(3);
                break;
            case R.id.button:
                switch (mViewPager.getCurrentItem()){
                    case 0:
                        startActivity(new Intent(MainActivity.this, AddAlarm.class));
                        break;
                }
                break;
        }
    }
}
