package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.R;

import java.util.List;

public class AdapterMyItemRoom extends RecyclerView.Adapter<AdapterMyItemRoom.DataViewHolder> {
    List<DataItemBookingRoom.DataItemRoom> dataItemRooms;
    BookingListener bookingListener;
    public AdapterMyItemRoom(List<DataItemBookingRoom.DataItemRoom> dataItemRooms) {
        this.dataItemRooms=dataItemRooms;

    }
    public void setBookinglistener(BookingListener bookinglistener) {
        this.bookingListener = bookinglistener;
    }



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_room, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, final int position) {
        dataViewHolder.dataRoomNum.setText(dataItemRooms.get(position).room_number);
        dataViewHolder.dataRoomNumPeople.setText(dataItemRooms.get(position).room_num_people);
//        dataViewHolder.dataFloor.setText(dataItemTables.get(position).floor);
        dataViewHolder.dataRoomPrice.setText(dataItemRooms.get(position).room_price);
        dataViewHolder.dataRoomSpecialPrice.setText(dataItemRooms.get(position).room_specialprice);
        dataViewHolder.dataDepositRoom.setText(dataItemRooms.get(position).room_deposit);
        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookingListener!= null){
                    bookingListener.onItemClick(dataItemRooms.get(position));
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return dataItemRooms.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataRoomNum;
//        TextView dataFloor;
        TextView dataRoomNumPeople;
        TextView dataRoomPrice;
        TextView dataRoomSpecialPrice;
        TextView dataDepositRoom;

        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_room_id);
            dataRoomNum = (TextView)itemView.findViewById(R.id.room_num);
//            dataFloor = (TextView)itemView.findViewById(R.id.table_floor);
            dataRoomNumPeople = (TextView)itemView.findViewById(R.id.room_num_people);
            dataRoomPrice = (TextView)itemView.findViewById(R.id.room_price);
            dataRoomSpecialPrice = (TextView)itemView.findViewById(R.id.room_special_price);
            dataDepositRoom = (TextView)itemView.findViewById(R.id.room_deposit);

        }
    }
}
