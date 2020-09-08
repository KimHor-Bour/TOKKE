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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterMyItemAppointmentTab;
import com.example.kessseller.Adapter.AdapterMyItemDoctor;
import com.example.kessseller.ButtonSheet.BTSDetailItemAppointment;
import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataMyItemTabAppointment;
import com.example.kessseller.Java.AddDoctorScreen;
import com.example.kessseller.Listener.AppointmentListener;
import com.example.kessseller.R;

import java.util.List;

public class MyItemScreenAppointment extends Fragment{
    LinearLayout linearLayout;
    private  Context context;
    RecyclerView recyclerView;
    List<DataMyItemTabAppointment.DataTabAppointment> dataTabAppointments;
    List<DataItemAppointment.DataApp> dataApps;
    View bgColor;

    private AppointmentListener appointmentListener = new AppointmentListener() {
        @Override
        public void onClickItem(DataItemAppointment.DataApp dataApp) {
            BTSDetailItemAppointment btsDetailItemAppointment = new BTSDetailItemAppointment(context);
            btsDetailItemAppointment.show(getFragmentManager(),BTSDetailItemAppointment.class.getSimpleName());

        }

        @Override
        public void onClickTab(DataMyItemTabAppointment.DataTabAppointment dataTabAppointment) {
            Toast.makeText(context, dataTabAppointment.getType_item(),Toast.LENGTH_LONG).show();

        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.my_items,container,false);

        DataMyItemTabAppointment dataMyItemTabAppointment = new DataMyItemTabAppointment();
        dataTabAppointments = dataMyItemTabAppointment.getDataTabAppointments();
        recyclerView = view.findViewById(R.id.tab_type);
        AdapterMyItemAppointmentTab adapterMyItemAppointmentTab = new AdapterMyItemAppointmentTab(dataTabAppointments);
        adapterMyItemAppointmentTab.setAppointmentListener(appointmentListener);
        recyclerView.setAdapter(adapterMyItemAppointmentTab);


        DataItemAppointment dataItemAppointment = new DataItemAppointment();
        dataApps = dataItemAppointment.getDataApps();
        recyclerView = view.findViewById(R.id.data_type);
        AdapterMyItemDoctor adapterMyItemDoctor = new AdapterMyItemDoctor(dataApps);
        adapterMyItemDoctor.setAppointmentListener(appointmentListener);
        recyclerView.setAdapter(adapterMyItemDoctor);

//        bgColor=view.findViewById(R.id.ll1);
        linearLayout = view.findViewById(R.id.add_item);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddDoctorScreen.class);
                startActivity(intent);
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
