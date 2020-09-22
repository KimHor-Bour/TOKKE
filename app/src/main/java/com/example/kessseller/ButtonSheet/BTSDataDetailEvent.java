package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.kessseller.Adapter.AdapterSIED;
import com.example.kessseller.R;
import com.example.kessseller.Java.EventDetailStatus;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSDataDetailEvent extends BottomSheetDialogFragment {
    private Context context;
    public BTSDataDetailEvent(Context context){
        this.context = context;
    };
    ImageView imageView;
    LinearLayout linearLayout;
    ViewPager viewPager;
    AdapterSIED adapterSIED;

    BottomSheetBehavior bottomSheetBehavior;


    @Nullable
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bts_detail_item_event,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);


        linearLayout = bottomSheetDialog.findViewById(R.id.clickStatus);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventDetailStatus.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager)bottomSheetDialog.findViewById(R.id.imageSlider_ed);
        adapterSIED = new AdapterSIED(context);
        viewPager.setAdapter(adapterSIED);

        return bottomSheetDialog;
    }
}
