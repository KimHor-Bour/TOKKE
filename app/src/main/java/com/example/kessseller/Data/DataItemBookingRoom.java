package com.example.kessseller.Data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataItemBookingRoom {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("max_people")
    private Integer max_people;
    @SerializedName("floor")
    private String floor;
    @SerializedName("price")
    private double price;
    @SerializedName("special_price")
    private double special_price;
    @SerializedName("deposit")
    private double deposit;
    @SerializedName("description")
    private String description;

    public DataItemBookingRoom(Integer id, String name, Integer max_people, String floor,
                               double price, double special_price, double deposit, String description){
        this.id = id;
        this.name = name;
        this.max_people = max_people;
        this.floor = floor;
        this.price= price;
        this.special_price = special_price;
        this.deposit = deposit;
        this.description = description;
    }

    public DataItemBookingRoom() {

    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Integer getMax_people() {
        return max_people;
    }

    public void setMax_people(Integer max_people) {
        this.max_people = max_people;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(double special_price) {
        this.special_price = special_price;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DataItemBookingRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max_people=" + max_people +
                ", floor='" + floor + '\'' +
                ", price=" + price +
                ", special_price=" + special_price +
                ", deposit=" + deposit +
                ", description='" + description + '\'' +
                '}';
    }

    public void add(List<DataItemBookingRoom> dataItemRooms) {
    }
}
