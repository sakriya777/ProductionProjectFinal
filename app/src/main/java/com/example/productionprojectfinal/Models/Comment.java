package com.example.productionprojectfinal.Models;

public class Comment {
    String comment;
    String commenterid;
    String postid;

    public Comment(String comment, String commenterid, String postid) {
        this.comment = comment;
        this.commenterid = commenterid;
        this.postid = postid;
    }

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenterid() {
        return commenterid;
    }

    public void setCommenterid(String commenterid) {
        this.commenterid = commenterid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }
}
