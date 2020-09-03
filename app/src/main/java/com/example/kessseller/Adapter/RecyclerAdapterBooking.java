package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataRecyclerViewBooking;
import com.example.kessseller.R;

import java.util.List;

public class RecyclerAdapterBooking extends RecyclerView.Adapter<RecyclerAdapterBooking.DataViewHolder> {
    List<DataRecyclerViewBooking.DataRecycler> datas;
    public RecyclerAdapterBooking(List<DataRecyclerViewBooking.DataRecycler> datas) {
        this.datas=datas;

    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_booking, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.dataName.setText(datas.get(position).user);
        dataViewHolder.dataDate.setText(datas.get(position).date);
        dataViewHolder.dataTime.setText(datas.get(position).bookingdate);
        dataViewHolder.dataBookingCode.setText(datas.get(position).booking_id);
        dataViewHolder.dataType.setText(datas.get(position).type);
        dataViewHolder.dataPayment.setText(datas.get(position).payment_method);
        dataViewHolder.dataDeposit.setText(datas.get(position).deposit_price);
        dataViewHolder.datafilter.setText(datas.get(position).filter_type);
    }

    @Override
    public int getItemCount() {
        return datas.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView dataName;
        TextView dataDate;
        TextView dataTime;
        TextView dataBookingCode;
        TextView dataType;
        TextView dataPayment;
        TextView datafilter;
        TextView dataDeposit;

        DataViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardid);
            dataName = (TextView)itemView.findViewById(R.id.profile_name);
            dataDate = (TextView)itemView.findViewById(R.id.date);
            dataBookingCode = (TextView)itemView.findViewById(R.id.booking_code);
            datafilter = (TextView)itemView.findViewById(R.id.filter);
            dataTime = (TextView)itemView.findViewById(R.id.booking_date);
            dataPayment = (TextView)itemView.findViewById(R.id.payment_data);
            dataDeposit = (TextView)itemView.findViewById(R.id.deposit);
            dataType = (TextView)itemView.findViewById(R.id.tpye_data);

        }
    }
}
