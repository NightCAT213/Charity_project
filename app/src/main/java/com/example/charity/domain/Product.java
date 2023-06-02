package com.example.charity.domain;

public class Product {
    public Product(long id, String title, String category, String description, String picture, String address, String phone, double coords1, double coords2, Integer cost, String link) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.picture = picture;
        this.address = address;
        this.phone = phone;
        this.coords1 = coords1;
        this.coords2 = coords2;
        this.cost = cost;
        this.link = link;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private long id;
    private String title;
    private String description;
    private String category;

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
    private Integer cost;
}




/*
    public Product(int id, String title, int cost, Drawable image) {
        this.id = id;
        this.title = title;
        description = "descriptionDefault";
        this.cost = cost;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Drawable getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }*/
