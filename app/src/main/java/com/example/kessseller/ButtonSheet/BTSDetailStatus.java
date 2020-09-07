package com.example.kessseller.ButtonSheet;

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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BTSDetailStatus extends BottomSheetDialogFragment {
    private Context context;
    public BTSDetailStatus(Context context){
        this.context = context;
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_type_booking,container,false);



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
