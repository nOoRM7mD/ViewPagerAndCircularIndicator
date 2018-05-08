package com.example.lenovo.viewpagerandcircularindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by lenovo on 2/14/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {
    int[] img;
    LayoutInflater layoutInflater;
    Context context;

    public ViewPagerAdapter(int[] img, Context context) {
        this.img = img;
        this.context = context;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_item, container, false);
        imageView = view.findViewById(R.id.imageslide);
        imageView.setImageResource(img[position]);
        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
