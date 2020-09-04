package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataViewAppointment {
    public class DataAppointment{
                public  String username;
                public  String daterequest;
                public  String choice_filter;
                public String appointment_date;
                public String appointment_code;
                public String appointment_doctorname;
                public String appointment_skill;
                DataAppointment(String username,String daterequest,String choice_filter, String appointment_date, String appointment_code,
                             String appointment_doctorname, String appointment_skill){
                    this.username = username;
                    this.daterequest = daterequest;
                    this.choice_filter = choice_filter;
                    this.appointment_date = appointment_date;
                    this.appointment_code = appointment_code;
                    this.appointment_doctorname = appointment_doctorname;
                    this.appointment_skill = appointment_skill; }

                public String getUsername() {
                    return username;
                }

                public String getDaterequest() {
                    return daterequest;
                }

                public String getChoice_filter() {
                    return choice_filter;
                }

                public String getAppointment_date() {
                    return appointment_date;
                }

                public String getAppointment_code() {
                    return appointment_code;
                }

                public String getAppointment_doctorname() {
                    return appointment_doctorname;
                }

                public String getAppointment_skill() {
                    return appointment_skill;
                }
            }

            public DataViewAppointment() {
                initDataAppointment();
            }
            private List<DataAppointment> dataAppointments;
            private void  initDataAppointment(){
                dataAppointments = new ArrayList<>();
                dataAppointments.add(new DataAppointment("Bour Kim Hor","Auguest 08 2020  11:30AM",
                        "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#428567",
                        "Dr. Kim","Eye, General"));
                dataAppointments.add(new DataAppointment("Ly KimLeang","Auguest 09 2020  11:30AM",
                        "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                        "Dr. Kim","Heart"));
                dataAppointments.add(new DataAppointment("Songeam Sela","Auguest 01 2020  11:30AM",
                        "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                        "Dr. Kinh","Ear"));
                dataAppointments.add(new DataAppointment("Songeam Sela","Auguest 01 2020  11:30AM",
                        "Pending","Auguest 09 2020  1:30 PM - 5:00 PM","#420567",
                        "Dr. Kinh","Heart"));
            }

            public List<DataAppointment> getDataAppointments() {
                return dataAppointments;
            }
}

