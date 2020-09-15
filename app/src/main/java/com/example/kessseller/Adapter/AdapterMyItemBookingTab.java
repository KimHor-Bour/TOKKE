package com.example.kessseller.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataMyItemTabBooking;

import com.example.kessseller.Listener.BookingListener;
import com.example.kessseller.R;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class AdapterMyItemBookingTab extends RecyclerView.Adapter<AdapterMyItemBookingTab.DataViewHolder> {
    List<DataMyItemTabBooking.DataType> dataTypes;
    BookingListener bookingListener;
    LinearLayout linearLayout;
    private int selectedTabBooking;
    Context context;



    public AdapterMyItemBookingTab(List<DataMyItemTabBooking.DataType> dataTypes,Context context) {
        this.dataTypes=dataTypes;
        this.context = context;
        selectedTabBooking = 0;

    }
    public void setBookinglistener(BookingListener bookinglistener) {
        this.bookingListener = bookinglistener;
    }



    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tap_item, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        linearLayout = v.findViewById(R.id.ll1);

        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, final int position) {
        dataViewHolder.datatype.setText(dataTypes.get(position).type_item);
        dataViewHolder.view1.setBackgroundColor(context.getResources().getColor(R.color.colorblurGrey));
         if(selectedTabBooking == position){
             dataViewHolder.view1.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
         }

        dataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int previousTabBooking = selectedTabBooking;
                selectedTabBooking = position;
                notifyItemChanged(previousTabBooking);
                notifyItemChanged(selectedTabBooking);

                if (bookingListener != null) {
                    bookingListener.onTabClick(dataTypes.get(position));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTypes.size();
//        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        View view1;
        TextView datatype;
        DataViewHolder(View itemView){
            super(itemView);
            view1 = (View) itemView.findViewById(R.id.ll1);
            datatype = (TextView)itemView.findViewById(R.id.text_type);

        }
    }

}
