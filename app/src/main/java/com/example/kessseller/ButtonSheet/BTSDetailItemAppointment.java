package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.kessseller.Adapter.AdapterSliderImage;
import com.example.kessseller.Adapter.SliderAdapter;
import com.example.kessseller.Data.DataImagesSlider;
import com.example.kessseller.Data.DataSliderItem;
import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class BTSDetailItemAppointment extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailItemAppointment(Context context){
        this.context = context;
    };
    ImageView imageView;
    LinearLayout linearLayout;
    BottomSheetBehavior bottomSheetBehavior;
    ViewPager viewPager;
    AdapterSliderImage adapterSliderImage;
    List<AdapterSliderImage> adapterSliderImageList = new ArrayList<>();


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bts_detail_item_appointment,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        viewPager = (ViewPager)bottomSheetDialog.findViewById(R.id.imageSlider);
        adapterSliderImage = new AdapterSliderImage(context);
        viewPager.setAdapter(adapterSliderImage);
        TextView textView = bottomSheetDialog.findViewById(R.id.txtImage);


        return bottomSheetDialog;
    }


}
