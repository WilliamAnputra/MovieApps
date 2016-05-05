package com.example.williamanputra.movieapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.example.williamanputra.movieapp.Fragments.TopRateFragment;
import com.example.williamanputra.movieapp.Fragments.PopularFragment;
import com.example.williamanputra.movieapp.INTERFACE.Communicator;
import com.example.williamanputra.movieapp.Scroller.MyScroller;
import com.example.williamanputra.movieapp.ViewPagerAdapter.PagerAdapter;

import io.fabric.sdk.android.Fabric;
import java.lang.reflect.Field;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ViewPager mMainViewPager;
    TabLayout mMainTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainViewPager=(ViewPager)findViewById(R.id.mainViewPager);
        mMainTabLayout=(TabLayout)findViewById(R.id.mainTab);

        //reduce viewpager's speed
        reduceViewPagerSlideSpeed();

        PagerAdapter adapter= new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new PopularFragment(), "Popular movies");
        adapter.addFragment(new TopRateFragment(), " Top rated movies");

        mMainViewPager.setAdapter(adapter);
        mMainTabLayout.setupWithViewPager(mMainViewPager);

    }

    public void reduceViewPagerSlideSpeed(){

        Field mScroller=null;

        try {
            mScroller=ViewPager.class.getDeclaredField("mScroller");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mScroller.setAccessible(true);
        MyScroller scroller= new MyScroller(mMainViewPager.getContext());

        try {
            mScroller.set(mMainViewPager,scroller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
