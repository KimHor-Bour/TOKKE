package com.example.kessseller.Model;

import com.google.gson.annotations.SerializedName;

public class ModelImageRoom {
    @SerializedName("id")
    private  int id;
    @SerializedName("item_id")
    private  int item_id;
    @SerializedName("type")
    private String type;
    @SerializedName("image")
    private String image;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public int getId() {
        return id;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getCreate_at() {
        return created_at;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getUpdate_at() {
        return updated_at;
    }

}
