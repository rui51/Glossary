package com.example.alex.viewpagertest1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPager_tutorial extends PagerAdapter{
    Context context;
    LayoutInflater inflater;

    public int [] lst_images=
            {
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3,
                    R.drawable.img4,
                    R.drawable.img5,
                    R.drawable.img6,
                    R.drawable.img7,
                    R.drawable.img8
            };


    public String [] lst_title = {
            "p1",
            "p2",
            "p3",
            "p4",
            "p5",
            "p6",
            "p7",
            "p8"
    };
    public ViewPager_tutorial(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view,  Object object) {
        return (view==(LinearLayout)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.tutorial_page, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView txttitle =(TextView) view.findViewById(R.id.txttitle);
        image.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        container.addView(view);
        return view;
    }
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }
}
