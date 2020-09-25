package com.example.kessseller.AdapterAPI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Model.ModelRoomList;
import com.example.kessseller.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterGetRoom extends RecyclerView.Adapter<AdapterGetRoom.ViewHolder> {
    private Context context;
    private ArrayList<ModelRoomList> modelRoomList;

    public AdapterGetRoom(ArrayList<ModelRoomList> modelRoomLists){
        this.modelRoomList = modelRoomLists;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_item_room,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelRoomList modelDataList = modelRoomList.get(position);

        holder.dataRoomNum.setText(modelDataList.getName());
        holder.dataRoomNumPeople.setText(modelDataList.getMax_people());
        holder.dataRoomPrice.setText(String.valueOf(modelDataList.getPrice()));
        holder.dataRoomSpecialPrice.setText(String.valueOf(modelDataList.getSpecial_price()));
        holder.dataDepositRoom.setText(String.valueOf(modelDataList.getDeposit()));

    }

    @Override
    public int getItemCount() {
        return modelRoomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final CardView cv;
        TextView dataRoomNum;
        TextView dataRoomNumPeople;
        TextView dataRoomPrice;
        TextView dataRoomSpecialPrice;
        TextView dataDepositRoom;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_room_id);
            dataRoomNum = (TextView)itemView.findViewById(R.id.room_item_num);
            dataRoomNumPeople = (TextView)itemView.findViewById(R.id.room_item_numPeople);
            dataRoomPrice = (TextView)itemView.findViewById(R.id.room_item_price);
            dataRoomSpecialPrice = (TextView)itemView.findViewById(R.id.room_item_specialPrice);
            dataDepositRoom = (TextView)itemView.findViewById(R.id.room_item_deposit);

        }
    }
}
