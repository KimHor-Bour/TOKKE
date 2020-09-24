package com.example.kessseller.Listener;

import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataItemBookingTable;
import com.example.kessseller.Data.DataMyItemTabBooking;

import java.util.Date;

public interface BookingListener {
    void onItemClick(DataItemBookingRoom dataItemRoom);
    void onTabClick(DataMyItemTabBooking.DataType dataType);
    void onItemCLick(DataItemBookingTable.DataItemTable dataItemTable);
    void onAccept(Date date);


}
