package com.example.kessseller.XML;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataRecyclerViewBooking;
import com.example.kessseller.ButtonSheet.BTSDataDetail;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.ButtonSheet.BTSDateandTime;
import com.example.kessseller.Adapter.AdapterTableStatus;
import com.example.kessseller.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class Status extends Fragment implements View.OnClickListener {
    LinearLayout linearLayout;
    AlertDialog alertDialog;
    String[] values = {"Table","Room","Event",};
    TextView textView;
    List<DataItemBookingRoom.DataItemRoom> dataItemRooms;
    View clickitem;
    BTSDataDetail btsDataStatus;
    //    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private BookingListener bookingListener = new BookingListener() {
        @Override
        public void onItemClick(DataItemBookingRoom.DataItemRoom dataItemRoom) {
//            System.out.print("click");
            BTSDataDetail btsDataStatus = new BTSDataDetail(context);
            btsDataStatus.show(getFragmentManager(), BTSDataDetail.class.getSimpleName());

        }

        @Override
        public void onAccept(Date date) {
            TextView datetv = linearLayout.findViewById(R.id.txt_selecteddate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE dd MMM hh:mm a");
            datetv.setText(simpleDateFormat.format(date).toString());
        };
    };


    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.status_myorder, container, false);
        DataItemBookingRoom dataItemBookingRoom = new DataItemBookingRoom();
        dataItemRooms = dataItemBookingRoom.getData_roomitem();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_restatus);

        textView = rootView.findViewById(R.id.type_status);
        textView.setText(values[0]);

        AdapterTableStatus recyclerAdapterStatus = new AdapterTableStatus(dataItemRooms);

        recyclerView.setAdapter(recyclerAdapterStatus);

        AdapterTableStatus recyclerAdapterStatus1 = new AdapterTableStatus(dataItemRooms);
        recyclerAdapterStatus.setBookinglistener(bookingListener);
        recyclerView.setAdapter(recyclerAdapterStatus);
        linearLayout = (LinearLayout)rootView.findViewById(R.id.filterbtntype);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog(savedInstanceState);
            }

        });

        linearLayout = rootView.findViewById(R.id.date_time_picker);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BTSDateandTime buttonSheetDateandTime = new BTSDateandTime(context);
                buttonSheetDateandTime.bookingListener = bookingListener;
                buttonSheetDateandTime.show(getFragmentManager(), BTSDateandTime.class.getSimpleName());
            }
        });Context context;


//        clickitem = (View)rootView.findViewById()


        return rootView;
    }

    private Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecte Filter");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(values[0]);
                TextView textView = (TextView)getActivity().findViewById(R.id.type_status);
                textView.setText(values[i]);
                dialogInterface.dismiss();
            }
        });
        builder.create();
        return builder.show();

    }

    @Override
    public void onClick(View view) {
    }

}