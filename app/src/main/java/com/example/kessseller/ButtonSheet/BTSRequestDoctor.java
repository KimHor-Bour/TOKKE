package com.example.kessseller.ButtonSheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kessseller.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSRequestDoctor extends BottomSheetDialogFragment {
    private Context context;
    public BTSRequestDoctor(Context context){
        this.context = context;
    };
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doctor_detail,container,false);

        imageView = view.findViewById(R.id.btn_cross);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}


