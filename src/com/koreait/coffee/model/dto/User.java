package com.koreait.coffee.model.dto;

public class User {
    private Integer id;
    private String name;
    private String phoneNumber;
    private double point;
    private Integer type;

    public User(Integer id, String name, String phoneNumber, Integer point, Integer type) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
        this.type = type;
    }

    public User() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", point=" + point +
                ", type=" + type +
                '}';
    }
}
