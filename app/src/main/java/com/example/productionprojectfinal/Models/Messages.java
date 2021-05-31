package com.example.productionprojectfinal.Models;

public class Messages {
    String message;
    String senderID;
    Long timestamp;
    public Messages() {
    }

    public Messages(String message, String senderID, Long timestamp) {
        this.message = message;
        this.senderID = senderID;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
