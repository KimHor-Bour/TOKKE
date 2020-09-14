package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.Listener.ListenerBookingTable;
import com.example.kessseller.R;

import java.util.List;


public class AdapterTableStatus extends RecyclerView.Adapter<AdapterTableStatus.DataViewHolder> {
    List<DataItemBookingTable.DataItemTable> dataItemTables;
    BookingListener bookinglistener;
    ListenerBookingTable listenerBookingTable;

    public void setListenerBookingTable(ListenerBookingTable listenerBookingTable) {
        this.listenerBookingTable = listenerBookingTable;
    }

    public AdapterTableStatus(List<DataItemBookingTable.DataItemTable> dataItemTables) {
        this.dataItemTables = dataItemTables;

    }
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_table_status,parent,false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
        holder.dataNumTable.setText(dataItemTables.get(position).table_number);
        holder.dataNumPeopleTable.setText(dataItemTables.get(position).num_people);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listenerBookingTable != null){
                    listenerBookingTable.onClickItem(dataItemTables.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataItemTables.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView dataNumTable;
        TextView dataNumPeopleTable;
        TextView dataNumFloor;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            dataNumTable=(TextView)itemView.findViewById(R.id.number_type);
            dataNumPeopleTable=(TextView)itemView.findViewById(R.id.num_people);
//            dataNumFloor=(TextView)itemView.findViewById(R.id.num_floor);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.my_restatus);

        }
    }
}
