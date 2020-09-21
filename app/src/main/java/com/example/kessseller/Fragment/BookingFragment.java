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
    String[] values = {"All","Booking Request","Booking List","Completed","Cancelled","Booking History",};
    TextView textView;
    List<DataRecyclerViewBooking.DataRecycler> datas;
    //    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    Context context;

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
        View rootView = inflater.inflate(R.layout.booking_myorder, container, false);
        DataRecyclerViewBooking dataRecyclerViewBooking = new DataRecyclerViewBooking();
        datas = dataRecyclerViewBooking.getDataRecycler();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_rebooking);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        textView = rootView.findViewById(R.id.txtfilter);
        textView.setText(values[0]);

        RecyclerAdapterBooking recyclerAdapter = new RecyclerAdapterBooking(datas);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setDetailListener(detailListener);

        view = (LinearLayout)rootView.findViewById(R.id.filterbtn);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog(savedInstanceState);
            }
        });
        return rootView;
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selected Filter");
        builder.setSingleChoiceItems(values,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TextView txt = (TextView)getActivity().findViewById(R.id.txtfilter);
                txt.setText(values[i]);
                dialogInterface.dismiss();
            };
        });
        builder.create();
        return builder.show();
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