package com.example.lenovo.viewpagerandcircularindicator;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int img[];
    static int currentpage = 0;
    static int numpage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        img=new int []{R.drawable.a1,R.drawable.a3,R.drawable.aaa,R.drawable.aaaaa};

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(img,this);
        viewPager.setAdapter(viewPagerAdapter);

        CircleIndicator circleIndicator=(CircleIndicator)findViewById(R.id.circularIndica);
        circleIndicator.setViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               currentpage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
               if(state==ViewPager.SCROLL_STATE_IDLE){
                   numpage=img.length;
                   if(numpage==0){
                       viewPager.setCurrentItem(numpage-1,false);
                   }
                   else if(currentpage==numpage-1){
                       viewPager.setCurrentItem(0,false);
                   }
               }
            }
        });

    }
}
