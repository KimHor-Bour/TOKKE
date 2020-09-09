package com.example.kessseller.ButtonSheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSCreateDescriptionRoom extends BottomSheetDialogFragment {
    private Context context;
    public BTSCreateDescriptionRoom(Context context){
        this.context = context;
    };
    TextView textView;
    BottomSheetBehavior bottomSheetBehavior;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.input_description,null);

        bottomSheetDialog.setContentView(view);

        bottomSheetBehavior= BottomSheetBehavior.from((View) (view.getParent()));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        textView = view.findViewById(R.id.cancel_button);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return bottomSheetDialog;
    }
}
