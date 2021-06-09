package com.example.productionprojectfinal.Models;

public class CourseModel {
    String name;
    String chap;
    String number;

    public CourseModel(String name, String chap, String number) {
        this.name = name;
        this.chap = chap;
        this.number = number;
    }

    public String getChap() {
        return chap;
    }

    public void setChap(String chap) {
        this.chap = chap;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CourseModel() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CourseModel(String name) {
        this.name = name;
    }


}
