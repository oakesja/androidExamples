package com.example.joakes.pageviewexample;

/**
 * Created by joakes on 4/23/15.
 */
public class Website {
    private String title;
    private String url;

    public Website(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
