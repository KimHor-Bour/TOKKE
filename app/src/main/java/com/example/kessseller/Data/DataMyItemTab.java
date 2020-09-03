package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataMyItemTab {
    public static class DataType{
        //data items of table
//        public String img_table;
        public String type_item;

        public DataType(String type_item){
            this.type_item = type_item;

        }

        public String getType_item() {
            return type_item;
        }
    }
    public DataMyItemTab(){
        initDataType();
    }

    private List<DataType> dataTypes;
    private  void initDataType(){
        dataTypes = new ArrayList<>();
//        dataTypes.add(new DataType("Product"));
        dataTypes.add(new DataType("Product"));
        dataTypes.add(new DataType("Table"));
        dataTypes.add(new DataType("Room"));
        dataTypes.add(new DataType("Event"));
    }
    public List<DataType> getData_type(){return  dataTypes;}

}
