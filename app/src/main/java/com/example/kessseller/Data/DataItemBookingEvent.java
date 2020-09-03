package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataItemBookingEvent {
    public class DataItemEvent{
        //data items of table
        public String event_name;
        public String event_ticket;
        public String event_price;
        public String event_specialprice;
        public String event_startdate;
        public String event_enddate;
        public String event_description;

        DataItemEvent(String event_name, String event_ticket, String event_price,String event_specialprice,String event_startdate, String event_enddate,String event_description){
            this.event_name = event_name;
            this.event_ticket = event_ticket;
            this.event_price = event_price;
            this.event_specialprice = event_specialprice;
            this.event_startdate= event_startdate;
            this.event_enddate = event_enddate;
            this.event_description = event_description;
        }

    }
    public DataItemBookingEvent(){
        initDataItemTable();
    }

    private List<DataItemEvent> dataItemEvents;
    private  void initDataItemTable(){
        dataItemEvents = new ArrayList<>();
        dataItemEvents.add(new DataItemEvent("Buffet","200","$20","$15","19/09/2020","20/08/2020","write description about event"));
        dataItemEvents.add(new DataItemEvent("white Party","500","$40","$20","19/09/2020","20/08/2020","write description about event"));
        dataItemEvents.add(new DataItemEvent("Lovely Day","350","$15.5","$10","19/09/2020","20/08/2020","write description about event"));
        dataItemEvents.add(new DataItemEvent("Dinner Time","290","$20","$10","19/09/2020 ","20/08/2020","write description about event"));
        dataItemEvents.add(new DataItemEvent("Red Light","50","$80","$70","19/09/2020","20/08/2020","write description about event"));
    }

    public List<DataItemEvent> getData_eventitem(){return  dataItemEvents;}

}
