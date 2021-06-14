package com.example.productionprojectfinal.Models;

public class ClassModel {
    String classdescription, classid, classkey, classname, classpassword, uid;

    public ClassModel() {
    }

    public ClassModel(String classdescription, String classid, String classkey, String classsname, String classpassword, String uid) {
        this.classdescription = classdescription;
        this.classid = classid;
        this.classkey = classkey;
        this.classname = classsname;
        this.classpassword = classpassword;
        this.uid = uid;
    }

    public String getClassdescription() {
        return classdescription;
    }

    public void setClassdescription(String classdescription) {
        this.classdescription = classdescription;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClasskey() {
        return classkey;
    }

    public void setClasskey(String classkey) {
        this.classkey = classkey;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClasspassword() {
        return classpassword;
    }

    public void setClasspassword(String classpassword) {
        this.classpassword = classpassword;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
