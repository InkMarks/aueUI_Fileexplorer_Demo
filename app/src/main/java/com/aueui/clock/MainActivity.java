package com.aueui.clock;

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

import android.widget.TextView;

import com.aueui.clock.Adpters.AuePagerAdpter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TextView tv_alarm_clock, tv_time, tv_stopwatch, tv_timer;
    private List<View> views;
    private View alarm, time, stopwatch, timer;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.container);
        tv_alarm_clock = findViewById(R.id.tv_alarm_clock);
        tv_time = findViewById(R.id.tv_time);
        tv_stopwatch = findViewById(R.id.tv_stopwatch);
        tv_timer = findViewById(R.id.tv_timer);
        views = new ArrayList<>();
        views.add(alarm);
        views.add(time);
        views.add(stopwatch);
        views.add(timer);
        mViewPager.setAdapter(new AuePagerAdpter(views));
        mViewPager.setCurrentItem(0);
    }

}
