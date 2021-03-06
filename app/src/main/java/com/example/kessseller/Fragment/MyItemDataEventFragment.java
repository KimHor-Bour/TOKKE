package com.example.kessseller.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterMyItemEvent;
import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.R;

import java.util.List;

public class MyItemDataEventFragment extends Fragment {
    RecyclerView recyclerView;
    List<DataItemBookingEvent.DataItemEvent> dataItemEvents;
    public MyItemDataEventFragment(){

    }
    private static final String Name = "account";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_data,container,false);
        DataItemBookingEvent dataItemBookingEvent = new DataItemBookingEvent();
        dataItemEvents = dataItemBookingEvent.getData_eventitem();
        recyclerView = (RecyclerView)view.findViewById(R.id.re_item);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterMyItemEvent adapterOfItemEvent = new AdapterMyItemEvent(dataItemEvents);
        recyclerView.setAdapter(adapterOfItemEvent);
        return view;

    }

    public static MyItemDataEventFragment newInstance() {
        
        Bundle args = new Bundle();

        MyItemDataEventFragment fragment = new MyItemDataEventFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
