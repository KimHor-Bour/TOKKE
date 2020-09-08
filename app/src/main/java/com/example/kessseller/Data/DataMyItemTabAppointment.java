package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataMyItemTabAppointment {
    public static class DataTabAppointment{
        //data items of table
//        public String img_table;
        public String type_item;

        public DataTabAppointment(String type_item){
            this.type_item = type_item;

        }

        public String getType_item() {
            return type_item;
        }
    }
    public DataMyItemTabAppointment(){
        initDataType();
    }

    private List<DataTabAppointment> dataTabAppointments;
    private  void initDataType(){
        dataTabAppointments = new ArrayList<>();
        dataTabAppointments.add(new DataTabAppointment("General"));
        dataTabAppointments.add(new DataTabAppointment("Heart"));
        dataTabAppointments.add(new DataTabAppointment("Ear"));
        dataTabAppointments.add(new DataTabAppointment("Eye"));
    }
    public List<DataTabAppointment> getDataTabAppointments(){return  dataTabAppointments;}

}
