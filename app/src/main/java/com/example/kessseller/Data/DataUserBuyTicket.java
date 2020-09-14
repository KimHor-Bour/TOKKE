package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataUserBuyTicket {
    public class DataBuyTicket {
        public String userBuy_ticket;
        public String dateBuy_ticket;
        public String numOrder_ticket;

        DataBuyTicket(String userBuy_ticket, String dateBuy_ticket, String numOrder_ticket) {
            this.userBuy_ticket = userBuy_ticket;
            this.dateBuy_ticket = dateBuy_ticket;
            this.numOrder_ticket = numOrder_ticket;
        }

        public String getUserBuy_ticket() {
            return userBuy_ticket;
        }

        public String getDateBuy_ticket() {
            return dateBuy_ticket;
        }

        public String getNumOrder_ticket() {
            return numOrder_ticket;
        }
    }

    public DataUserBuyTicket() {
        initData();
    }

    private List<DataBuyTicket> dataBuyTickets;

    private void initData() {
        dataBuyTickets = new ArrayList<>();
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
        dataBuyTickets.add(new DataBuyTicket("Kimhor", "01/09/2020  11:30 PM","3"));
    }

    public List<DataBuyTicket> getDataBuyTickets() {
        return dataBuyTickets;
    }

}



