package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterCodeTicket;
import com.example.kessseller.Adapter.SliderAdapter;
import com.example.kessseller.Data.DataCodeTicket;
import com.example.kessseller.Data.DataSliderItem;
import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class BTSDetailUserBuyTicket extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailUserBuyTicket(Context context){
        this.context = context;
    };
    ImageView imageView;
    LinearLayout linearLayout;
    BottomSheetBehavior bottomSheetBehavior;
    List<DataCodeTicket.DataTicket> dataTickets;
    RecyclerView recyclerView;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bts_detail_userbuy_ticket,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        DataCodeTicket dataCodeTicket = new DataCodeTicket();
        dataTickets = dataCodeTicket.getDataTickets();
        recyclerView = view.findViewById(R.id.re_code_ticket);
        recyclerView.setHasFixedSize(true);
        AdapterCodeTicket adapterCodeTicket = new AdapterCodeTicket(dataTickets);
        recyclerView.setAdapter(adapterCodeTicket);

        imageView = bottomSheetDialog.findViewById(R.id.btn_detail_cross);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return bottomSheetDialog;
    }
}
