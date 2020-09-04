package com.example.kessseller.XML;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterDataType;
import com.example.kessseller.Adapter.AdapterMyItemRoom;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataMyItemTab;
import com.example.kessseller.Java.CreateEventScreen;
import com.example.kessseller.Java.CreateRoomScreen;
import com.example.kessseller.Java.CreateTableScreen;
import com.example.kessseller.Listener.TabListener;
import com.example.kessseller.R;

import java.util.List;

public class MyItemScreen extends Fragment{
    LinearLayout linearLayout;
     private  Context context;
    RecyclerView recyclerView;
    List<DataMyItemTab.DataType> dataTypes;
    List<DataItemBookingRoom.DataItemRoom> dataItemRooms;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_items,container,false);

        DataMyItemTab dataTypeItem = new DataMyItemTab();
        dataTypes = dataTypeItem.getData_type();
        recyclerView = view.findViewById(R.id.tab_type);
        AdapterDataType adapterDataType = new AdapterDataType(dataTypes);
        recyclerView.setAdapter(adapterDataType);


        DataItemBookingRoom dataItemBookingRoom = new DataItemBookingRoom();
        dataItemRooms = dataItemBookingRoom.getData_roomitem();
        recyclerView = view.findViewById(R.id.data_type);
        AdapterMyItemRoom adapterMyItemRoom = new AdapterMyItemRoom(dataItemRooms);
        recyclerView.setAdapter(adapterMyItemRoom);


        TabListener tabListener = new TabListener() {
            @Override
            public void TabClick(DataMyItemTab.DataType dataType) {
//                DataItemBookingRoom dataItemBookingRoom = new DataItemBookingRoom();
//                dataItemRooms = dataItemBookingRoom.getData_roomitem();
//                recyclerView = view.findViewById(R.id.data_type);
//                AdapterMyItemRoom adapterMyItemRoom = new AdapterMyItemRoom(dataItemRooms);
//                recyclerView.setAdapter(adapterMyItemRoom);

            }
        };


        linearLayout = view.findViewById(R.id.add_item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                String[] createtype = {"Create Product", "Create Table", "Create Room", "Create Event"};
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
                AlertDialog dialog = builder.create();
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
}
