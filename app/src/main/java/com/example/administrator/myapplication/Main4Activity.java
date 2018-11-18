package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import myfragment.Fragment1;
import myfragment.Fragment2;
import myfragment.Fragment3;

public class Main4Activity extends FragmentActivity {
    private LinearLayout linearS;
    private ImageView imageViews[];
    private Fragment[] fragments;
    private ViewPager viewPager;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_main);
        init();
        viewPager.setAdapter(new Myadpter(getSupportFragmentManager()));
    }

    private void init() {
        linearS=findViewById(R.id.linearS);
        viewPager=findViewById(R.id.viewPager);
        fragments=new Fragment[3];
        fragments[0]=new Fragment1();
        fragments[1]=new Fragment2();
        fragments[2]=new Fragment3();


        imageViews=new ImageView[3];
        int x= linearS.getChildCount();
        for(int i=0;i<x;i++){
            imageViews[i]=(ImageView)linearS.getChildAt(i);  //得到每一个ImageView
            imageViews[i].setEnabled(true);  //设置每一个ImageView都是可以选中的
            imageViews[i].setTag(i);    //发送此时ImageView的索引 为单击事件能够得到索引值

            //设置单机事件
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itam=(Integer)view.getTag();
                   viewPager.setCurrentItem(itam);
                   for(int num=0;num<linearS.getChildCount();num++){
                       imageViews[num].setEnabled(true);
                   }
                   imageViews[itam].setEnabled(false);
                }
            });
        }
        imageViews[0].setEnabled(false);
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
