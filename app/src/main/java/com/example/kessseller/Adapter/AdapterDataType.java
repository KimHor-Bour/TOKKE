package com.example.kessseller.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Data.DataMyItemTab;

import com.example.kessseller.Listener.TabListener;
import com.example.kessseller.R;

import java.util.List;

public class AdapterDataType extends RecyclerView.Adapter<AdapterDataType.DataViewHolder> {
    List<DataMyItemTab.DataType> dataTypes;
    public AdapterDataType(List<DataMyItemTab.DataType> dataTypes) {
        this.dataTypes=dataTypes;

    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tap_item, parent , false);
        DataViewHolder dataViewHolder = new DataViewHolder(v);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.datatype.setText(dataTypes.get(position).type_item);
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

    public void setTabListener(TabListener tabListener) {
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {
//        LinearLayout ll;
        TextView datatype;

        DataViewHolder(View itemView){
            super(itemView);
//            ll = (LinearLayout) itemView.findViewById(R.id.ll1);
            datatype = (TextView)itemView.findViewById(R.id.text_type);

        }
    }
}
