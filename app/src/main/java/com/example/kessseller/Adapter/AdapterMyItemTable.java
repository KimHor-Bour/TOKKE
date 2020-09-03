package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.R;

import java.util.List;

public class AdapterMyItemTable extends RecyclerView.Adapter<AdapterMyItemTable.DataViewHolder> {
    List<DataItemBookingTable.DataItemTable> dataItemTables;
    public AdapterMyItemTable(List<DataItemBookingTable.DataItemTable> dataItemTables) {
        this.dataItemTables=dataItemTables;

    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_table, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.dataTableNum.setText(dataItemTables.get(position).table_number);
        dataViewHolder.dataNumPeople.setText(dataItemTables.get(position).num_people);
//        dataViewHolder.dataFloor.setText(dataItemTables.get(position).floor);
        dataViewHolder.dataPrice.setText(dataItemTables.get(position).price_table);
        dataViewHolder.dataSpecialPrice.setText(dataItemTables.get(position).special_price_table);
        dataViewHolder.dataShap.setText(dataItemTables.get(position).shape_table);
        dataViewHolder.dataDepositTable.setText(dataItemTables.get(position).deposit_table);

    }



    @Override
    public int getItemCount() {
        return dataItemTables.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataTableNum;
//        TextView dataFloor;
        TextView dataNumPeople;
        TextView dataPrice;
        TextView dataSpecialPrice;
        TextView dataShap;
        TextView dataDepositTable;

        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_table_id);
            dataTableNum = (TextView)itemView.findViewById(R.id.table_num);
//            dataFloor = (TextView)itemView.findViewById(R.id.table_floor);
            dataNumPeople = (TextView)itemView.findViewById(R.id.table_num_people);
            dataPrice = (TextView)itemView.findViewById(R.id.table_price);
            dataSpecialPrice = (TextView)itemView.findViewById(R.id.table_special_price);
            dataShap = (TextView)itemView.findViewById(R.id.table_shape);
            dataDepositTable = (TextView)itemView.findViewById(R.id.table_deposit);

        }
    }
}
