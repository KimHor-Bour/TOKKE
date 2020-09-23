package com.example.kessseller.Listener;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataMyItemTabBooking;

import java.util.Date;

public interface BookingListener {
    void onItemClick(DataItemBookingRoom dataItemRoom);
    void onTabClick(DataMyItemTabBooking.DataType dataType);
    void onAccept(Date date);


}
