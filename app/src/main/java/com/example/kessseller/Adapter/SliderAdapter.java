package com.example.kessseller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kessseller.Data.DataSliderItem;
import com.example.kessseller.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH>{

    private Context context;
    private List<DataSliderItem.DataSlider> sliderItemss;

    public  SliderAdapter(Context context){
        this.context = context;
    }

    public SliderAdapter(List<DataSliderItem.DataSlider> dataSliders) {
        return;
    }

    //    public  void renewItems(List<SliderItem> sliderItems){
//        this.sliderItems=sliderItems;
//        notifyDataSetChanged();
//    }
//
//    public void deleteItem(int position){
//        this.sliderItems.remove(position);
//        notifyDataSetChanged();
//    }
//
//    public void addItem(SliderItem sliderItem){
//        this.sliderItems.add(sliderItem);
//        notifyDataSetChanged();
//    }
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider,null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        DataSliderItem.DataSlider dataSliderItem = sliderItemss.get(position);

        viewHolder.textView.setText(context.getText(position));
        Glide.with(context).load(dataSliderItem.getImageslide()).into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return sliderItemss.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageView;
        TextView textView;
        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
            textView = itemView.findViewById(R.id.txtImage);
            this.itemView=itemView;
        }
    }
}