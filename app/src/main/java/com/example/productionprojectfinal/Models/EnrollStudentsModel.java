package com.example.productionprojectfinal.Models;

public class EnrollStudentsModel {
    String classid;
    String uid;

    public EnrollStudentsModel(String classid, String uid) {
        this.classid = classid;
        this.uid = uid;
    }

    public EnrollStudentsModel() {
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
