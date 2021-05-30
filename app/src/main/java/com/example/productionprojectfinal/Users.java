package com.example.productionprojectfinal;

public class Users {

    String name;
    String email;
    String UID;

    public Users() {
    }

    public Users(String name, String email, String UID) {
        this.name = name;
        this.email = email;
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
