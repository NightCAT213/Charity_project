package com.example.charity.domain;

public class Vacancy {
    private long id;
    private String title;
    private String description;
    private String address;
    private String phone;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    private Integer cost;

    public Vacancy() {
        super();
    }

    public Vacancy(long id, String title, String description, String address, String phone, Integer cost) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.cost = cost;
    }

    public long getId() {
        return id;
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

    public void setDescription(String description) {
        this.description = description;
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
}
