//package com.example.kessseller.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.kessseller.Data.DataItemBookingRoom;
//import com.example.kessseller.Listener.BookingListener;
//import com.example.kessseller.R;
//
//import java.util.List;
//
//public class AdapterMyItemRoom extends RecyclerView.Adapter<AdapterMyItemRoom.DataViewHolder> {
//    private List<DataItemBookingRoom> dataItemRooms;
//    LayoutInflater inflater;
//
//    BookingListener bookingListener;
//
//
//    public AdapterMyItemRoom(List<DataItemBookingRoom> dataItemRooms,Context context) {
//        this.inflater=LayoutInflater.from(context);
//        this.dataItemRooms = dataItemRooms;
//
//    }
//    public void setItemRoom(List<DataItemBookingRoom> dataItemRooms) {
//        this.dataItemRooms = dataItemRooms;
//        notifyDataSetChanged();
//    }
//
//
//
//    @NonNull
//    @Override
//    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_room, parent , false);
////        DataViewHolder dataViewHolder = new DataViewHolder(v);
//        return new DataViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, final int position) {
//        final DataItemBookingRoom dataItemRoom = dataItemRooms.get(position);
//
//        String name = dataItemRoom.getName();
//        Integer max_people = dataItemRoom.getMax_people();
//        double price = dataItemRoom.getPrice();
//        double special_price = dataItemRoom.getSpecial_price();
//        double deposit = dataItemRoom.getDeposit();
//
//        dataViewHolder.dataRoomNum.setText(name);
//        dataViewHolder.dataRoomNumPeople.setText(max_people);
//        dataViewHolder.dataRoomPrice.setText(Double.toString(price));
//        dataViewHolder.dataRoomSpecialPrice.setText(Double.toString(special_price));
//        dataViewHolder.dataDepositRoom.setText(Double.toString(deposit));
////        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                bookingListener.onItemClick(dataItemRoom);
////            }
////        });
//
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return dataItemRooms.size();
//    }
//
//    public static class DataViewHolder extends RecyclerView.ViewHolder {
//        public final CardView cv;
//        TextView dataRoomNum;
//        TextView dataRoomNumPeople;
//        TextView dataRoomPrice;
//        TextView dataRoomSpecialPrice;
//        TextView dataDepositRoom;
//
//        DataViewHolder(View itemView){
//            super(itemView);
//            cv = (CardView)itemView.findViewById(R.id.card_room_id);
//            dataRoomNum = (TextView)itemView.findViewById(R.id.room_num);
//            dataRoomNumPeople = (TextView)itemView.findViewById(R.id.room_num_people);
//            dataRoomPrice = (TextView)itemView.findViewById(R.id.room_price);
//            dataRoomSpecialPrice = (TextView)itemView.findViewById(R.id.room_special_price);
//            dataDepositRoom = (TextView)itemView.findViewById(R.id.room_deposit);
//
//        }
//    }
//}
