package com.example.kessseller.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kessseller.Adapter.AdapterMyItemBookingTab;
//import com.example.kessseller.Adapter.AdapterMyItemRoom;
import com.example.kessseller.AdapterAPI.AdapterGetRoom;
import com.example.kessseller.Api;
import com.example.kessseller.ButtonSheet.BTSDataDetailEvent;
import com.example.kessseller.ButtonSheet.BTSDetailItemBooking;
import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Data.DataMyItemTabBooking;
import com.example.kessseller.JSONResponse;
import com.example.kessseller.Java.CreateEventScreen;
import com.example.kessseller.Java.CreateRoomScreen;
import com.example.kessseller.Java.CreateTableScreen;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.Listener.ListenerClickItemBooking;
import com.example.kessseller.Model.ModelRoomList;
import com.example.kessseller.PlaceholderAPI;
import com.example.kessseller.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyItemScreenBookingFragment extends Fragment{
    LinearLayout linearLayout;
    private  Context context;
    private RecyclerView recyclerView,recyclerView1;
    List<DataMyItemTabBooking.DataType> dataTypes;
    List<DataItemBookingTable.DataItemTable> dataItemTables;
//    AdapterMyItemRoom adapterMyItemRoom;

    private int active = R.id.clickAll;
    private static int lastClickedPosition = -1;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private ArrayList<ModelRoomList> modelDataLists;
    private AdapterGetRoom adapter;

//    Api api;



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

//        DataItemBookingTable dataItemBookingTable = new DataItemBookingTable();
//        dataItemTables = dataItemBookingTable.getData_tableitem();
//        recyclerView1 = view.findViewById(R.id.data_type);
//        AdapterMyItemTable adapterMyItemTable = new AdapterMyItemTable(dataItemTables);
//        adapterMyItemTable.setDataItemTables(bookingListener);
//        recyclerView1.setAdapter(adapterMyItemTable);

        recyclerView = view.findViewById(R.id.data_type);

        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        loadJson();

//        PlaceholderAPI placeholderAPI = Api.getRetrofit().create(PlaceholderAPI.class);
//        Call<List<ModelRoomList>> call = placeholderAPI.getAllRoom();
//
//        call.enqueue(new Callback<List<ModelRoomList>>() {
//            @Override
//            public void onResponse(Call<List<ModelRoomList>> call, retrofit2.Response<List<ModelRoomList>> response) {
//                modelDataLists = response.body();
//                Log.d("TAG","Response = "+modelDataLists);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ModelRoomList>> call, Throwable t) {
//                Log.d("Error",t.getLocalizedMessage());
//
//            }
//        });
//        getData();



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
                l4.setOnClickListener(new View.OnClickListener() {
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

    private void loadJson() {
        final PlaceholderAPI placeholderAPI = Api.getRetrofit().create(PlaceholderAPI.class);
        Call<JSONResponse> call = placeholderAPI.getAllRoom();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                modelDataLists = new ArrayList<>(Arrays.asList(jsonResponse.getRoomLists()));
                adapter = new AdapterGetRoom(modelDataLists);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getLocalizedMessage());

            }
        });
    }

//    private void getData() {
//        StringRequest stringRequest = new StringRequest(BASE_URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject object = new JSONObject(response);
//
//                    JSONArray dataArray = object.getJSONArray("data");
//
//                    for(int i = 0; i<dataArray.length();i++){
//                        JSONObject dataObject = dataArray.getJSONObject(i);
//
//                        ModelRoomList modelDataList = new ModelRoomList(dataObject.getString("name"),dataObject.getInt("max_people"),
//                                dataObject.getDouble("price"),dataObject.getDouble("special_price"),dataObject.getDouble("deposit"));
//
//                        modelDataLists.add(modelDataList);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
////        final ProgressDialog progressDialog = new ProgressDialog(context);
////        progressDialog.setMessage("Loading....");
////        progressDialog.show();
////
////        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(BASE_URL, new Response.Listener<JSONArray>() {
////            @Override
////            public void onResponse(JSONArray response) {
////                for (int i = 0; i < response.length(); i++) {
////                    try {
////                        JSONObject jsonObject = response.getJSONObject(i);
////                        ModelDataList modelDataList = new ModelDataList();
////                        modelDataList.setName(jsonObject.getString("name"));
////                        modelDataList.setMax_people(jsonObject.getInt("max_people"));
////                        modelDataList.setPrice(jsonObject.getDouble("price"));
////                        modelDataList.setSpecial_price(jsonObject.getDouble("special_price"));
////                        modelDataList.setDeposit(jsonObject.getDouble("deposit"));
////                        modelDataLists.add(modelDataList);
////                    } catch (JSONException e) {
////                        e.printStackTrace();
////                        progressDialog.dismiss();
////                    }
////                }
////                adapter.notifyDataSetChanged();
////                progressDialog.dismiss();
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError error) {
////                Log.e("Volley", error.toString());
////                progressDialog.dismiss();
////            }
////        }
////        );
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//    }

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

