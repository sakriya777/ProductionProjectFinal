package com.example.productionprojectfinal;

public class Users {

    String fname;
    String lname;
    String email;
    String UID;

    public Users() {
    }

    public Users(String fname, String lname, String email, String UID) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.UID = UID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
