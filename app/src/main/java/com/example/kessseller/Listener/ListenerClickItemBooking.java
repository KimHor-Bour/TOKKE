package com.example.kessseller.Listener;

import com.example.kessseller.Data.DataItemBookingEvent;
import com.example.kessseller.Data.DataItemBookingRoom;
import com.example.kessseller.Data.DataItemBookingTable;

public interface ListenerClickItemBooking {
    void onClickItemEvent(DataItemBookingEvent.DataItemEvent dataItemEvent);
    void onClickItemTable(DataItemBookingTable.DataItemTable dataItemTable);
}
