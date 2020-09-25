package com.example.kessseller.Model;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelRoomList {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("max_people")
    private int max_people;
    @SerializedName("floor")
    private String floor;
    @SerializedName("price")
    private double price;
    @SerializedName("special_price")
    private double special_price;
    @SerializedName("shop_id")
    private int shop_id;
    @SerializedName("deposit")
    private double deposit;
    @SerializedName("description")
    private String description;
    @SerializedName("status")
    private String status;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("shop")
    private List<ModelShop> modelShops;
    @SerializedName("image")
    private List<ModelImageRoom> modelImageRooms;

    public ModelRoomList(String name, int max_people, double price, double special_price,
                         double deposit){
        this.name = name;
        this.max_people = max_people;
        this.price = price;
        this.special_price = special_price;
        this.deposit = deposit;

    }



    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
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

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ModelImageRoom> getImage() {
        return modelImageRooms;
    }

    public void setImage(List<ModelImageRoom> image) {
        this.modelImageRooms = image;
    }

    public List<ModelShop> getModelShops() {
        return modelShops;
    }

    public void setModelShops(List<ModelShop> modelShops) {
        this.modelShops = modelShops;
    }
}
