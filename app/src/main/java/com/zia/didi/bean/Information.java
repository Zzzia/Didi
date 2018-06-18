package com.zia.didi.bean;

import java.io.Serializable;

/**
 * Created by zia on 2018/6/18.
 */
public class Information implements Serializable{
    private String distance;
    private String name;
    private String image;
    private String sex;
    private String location;
    private String price;
    private String introduce;

    @Override
    public String toString() {
        return "Information{" +
                "distance='" + distance + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
