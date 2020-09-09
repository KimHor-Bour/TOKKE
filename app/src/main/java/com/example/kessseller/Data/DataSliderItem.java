package com.example.kessseller.Data;

import java.util.ArrayList;
import java.util.List;

public class DataSliderItem {
    public class DataSlider {
        public String imageslide;

        DataSlider(String imageslide) {
            this.imageslide = imageslide;
        }

        public String getImageslide() {
            return imageslide;
        }
    }
    public DataSliderItem(){initDataSlider();}
    private List<DataSlider> dataSliders;
    private void initDataSlider() {
        dataSliders = new ArrayList<>();
        dataSliders.add(new DataSlider("doctor.jpg"));
        dataSliders.add(new DataSlider("doctor_card.jpg"));
    }
    public List<DataSlider> getDataSliders(){return dataSliders;}

}
