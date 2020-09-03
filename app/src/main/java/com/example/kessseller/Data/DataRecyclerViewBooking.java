package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataRecyclerViewBooking {
    public class  DataRecycler{
        public  String user;
        public  String date;
        public  String filter_type;
        public String bookingdate;
        public String booking_id;
        public String type;
        public String payment_method;
        public String deposit_price;

        DataRecycler(String user,String date,String filter_type, String bookingdate, String booking_id,
                         String type, String payment_method, String deposit_price){
            this.user = user;
            this.date = date;
            this.filter_type = filter_type;
            this.bookingdate = bookingdate;
            this.booking_id = booking_id;
            this.type = type;
            this.payment_method = payment_method;
            this.deposit_price = deposit_price;
        }

        public String getBooking_id() {
            return booking_id;
        }

        public String getBookingdate() {
            return bookingdate;
        }

        public String getDate() {
            return date;
        }

        public String getDeposit_price() {
            return deposit_price;
        }

        public String getFilter_type() {
            return filter_type;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public String getType() {
            return type;
        }

        public String getUser() {
            return user;
        }
    }

    public DataRecyclerViewBooking() {
        initData();
    }
    private List<DataRecycler> data;
    private void  initData(){
        data = new ArrayList<>();
        data.add(new DataRecycler("Bour Kim Hor","Auguest 08 2020  11:30AM",
                "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#428567",
                "Table Number 09","KESS pay","10$"));
        data.add(new DataRecycler("Ly KimLeang","Auguest 09 2020  11:30AM",
                "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                "Table Number 09","KESS pay","11$"));
        data.add(new DataRecycler("Songeam Sela","Auguest 01 2020  11:30AM",
                "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                "Table Number 09","KESS pay","11$"));
        data.add(new DataRecycler("Songeam Sela","Auguest 01 2020  11:30AM",
                "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                "Table Number 09","KESS pay","11$"));
    }

    public List<DataRecycler> getDataRecycler() {
        return data;
    }




}

