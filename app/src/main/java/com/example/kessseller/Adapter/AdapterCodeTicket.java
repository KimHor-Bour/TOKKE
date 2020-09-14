package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataCodeTicket;
import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.Listener.ListenerBookingTable;
import com.example.kessseller.R;

import java.util.List;


public class AdapterCodeTicket extends RecyclerView.Adapter<AdapterCodeTicket.DataViewHolder> {
    List<DataCodeTicket.DataTicket> dataTickets;


    public AdapterCodeTicket(List<DataCodeTicket.DataTicket> dataTickets) {
        this.dataTickets = dataTickets;

    }
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_ticket_code,parent,false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
        holder.dataCode.setText(dataTickets.get(position).codeTicket);

    }

    @Override
    public int getItemCount() {
        return dataTickets.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView dataCode;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            dataCode=(TextView)itemView.findViewById(R.id.txtCode);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.re_code_ticket);

        }
    }
}
