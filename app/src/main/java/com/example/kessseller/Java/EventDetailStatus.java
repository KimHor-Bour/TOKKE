package com.example.kessseller.Java;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterUserBuyTicket;
import com.example.kessseller.ButtonSheet.BTSDetailUserBuyTicket;
import com.example.kessseller.Data.DataUserBuyTicket;
import com.example.kessseller.Listener.ListenerEventDetail;
import com.example.kessseller.R;

import java.util.List;

public class EventDetailStatus extends AppCompatActivity {
    List<DataUserBuyTicket.DataBuyTicket> dataBuyTickets;
    RecyclerView recyclerView;
    Context context;
    ImageView imageView;

    private ListenerEventDetail listenerEventDetail = new ListenerEventDetail() {
        @Override
        public void onClickUserItem(DataUserBuyTicket.DataBuyTicket dataBuyTicket) {
            BTSDetailUserBuyTicket btsDetailUserBuyTicket = new BTSDetailUserBuyTicket(context);
            btsDetailUserBuyTicket.show(getSupportFragmentManager(),BTSDetailUserBuyTicket.class.getSimpleName());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail_status);
        DataUserBuyTicket dataBuyTicket = new DataUserBuyTicket();
        dataBuyTickets = dataBuyTicket.getDataBuyTickets();
        recyclerView=(RecyclerView)findViewById(R.id.re_eventDetail);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        AdapterUserBuyTicket adapterUserBuyTicket = new AdapterUserBuyTicket(dataBuyTickets);
        recyclerView.setAdapter(adapterUserBuyTicket);
        adapterUserBuyTicket.setListenerEventDetail(listenerEventDetail);

        imageView = findViewById(R.id.back_arrow_detailevent);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
