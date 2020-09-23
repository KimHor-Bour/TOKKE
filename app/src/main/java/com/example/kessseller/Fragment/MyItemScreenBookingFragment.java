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
    RecyclerView recyclerView;
    List<DataMyItemTabBooking.DataType> dataTypes;
    List<DataItemBookingRoom> dataItemRooms;
    AdapterMyItemRoom adapterMyItemRoom;
    LinearLayout l1,l2,l3,l4;
    CreateTableScreen createTableScreen;


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

//        recyclerView = view.findViewById(R.id.data_type);
//        DataItemBookingEvent dataItemBookingEvent = new DataItemBookingEvent();
//        dataItemEvents = dataItemBookingEvent.getData_eventitem();
//        AdapterMyItemEvent adapterMyItemEvent = new AdapterMyItemEvent(dataItemEvents);
//        adapterMyItemEvent.setListenerClickEvent(listenerClickItemEvent);
//        recyclerView.setAdapter(adapterMyItemEvent);
//
        recyclerView = view.findViewById(R.id.data_type);
//        DataItemBookingRoom dataItemBookingRoom = new DataItemBookingRoom();
//        dataItemRooms = dataItemBookingRoom.get
//        AdapterMyItemRoom adapterMyItemRoom = new AdapterMyItemRoom(dataItemRooms);
//        adapterMyItemRoom.setBookinglistener(listenerClickItemEvent);
//        recyclerView.setAdapter(adapterMyItemRoom);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));

        dataItemRooms = new ArrayList<>();


        getAllData();


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
                LinearLayout l3 = (LinearLayout) dialogView.findViewById(R.id.clickCreateRoom);
                LinearLayout l4 = (LinearLayout) dialogView.findViewById(R.id.clickCreateEvent);

                l1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

                l2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateTableScreen.class));
                        l2.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateRoomScreen.class));
                        l2.setBackgroundColor(Color.GRAY);
                    }
                });
                l3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        startActivity(new Intent(context, CreateEventScreen.class));
                        l2.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
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


//        Call<List<DataItemBookingRoom>> datalist = Api.getDataRoom().getAllRoom();
//
//        datalist.enqueue(new Callback<List<DataItemBookingRoom>>() {
//            @Override
//            public void onResponse(Call<List<DataItemBookingRoom>> call, Response<List<DataItemBookingRoom>> response) {
//                if(response.isSuccessful()){
//                    List<DataItemBookingRoom> dataItemBookingRooms = response.body();
//                    AdapterMyItemRoom adapterMyItemRoom = new AdapterMyItemRoom(dataItemRooms);
//                    adapterMyItemRoom.setItemRoom(dataItemBookingRooms);
//                    recyclerView.setAdapter(adapterMyItemRoom);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<DataItemBookingRoom>> call, Throwable t) {
//                Log.e("fail",t.getLocalizedMessage());
//
//            }
//        });
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

