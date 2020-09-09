package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kessseller.R;
import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSDetailItemBooking extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailItemBooking(Context context){
        this.context = context;
    };

    BottomSheetBehavior bottomSheetBehavior;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.detail_type_booking,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setPeekHeight(BottomSheetBehavior.SAVE_ALL);
        return bottomSheetDialog;
    }
}
