package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.R;

import java.util.List;

public class AdapterOfItemEvent extends RecyclerView.Adapter<AdapterOfItemEvent.DataViewHolder> {
    List<DataItemBookingEvent.DataItemEvent> dataItemEvents;
    public AdapterOfItemEvent(List<DataItemBookingEvent.DataItemEvent> dataItemEvents) {
        this.dataItemEvents=dataItemEvents;

    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_event, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.dataEventName.setText(dataItemEvents.get(position).event_name);
        dataViewHolder.dataEventTicket.setText(dataItemEvents.get(position).event_ticket);
        dataViewHolder.dataEventPrice.setText(dataItemEvents.get(position).event_price);
        dataViewHolder.dataEventSpecialPrice.setText(dataItemEvents.get(position).event_specialprice);
        dataViewHolder.dataEventStartDate.setText(dataItemEvents.get(position).event_startdate);
        dataViewHolder.dataEventEndDate.setText(dataItemEvents.get(position).event_enddate);

    }



    @Override
    public int getItemCount() {
        return dataItemEvents.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataEventName;
        TextView dataEventTicket;
        TextView dataEventPrice;
        TextView dataEventSpecialPrice;
        TextView dataEventStartDate;
        TextView dataEventEndDate;
//        TextView dataDescription;

        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_event_id);
            dataEventName = (TextView)itemView.findViewById(R.id.event_name);
            dataEventTicket = (TextView)itemView.findViewById(R.id.event_ticket);
            dataEventPrice = (TextView)itemView.findViewById(R.id.event_price);
            dataEventSpecialPrice = (TextView)itemView.findViewById(R.id.event_specialprice);
            dataEventStartDate = (TextView)itemView.findViewById(R.id.event_statedate);
            dataEventEndDate = (TextView)itemView.findViewById(R.id.event_enddate);
//            dataDescription = (TextView)itemView.findViewById(R.id.);

        }
    }
}
