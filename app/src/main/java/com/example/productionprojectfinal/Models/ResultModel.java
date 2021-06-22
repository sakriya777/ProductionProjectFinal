package com.example.productionprojectfinal.Models;

public class ResultModel {

    String classid, correct, incorrect, total, uid;

    public ResultModel(String classid, String correct, String incorrect, String total, String uid) {
        this.classid = classid;
        this.correct = correct;
        this.incorrect = incorrect;
        this.total = total;
        this.uid = uid;
    }

    public ResultModel() {
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(String incorrect) {
        this.incorrect = incorrect;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
