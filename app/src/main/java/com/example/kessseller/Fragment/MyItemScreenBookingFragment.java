package com.example.kessseller.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.kessseller.Adapter.AdapterMyItemBookingTab;
import com.example.kessseller.Adapter.AdapterMyItemRoom;
import com.example.kessseller.Adapter.AdapterMyItemTable;
import com.example.kessseller.Api;
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
import com.example.kessseller.Listener.ListenerClickItemBooking;
import com.example.kessseller.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MyItemScreenBookingFragment extends Fragment{
    LinearLayout linearLayout;
    private  Context context;
    RecyclerView recyclerView,recyclerView1;
    List<DataMyItemTabBooking.DataType> dataTypes;
    List<DataItemBookingRoom> dataItemRooms;
    List<DataItemBookingTable.DataItemTable> dataItemTables;
    AdapterMyItemRoom adapterMyItemRoom;

    private int active = R.id.clickAll;
    private static int lastClickedPosition = -1;


    private static String BASE_URL= "http://192.168.50.47:8000/api/rooms";

    private BookingListener bookingListener = new BookingListener() {
        @Override
        public void onItemClick(DataItemBookingRoom dataItemRoom) {
            BTSDetailItemBooking btsDetailStatus =new BTSDetailItemBooking(context);
            btsDetailStatus.show(getFragmentManager(), BTSDetailItemBooking.class.getSimpleName());
        }

        @Override
        public void onTabClick(DataMyItemTabBooking.DataType dataType) {
            Toast.makeText(context, dataType.getType_item(),Toast.LENGTH_LONG).show();

        }

        @Override
        public void onItemCLick(DataItemBookingTable.DataItemTable dataItemTable) {
            BTSDetailItemBooking btsDetailItemBooking =new BTSDetailItemBooking(context);
            btsDetailItemBooking.show(getFragmentManager(), BTSDetailItemBooking.class.getSimpleName());

        }

        @Override
        public void onAccept(Date date) {

        }
    };


    private ListenerClickItemBooking listenerClickItemEvent = new ListenerClickItemBooking() {
        @Override
        public void onClickItemEvent(DataItemBookingEvent.DataItemEvent dataItemEvent) {
            BTSDataDetailEvent btsDataDetailEvent = new BTSDataDetailEvent(context);
            btsDataDetailEvent.show(getFragmentManager(),BTSDataDetailEvent.class.getSimpleName());
        }

        @Override
        public void onClickItemTable(DataItemBookingTable.DataItemTable dataItemTable) {

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

        DataItemBookingTable dataItemBookingTable = new DataItemBookingTable();
        dataItemTables = dataItemBookingTable.getData_tableitem();
        recyclerView1 = view.findViewById(R.id.data_type);
        AdapterMyItemTable adapterMyItemTable = new AdapterMyItemTable(dataItemTables);
        adapterMyItemTable.setDataItemTables(bookingListener);
        recyclerView1.setAdapter(adapterMyItemTable);



        linearLayout = view.findViewById(R.id.add_item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                ViewGroup viewGroup = view.findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.alert_create, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();

                LinearLayout l1 = (LinearLayout) dialogView.findViewById(R.id.clickCreateProduct);
                final LinearLayout l2 = (LinearLayout) dialogView.findViewById(R.id.clickCreateTable);
                final LinearLayout l3 = (LinearLayout) dialogView.findViewById(R.id.clickCreateRoom);
                final LinearLayout l4 = (LinearLayout) dialogView.findViewById(R.id.clickCreateEvent);

                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        l2.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateTableScreen.class));

                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        l3.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateRoomScreen.class));
                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        l4.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateEventScreen.class));
                    }
                });

                alertDialog.show();
            }
        });


        linearLayout = view.findViewById(R.id.opt_filter);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                ViewGroup viewGroup = view.findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.alert_filter_item, viewGroup, false);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();

                final LinearLayout f1 = (LinearLayout) dialogView.findViewById(R.id.clickAll);
                final LinearLayout f2 = (LinearLayout) dialogView.findViewById(R.id.clickApproved);
                final LinearLayout f3 = (LinearLayout) dialogView.findViewById(R.id.clickInactive);

                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        f1.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                      alertDialog.dismiss();

                    }
                });
                f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        f2.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                        alertDialog.dismiss();
                    }
                });
                f3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        f3.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });

        return view;
    }

    private void getAllData() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        DataItemBookingRoom dataItemBookingRoom = new DataItemBookingRoom();
                        dataItemBookingRoom.setName(jsonObject.getString("name"));
                        dataItemBookingRoom.setMax_people(jsonObject.getInt("max_people"));
                        dataItemBookingRoom.setPrice(jsonObject.getDouble("price"));
                        dataItemBookingRoom.setSpecial_price(jsonObject.getDouble("special_price"));
                        dataItemBookingRoom.setDeposit(jsonObject.getDouble("deposit"));
                        dataItemBookingRoom.add(dataItemRooms);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterMyItemRoom = new AdapterMyItemRoom(dataItemRooms,getContext());
                recyclerView.setAdapter(adapterMyItemRoom);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","on Response" +error.getLocalizedMessage());
            }
        }

        );
        queue.add(jsonArrayRequest);
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

