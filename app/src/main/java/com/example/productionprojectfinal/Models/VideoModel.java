package com.example.productionprojectfinal.Models;

public class VideoModel {
    String name, videourl, uid, title, timestamp, topic, description;

    public VideoModel() {
    }

    public VideoModel(String name, String videourl, String uid, String title, String timestamp, String topic, String description) {
        this.name = name;
        this.videourl = videourl;
        this.uid = uid;
        this.title = title;
        this.timestamp = timestamp;
        this.topic = topic;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
