package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kessseller.Adapter.SliderAdapter;
import com.example.kessseller.Data.DataSliderItem;
import com.example.kessseller.R;
import com.example.kessseller.XML.Booking;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
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
    SliderView sliderView;
    SliderAdapter sliderAdapter;
    List<DataSliderItem.DataSlider> dataSliders;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.appointment_item_detail,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        DataSliderItem dataSliderItem = new DataSliderItem();
        dataSliders = dataSliderItem.getDataSliders();
        sliderView = view.findViewById(R.id.imageSlide);
        SliderAdapter sliderAdapter = new SliderAdapter(dataSliders);
        sliderView.setSliderAdapter(sliderAdapter);



        return bottomSheetDialog;
    }

}
