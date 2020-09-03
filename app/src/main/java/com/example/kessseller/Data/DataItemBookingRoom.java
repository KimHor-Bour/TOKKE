package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataItemBookingRoom {
    public class DataItemRoom{
        //data items of table
        public String room_number;
        public String room_floor;
        public String room_num_people;
        public String room_price;
        public String room_specialprice;
        public String room_description;
        public String room_deposit;

        DataItemRoom(String room_number, String room_floor, String room_num_people,String room_price,String room_specialprice, String room_description,String room_deposit){
            this.room_number = room_number;
            this.room_floor = room_floor;
            this.room_num_people = room_num_people;
            this.room_price = room_price;
            this.room_specialprice= room_specialprice;
            this.room_description = room_description;
            this.room_deposit = room_deposit;
        }
        public String getRoom_number(){return room_number;}
        public String getRoom_floor(){return room_floor;}
        public String getRoom_num_people(){return room_num_people;}
        public String getRoom_price(){return room_price;}
        public String getRoom_specialprice(){return room_specialprice;}
        public String getRoom_description(){return room_description;}
        public String getRoom_deposit(){return room_deposit;}

    }
    public DataItemBookingRoom(){
        initDataItemRoom();
    }

    private List<DataItemRoom> dataItemRooms ;
    private  void initDataItemRoom(){
        dataItemRooms = new ArrayList<>();
        dataItemRooms.add(new DataItemRoom("Number 01","Ground floor","2","$10","$8","write description about table","10%"));
        dataItemRooms.add(new DataItemRoom("Roomfdgfghjkjk Number 02","1st floor","4","$10","$8","write description about table","10%"));
        dataItemRooms.add(new DataItemRoom("Room Number 03","1st floor","2","$0","$8","write description about table","10%"));
        dataItemRooms.add(new DataItemRoom("Room Number 04","2rd floor","2","$10"," ","write description about table","10%"));
        dataItemRooms.add(new DataItemRoom("Room Number 05","2rd floor","8","$10","$8","write description about table","10%"));
    }

    public List<DataItemRoom> getData_roomitem(){return  dataItemRooms;}

}
