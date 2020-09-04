package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataItemAppointment {
    public class DataApp{
        //data items of table
        public String doctor_name;
        public String doctor_skill;
        public String doctor_degree;
        public String doctor_experient;
        public String doctor_dayoff;
        public String doctor_working_hour;

        DataApp(String doctor_name, String doctor_skill, String doctor_degree,String doctor_experient,String doctor_dayoff, String doctor_working_hour){
            this.doctor_name = doctor_name;
            this.doctor_skill = doctor_skill;
            this.doctor_degree = doctor_degree;
            this.doctor_experient = doctor_experient;
            this.doctor_dayoff= doctor_dayoff;
            this.doctor_working_hour = doctor_working_hour;
        }

        public String getDoctor_dayoff() {
            return doctor_dayoff;
        }

        public String getDoctor_degree() {
            return doctor_degree;
        }

        public String getDoctor_experient() {
            return doctor_experient;
        }

        public String getDoctor_name() {
            return doctor_name;
        }

        public String getDoctor_skill() {
            return doctor_skill;
        }

        public String getDoctor_working_hour() {
            return doctor_working_hour;
        }

    }
    public DataItemAppointment(){
        initDataItemAppointment();
    }

    private List<DataApp> dataApps;
    private  void initDataItemAppointment(){
        dataApps = new ArrayList<>();
        dataApps.add(new DataApp("Dr.Kim","General","Doctor","1 Years","sat/sun","9:00 AM - 5:00 PM"));
        dataApps.add(new DataApp("Dr.Kinh","Heart","Doctor","2 Years","sat/sun","9:00 AM - 5:00 PM"));
        dataApps.add(new DataApp("Dr.Sela","Ear","Doctor","3 Years","sat/sun","9:00 AM - 5:00 PM"));
        dataApps.add(new DataApp("Dr.Phing","Eye","Doctor","1 Years","sat/sun ","9:00 AM - 5:00 PM"));
        dataApps.add(new DataApp("Dr.Neat","General","Doctor","2 Years","1sat/sun","9:00 AM - 5:00 PM"));
    }

    public List<DataApp> getDataApps(){return  dataApps;}

}
