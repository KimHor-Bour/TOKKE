package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataItemBookingTable {
    public class DataItemTable{
        //data items of table
//        public String img_table;
        public String table_number;
        public String floor;
        public String num_people;
        public String price_table;
        public String special_price_table;
        public String shape_table;
        public String description_table;
        public String deposit_table;

        DataItemTable (String table_number, String floor, String num_people,String price_table,String special_price_table,String shape_table, String description_table,String deposit_table){
            this.table_number = table_number;
            this.floor = floor;
            this.num_people = num_people;
            this.price_table = price_table;
            this.special_price_table = special_price_table;
            this.shape_table = shape_table;
            this.description_table = description_table;
            this.deposit_table = deposit_table;
        }

    }
    public DataItemBookingTable(){
        initDataItemTable();
    }

    private List<DataItemTable> data_tableitem;
    private  void initDataItemTable(){
        data_tableitem = new ArrayList<>();
        data_tableitem.add(new DataItemTable("Table Number 01","Ground floor","2","$10","$8","Circle","write description about table","120%"));
        data_tableitem.add(new DataItemTable("Table Number 02","1st floor","4","$10","$8","Retangle","write description about table","10%"));
        data_tableitem.add(new DataItemTable("Table Number 03","1st floor","2","$0","$8","Retangle","write description about table","50%"));
        data_tableitem.add(new DataItemTable("Table Number 04","2rd floor","2","$10"," ","Circle","write description about table","30%"));
        data_tableitem.add(new DataItemTable("Table Number 05","2rd floor","8","$10","$8","Circle","write description about table","10%"));
    }

    public List<DataItemTable> getData_tableitem(){return  data_tableitem;}

}
