package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataCodeTicket {
    public class DataTicket{
        //data items of table
        public String codeTicket;


        DataTicket(String codeTicket){
            this.codeTicket = codeTicket;
        }

        public String getCodeTicket() {
            return codeTicket;
        }

    }
    public DataCodeTicket(){
        initDataTicket();
    }

    private List<DataTicket> dataTickets;
    private  void initDataTicket(){
        dataTickets = new ArrayList<>();
        dataTickets.add(new DataTicket("001"));
        dataTickets.add(new DataTicket("002"));
        dataTickets.add(new DataTicket("003"));
        dataTickets.add(new DataTicket("004"));
        dataTickets.add(new DataTicket("005"));
        dataTickets.add(new DataTicket("006"));
        dataTickets.add(new DataTicket("007"));
    }

    public List<DataTicket> getDataTickets(){return  dataTickets;}

}
