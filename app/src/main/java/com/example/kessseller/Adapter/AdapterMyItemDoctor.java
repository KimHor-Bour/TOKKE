package com.example.kessseller.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.Listener.AppointmentListener;
import com.example.kessseller.R;

import java.util.List;

public class AdapterMyItemDoctor extends RecyclerView.Adapter<AdapterMyItemDoctor.DataViewHolder> {
    List<DataItemAppointment.DataApp> dataApps;
    AppointmentListener appointmentListener;
    LinearLayout linearLayout;
    public AdapterMyItemDoctor(List<DataItemAppointment.DataApp> dataApps) {
        this.dataApps=dataApps;

    }
    public void setAppointmentListener(AppointmentListener appointmentListener) {
        this.appointmentListener = appointmentListener;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_doctor, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, final int position) {
        dataViewHolder.dataDoctorname.setText(dataApps.get(position).doctor_name);
        dataViewHolder.dataskill.setText(dataApps.get(position).doctor_skill);
        dataViewHolder.dataDayOff.setText(dataApps.get(position).doctor_dayoff);
        dataViewHolder.dataWorkinghour.setText(dataApps.get(position).doctor_working_hour);
        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appointmentListener != null) {
                    appointmentListener.onClickItem(dataApps.get(position));

                }
            }
        });
          }



    @Override
    public int getItemCount() {
        return dataApps.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataDoctorname;
        TextView dataskill;
        TextView dataDayOff;
        TextView dataWorkinghour;


        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_doctor_id);
            dataDoctorname = (TextView)itemView.findViewById(R.id.app_doctorname);
            dataskill = (TextView)itemView.findViewById(R.id.app_skill);
            dataDayOff = (TextView)itemView.findViewById(R.id.app_dayoff);
            dataWorkinghour = (TextView)itemView.findViewById(R.id.app_workinghour);

        }
    }
}
