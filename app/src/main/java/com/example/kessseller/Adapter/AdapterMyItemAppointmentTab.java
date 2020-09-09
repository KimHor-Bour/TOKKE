package com.example.kessseller.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataMyItemTabAppointment;
import com.example.kessseller.Data.DataMyItemTabBooking;

import com.example.kessseller.Listener.AppointmentListener;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.R;

import java.util.List;

import static android.media.CamcorderProfile.get;
import static android.media.CamcorderProfile.hasProfile;

public class AdapterMyItemAppointmentTab extends RecyclerView.Adapter<AdapterMyItemAppointmentTab.DataViewHolder> {
    List<DataMyItemTabAppointment.DataTabAppointment> dataTabAppointments;
    AppointmentListener appointmentListener;
    LinearLayout linearLayout;
    Context context;
    private int selectedTab;
    private static int lastClickedPosition = -1;
    public AdapterMyItemAppointmentTab(List<DataMyItemTabAppointment.DataTabAppointment> dataTabAppointments, Context context) {
        this.dataTabAppointments=dataTabAppointments;
        this.context = context;
        selectedTab = 0;

    }
    public void setAppointmentListener(AppointmentListener appointmentListener) {
        this.appointmentListener = appointmentListener;
    }



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tap_item, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        linearLayout = v.findViewById(R.id.ll1);

        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder dataViewHolder, final int position) {
        dataViewHolder.datatype.setText(dataTabAppointments.get(position).type_item);

        dataViewHolder.view.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
        if(selectedTab == position){
            dataViewHolder.view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previoustab = selectedTab;
                selectedTab = position;
                notifyItemChanged(previoustab);
                notifyItemChanged(position);

                if (appointmentListener != null){
                    appointmentListener.onClickTab(dataTabAppointments.get(position));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTabAppointments.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView datatype;
        DataViewHolder(View itemView){
            super(itemView);
            view = (View) itemView.findViewById(R.id.ll1);
            datatype = (TextView)itemView.findViewById(R.id.text_type);

        }
    }
}
