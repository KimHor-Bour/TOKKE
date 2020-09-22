package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.kessseller.Adapter.AdapterSIDD;
import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSDetailItemAppointment extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailItemAppointment(Context context){
        this.context = context;
    };
    BottomSheetBehavior bottomSheetBehavior;
    ViewPager viewPager;
    AdapterSIDD adapterSliderImage;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bts_detail_item_appointment,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        viewPager = (ViewPager)bottomSheetDialog.findViewById(R.id.imageSlider);
        adapterSliderImage = new AdapterSIDD(context);
        viewPager.setAdapter(adapterSliderImage);
        TextView textView = bottomSheetDialog.findViewById(R.id.txtImage);


        return bottomSheetDialog;
    }


}
