package com.example.kessseller.Listener;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataRecyclerViewBooking;

import java.util.Date;

public interface BookingListener {
    void onItemClick(DataItemBookingRoom.DataItemRoom dataItemRoom);
    void onAccept(Date date);
}
