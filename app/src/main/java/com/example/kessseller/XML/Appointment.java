package com.example.kessseller.XML;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterAppointment;
import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataViewAppointment;
import com.example.kessseller.R;

import java.util.List;

public class Appointment extends Fragment {

    List<DataViewAppointment.DataAppointment>dataAppointments;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appointments,container,false);

        DataViewAppointment dataViewAppointment = new DataViewAppointment();
        dataAppointments = dataViewAppointment.getDataAppointments();
        recyclerView=(RecyclerView)view.findViewById(R.id.re_appointment);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        AdapterAppointment adapterAppointment = new AdapterAppointment(dataAppointments);
        recyclerView.setAdapter(adapterAppointment);


        return view;
    }
}
