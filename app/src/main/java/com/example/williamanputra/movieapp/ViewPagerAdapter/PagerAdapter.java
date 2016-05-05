package com.example.williamanputra.movieapp.ViewPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by williamanputra on 5/3/16.
 */


public class PagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList= new ArrayList<>();
    List<String>titleList= new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {

        super(fm);
    }

    public void addFragment(Fragment fragment, String title){

        fragmentList.add(fragment);
        titleList.add(title);

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:


        }

        return fragmentList.get(position);
    }


    @Override
    public int getCount() {


        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return titleList.get(position);
    }
}
