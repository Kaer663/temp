package com.example.administrator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import myfragment.Fragment1;
import myfragment.Fragment2;
import myfragment.Fragment3;

public class Main3Activity extends FragmentActivity {

    private LinearLayout linearS;
    private TextView textViews[];
    private Fragment[] fragments;
    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lines);
        init();
        viewPager.setAdapter(new Myadpter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页面滚动
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                for(int num=0;num<linearS.getChildCount();num++){
                    textViews[num].setBackgroundColor(Color.BLACK);
                    textViews[num].setEnabled(true);
                }
                textViews[i].setEnabled(false);
                textViews[i].setBackgroundColor(Color.RED);

            }

            //页面选择
            @Override
            public void onPageSelected(int i) {

            }

            //页滚动状态改变
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void init() {
        linearS=findViewById(R.id.linearS);
        viewPager=findViewById(R.id.viewPager);
        fragments=new Fragment[3];
        fragments[0]=new Fragment1();
        fragments[1]=new Fragment2();
        fragments[2]=new Fragment3();

        textViews=new TextView[3];
       int x= linearS.getChildCount();
       for(int i=0;i<x;i++){
           textViews[i]=(TextView)linearS.getChildAt(i);
           textViews[i].setEnabled(true);
           textViews[i].setTag(i);
           textViews[i].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    int itam=(Integer)view.getTag();
                    viewPager.setCurrentItem(itam);
                    select(itam);
               }
           });
       }
       textViews[0].setEnabled(false);
       textViews[0].setBackgroundColor(Color.RED);
    }

    void select(int item){

        for(int i=0;i<linearS.getChildCount();i++){
            textViews[i].setBackgroundColor(Color.BLACK);
            textViews[i].setEnabled(true);
        }
        textViews[item].setEnabled(false);
        textViews[item].setBackgroundColor(Color.RED);
    }

    class Myadpter extends FragmentPagerAdapter {
        public Myadpter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments[i];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
