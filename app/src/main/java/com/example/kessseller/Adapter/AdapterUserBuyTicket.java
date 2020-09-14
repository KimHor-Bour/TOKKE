package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataUserBuyTicket;
import com.example.kessseller.Listener.ListenerEventDetail;
import com.example.kessseller.R;

import java.util.List;

public class AdapterUserBuyTicket extends RecyclerView.Adapter<AdapterUserBuyTicket.DataViewHolder> {
    List<DataUserBuyTicket.DataBuyTicket> dataBuyTickets;
    ListenerEventDetail listenerEventDetail;

    public void setListenerEventDetail(ListenerEventDetail listenerEventDetail){
        this.listenerEventDetail = listenerEventDetail;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_user_buy_ticket,parent,false);
        DataViewHolder dataViewHolder = new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
        holder.dataUserName.setText(dataBuyTickets.get(position).userBuy_ticket);
        holder.dataDateBuy.setText(dataBuyTickets.get(position).dateBuy_ticket);
        holder.dataNumBuyTicket.setText(dataBuyTickets.get(position).numOrder_ticket);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listenerEventDetail != null){
                    listenerEventDetail.onClickUserItem(dataBuyTickets.get(position));

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBuyTickets.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView dataUserName;
        TextView dataDateBuy;
        TextView dataNumBuyTicket;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardBuyTicket);
            dataUserName = (TextView)itemView.findViewById(R.id.userEventDetail);
            dataDateBuy = (TextView)itemView.findViewById(R.id.dateEventDetail);
            dataNumBuyTicket = (TextView)itemView.findViewById(R.id.qtyTicket);
        }
    }
    public AdapterUserBuyTicket(List<DataUserBuyTicket.DataBuyTicket> dataBuyTickets){
        this.dataBuyTickets=dataBuyTickets;
    }
}
