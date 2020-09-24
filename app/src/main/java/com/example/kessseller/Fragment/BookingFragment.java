package com.example.kessseller.Fragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kessseller.Data.DataRecyclerViewBooking;
import com.example.kessseller.Adapter.RecyclerAdapterBooking;
import com.example.kessseller.ButtonSheet.BTSDataDetailBooking;
import com.example.kessseller.Listener.DetailListener;
import com.example.kessseller.R;

import java.util.List;
public class BookingFragment extends Fragment implements View.OnClickListener {
    View view;
    TextView textView;
    List<DataRecyclerViewBooking.DataRecycler> datas;
    //    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    Context context;

    RadioGroup radioGroup;
    RadioButton radioButton;
    int activeClick = R.id.radioAll;




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    private DetailListener detailListener = new DetailListener() {
        @Override
        public void onItemClick(DataRecyclerViewBooking.DataRecycler dataRecycler) {
            BTSDataDetailBooking btsDataStatus = new BTSDataDetailBooking(context);
            btsDataStatus.show(getFragmentManager(), BTSDataDetailBooking.class.getSimpleName());
                    }
    };

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.booking_myorder, container, false);
        DataRecyclerViewBooking dataRecyclerViewBooking = new DataRecyclerViewBooking();
        datas = dataRecyclerViewBooking.getDataRecycler();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_rebooking);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        textView = rootView.findViewById(R.id.txtfilter);
        textView.setText(R.string.all);

        RecyclerAdapterBooking recyclerAdapter = new RecyclerAdapterBooking(datas);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setDetailListener(detailListener);

        view = (LinearLayout)rootView.findViewById(R.id.filterbtn);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final ViewGroup viewGroup = view.findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.ratio_filter, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                radioGroup = dialogView.findViewById(R.id.radioGroup);
                radioGroup.check(activeClick);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        radioButton = radioGroup.findViewById(i);
                        activeClick = radioButton.getId();

                        TextView textView = rootView.findViewById(R.id.txtfilter);

                        textView.setText(radioButton.getText());
                        alertDialog.dismiss();

                    }
                });
                alertDialog.show();

            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {
    }

    public static BookingFragment newInstance() {

        Bundle args = new Bundle();

        BookingFragment fragment = new BookingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}