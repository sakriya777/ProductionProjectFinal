package com.example.productionprojectfinal.Models;

public class LessonModel {
    String name;
    String lesson;
    String number;
    String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LessonModel(String name, String lesson, String number, String content) {
        this.name = name;
        this.lesson = lesson;
        this.number = number;
        this.content = content;
    }

    public LessonModel() {
    }
}
