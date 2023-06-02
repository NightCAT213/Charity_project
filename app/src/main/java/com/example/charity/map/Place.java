package com.example.charity.map;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;

public class Place {

    public Place(long id, String title, String description, String picture, String address, String phone, double coords1, double coords2) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.address = address;
        this.phone = phone;
        this.coords1 = coords1;
        this.coords2 = coords2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public LatLng getLatLng() {
        return new LatLng(coords1, coords2);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCoords1() {
        return coords1;
    }

    public void setCoords1(double coords1) {
        this.coords1 = coords1;
    }

    public double getCoords2() {
        return coords2;
    }

    public void setCoords2(double coords2) {
        this.coords2 = coords2;
    }

    private long id;
    private String title;
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", coords1=" + coords1 +
                ", coords2=" + coords2 +
                '}';
    }

    private String picture;
    private String address;
    private String link;
    private String phone;
    private double coords1;
    private double coords2;




}