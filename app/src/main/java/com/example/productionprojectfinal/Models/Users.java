package com.example.productionprojectfinal.Models;

public class Users {

    String fname;
    String lname;
    String email;
    String UID;
    String role;

    public Users() {
    }

    public Users(String fname, String lname, String email, String UID, String role) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.UID = UID;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
