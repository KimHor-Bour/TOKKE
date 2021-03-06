package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.R;

import java.util.List;


public class AdapterRoomStatus extends RecyclerView.Adapter<AdapterRoomStatus.DataViewHolder> {
    List<DataItemBookingRoom> dataItemRooms;
    BookingListener bookinglistener;

    public void setBookinglistener(BookingListener bookinglistener) {
        this.bookinglistener = bookinglistener;
    }

    public AdapterRoomStatus(List<DataItemBookingRoom> dataItemRooms) {
        this.dataItemRooms = dataItemRooms;

    }
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_table_status,parent,false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
//        holder.dataNumId.setText(dataItemRooms.get(position).n);
//        holder.dataNumPeople.setText(dataItemRooms.get(position).room_num_people);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(bookinglistener != null){
//                    bookinglistener.onItemClick(dataItemRooms.get(position));
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return dataItemRooms.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView dataNumId;
        TextView dataNumPeople;
        TextView dataNumFloor;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            dataNumId=(TextView)itemView.findViewById(R.id.number_type);
            dataNumPeople=(TextView)itemView.findViewById(R.id.num_people);
//            dataNumFloor=(TextView)itemView.findViewById(R.id.num_floor);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.my_restatus);

        }
    }
}
