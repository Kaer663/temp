package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import myfragment.Fragment1;
import myfragment.Fragment2;
import myfragment.Fragment3;

public class Main2Activity extends FragmentActivity {

    private ViewPager viewPager;
    private Fragment[] views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    private void init() {
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        views=new Fragment[3];
        views[0]=new Fragment1();
        views[1]=new Fragment2();
        views[2]=new Fragment3();

    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return views[i];
        }

        @Override
        public int getCount() {
            return views.length;
        }
    }
}