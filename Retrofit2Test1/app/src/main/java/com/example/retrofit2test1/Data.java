package com.example.retrofit2test1;

public class Data {

    public String userId;
    public String id;
    public String title;
    public String completed;

    public Data(String userId, String id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return completed;
    }
}
