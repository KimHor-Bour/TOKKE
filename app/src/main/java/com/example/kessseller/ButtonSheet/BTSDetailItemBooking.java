package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSDetailItemBooking extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailItemBooking(Context context){
        this.context = context;
    };
    TextView shopName, price, specialprice, deposit, description;
    DataItemBookingRoom dataItemBookingRoom;


    BottomSheetBehavior bottomSheetBehavior;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bts_detail_booking_item,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);


        shopName = bottomSheetDialog.findViewById(R.id.shopName);
        price = bottomSheetDialog.findViewById(R.id.price);
        specialprice = bottomSheetDialog.findViewById(R.id.specialprice);
        deposit = bottomSheetDialog.findViewById(R.id.detail_room_deposit);
        description = bottomSheetDialog.findViewById(R.id.detail_myitem_description);




        return bottomSheetDialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
