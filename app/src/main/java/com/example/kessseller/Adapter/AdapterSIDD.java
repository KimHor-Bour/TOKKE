package com.example.kessseller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.kessseller.R;
public class AdapterSIDD extends PagerAdapter{
    private int[] image_resources = {R.drawable.doctorimage,R.drawable.doctor_card,R.drawable.doctor,R.drawable.appointment};
    private Context context;
    private LayoutInflater layoutInflater;
    public AdapterSIDD(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (FrameLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.imageslider_doctor_detail,container,false);
        ImageView imageView = view.findViewById(R.id.images);
        TextView textView = view.findViewById(R.id.txtImage);
        textView.setText(Integer.toString(position+1));

        TextView textCount = view.findViewById(R.id.countImage);
        textCount.setText(Integer.toString(getCount()));

        imageView.setImageResource(image_resources[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
