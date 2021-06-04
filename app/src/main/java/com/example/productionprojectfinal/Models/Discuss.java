package com.example.productionprojectfinal.Models;

public class Discuss {
    String key;
    String about;
    String title;
    String discuss;
    String id;
    String postid;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }



    public Discuss(String key, String about, String title, String discuss, String id, String postid) {
        this.key = key;
        this.about = about;
        this.title = title;
        this.discuss = discuss;
        this.id = id;
        this.postid = postid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscuss() {
        return discuss;
    }

    public void setDiscuss(String discuss) {
        this.discuss = discuss;
    }

    public Discuss() {
    }


}
