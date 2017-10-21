package com.mohammed.medicaldirectoryy.model;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abdallah on 04/05/17.
 */

public class Hospitals {

    @SerializedName("name")
    private String name;
    @SerializedName("address")
    private String address;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("image")
    private Image image;



    public Hospitals(String name, String address , String telephone, Image image){
        this.name=name;
        this.address=address;
        this.telephone=telephone;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

