package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataViewAppointment;
import com.example.kessseller.R;

import java.util.List;

public class AdapterAppointment extends RecyclerView.Adapter<AdapterAppointment.DataViewHolder> {
    List<DataViewAppointment.DataAppointment> dataAppointments;
    public AdapterAppointment(List<DataViewAppointment.DataAppointment> dataAppointments) {
        this.dataAppointments=dataAppointments;

    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_appointment, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.dataUsername.setText(dataAppointments.get(position).username);
        dataViewHolder.dataDateRequest.setText(dataAppointments.get(position).daterequest);
        dataViewHolder.dataDate.setText(dataAppointments.get(position).appointment_date);
        dataViewHolder.dataCode.setText(dataAppointments.get(position).appointment_code);
        dataViewHolder.dataDoctorName.setText(dataAppointments.get(position).appointment_doctorname);
        dataViewHolder.dataDoctorSkill.setText(dataAppointments.get(position).appointment_skill);
        dataViewHolder.dataChoiceFilter.setText(dataAppointments.get(position).choice_filter);

    }



    @Override
    public int getItemCount() {
        return dataAppointments.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataUsername;
        TextView dataDateRequest;
        TextView dataDate;
        TextView dataCode;
        TextView dataDoctorName;
        TextView dataDoctorSkill;
        TextView dataChoiceFilter;

        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_appointment);
            dataUsername = (TextView)itemView.findViewById(R.id.appoint_username);
            dataDateRequest = (TextView)itemView.findViewById(R.id.appointment_date_request);
            dataDate = (TextView)itemView.findViewById(R.id.data_appointment_date);
            dataChoiceFilter = (TextView)itemView.findViewById(R.id.appointment_choice_filter);
            dataCode = (TextView)itemView.findViewById(R.id.data_doctor_code);
            dataDoctorName = (TextView)itemView.findViewById(R.id.data_doctor_name);
            dataDoctorSkill = (TextView)itemView.findViewById(R.id.data_doctor_skill);

        }
    }
}
