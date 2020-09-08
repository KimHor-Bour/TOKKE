package com.example.kessseller.Listener;

import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataMyItemTabAppointment;

public interface AppointmentListener {
    void onClickItem (DataItemAppointment.DataApp dataApp);
    void onClickTab(DataMyItemTabAppointment.DataTabAppointment dataTabAppointment);
}
