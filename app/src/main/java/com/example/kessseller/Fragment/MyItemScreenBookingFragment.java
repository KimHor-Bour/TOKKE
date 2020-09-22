package com.example.kessseller.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterMyItemBookingTab;
import com.example.kessseller.Adapter.AdapterMyItemEvent;
import com.example.kessseller.ButtonSheet.BTSDataDetailEvent;
import com.example.kessseller.ButtonSheet.BTSDetailItemBooking;
import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Data.DataMyItemTabBooking;
import com.example.kessseller.Java.CreateEventScreen;
import com.example.kessseller.Java.CreateRoomScreen;
import com.example.kessseller.Java.CreateTableScreen;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.Listener.ListenerClickItemEvent;
import com.example.kessseller.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyItemScreenBookingFragment extends Fragment{
    LinearLayout linearLayout;
     private  Context context;
    RecyclerView recyclerView;
    List<DataMyItemTabBooking.DataType> dataTypes;
    List<DataItemBookingRoom.DataItemRoom> dataItemRooms;
    List<DataItemBookingTable.DataItemTable> dataItemTables;
    List<DataItemBookingEvent.DataItemEvent> dataItemEvents;
    String[] createtype = {"Create Product", "Create Table", "Create Room", "Create Event"};


    private BookingListener bookingListener = new BookingListener() {
        @Override
        public void onItemClick(DataItemBookingRoom.DataItemRoom dataItemRoom) {
            BTSDetailItemBooking btsDetailStatus =new BTSDetailItemBooking(context);
            btsDetailStatus.show(getFragmentManager(), BTSDetailItemBooking.class.getSimpleName());
        }

        @Override
        public void onTabClick(DataMyItemTabBooking.DataType dataType) {
            Toast.makeText(context, dataType.getType_item(),Toast.LENGTH_LONG).show();

        }

        @Override
        public void onAccept(Date date) {

        }
    };


    private ListenerClickItemEvent listenerClickItemEvent = new ListenerClickItemEvent() {
        @Override
        public void onClickItem(DataItemBookingEvent.DataItemEvent dataItemEvent) {
            BTSDataDetailEvent btsDataDetailEvent = new BTSDataDetailEvent(context);
            btsDataDetailEvent.show(getFragmentManager(),BTSDataDetailEvent.class.getSimpleName());
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_items,container,false);

        DataMyItemTabBooking dataTypeItem = new DataMyItemTabBooking();
        dataTypes = dataTypeItem.getData_type();
        recyclerView = view.findViewById(R.id.tab_type);
        AdapterMyItemBookingTab adapterDataType = new AdapterMyItemBookingTab(dataTypes,context);
        adapterDataType.setBookinglistener(bookingListener);
        recyclerView.setAdapter(adapterDataType);

        recyclerView = view.findViewById(R.id.data_type);
        DataItemBookingEvent dataItemBookingEvent = new DataItemBookingEvent();
        dataItemEvents = dataItemBookingEvent.getData_eventitem();
        AdapterMyItemEvent adapterMyItemEvent = new AdapterMyItemEvent(dataItemEvents);
        adapterMyItemEvent.setListenerClickEvent(listenerClickItemEvent);
        recyclerView.setAdapter(adapterMyItemEvent);

        linearLayout = view.findViewById(R.id.add_item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setItems(createtype, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                break;
                            case 1:
                                startActivity(new Intent(context, CreateTableScreen.class));
                                break;
                            case 2:
                                startActivity(new Intent(context, CreateRoomScreen.class));
                                break;
                            case 3:
                                startActivity(new Intent(context, CreateEventScreen.class));
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.show();
                dialog.show();
            }
        });


        linearLayout = view.findViewById(R.id.opt_filter);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                String[] f = {"All", "Approved", "Inactive"};
                builder.setItems(f, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                    }
                });
                AlertDialog dialog1 = builder.create();
                dialog1.show();
            }
        });

        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }


    public static MyItemScreenBookingFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyItemScreenBookingFragment fragment = new MyItemScreenBookingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
