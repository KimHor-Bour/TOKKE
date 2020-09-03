package com.example.kessseller.Java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Adapter.AdapterMyItemTable;
import com.example.kessseller.R;

import java.util.List;

public class MyItemDataTable extends Fragment {
    RecyclerView recyclerView;
    List<DataItemBookingTable.DataItemTable> dataItemTables;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_data,container,false);
        DataItemBookingTable dataItemTableBooking = new DataItemBookingTable();
        dataItemTables = dataItemTableBooking.getData_tableitem();
        recyclerView = (RecyclerView)view.findViewById(R.id.re_item);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterMyItemTable adapterOfItemTable = new AdapterMyItemTable(dataItemTables);
        recyclerView.setAdapter(adapterOfItemTable);
        return view;

    }
}
