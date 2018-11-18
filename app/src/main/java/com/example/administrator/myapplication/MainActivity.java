package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private View[] views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        viewPager.setAdapter(new MyAdapter());
    }

    private void init() {
        viewPager=findViewById(R.id.viewPager);
        LayoutInflater flater=LayoutInflater.from(this);
        views=new View[3];
        views[0]=flater.inflate(R.layout.view1,null);
        views[1]=flater.inflate(R.layout.view2,null);
        views[2]=flater.inflate(R.layout.view3,null);
    }
    class MyAdapter extends PagerAdapter{
        @Nullable
        @Override
        public int getCount() {
            return views.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(views[position]);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            return views[position];
        }
    }
}
