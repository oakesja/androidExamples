package com.example.joakes.cardsrecyclerviewexample;

/**
 * Created by joakes on 4/20/15.
 */
public class Game {
    public static final int XBOX360 = 360;
    public static final int XBOX_ONE = 720;
    public int coverArtId;
    public String title;
    public int type;

    public Game(int coverArtId, String title, int type) {
        this.coverArtId = coverArtId;
        this.title = title;
        this.type = type;
    }

    public int getCoverArtId() {
        return coverArtId;
    }

    public void setCoverArtId(int coverArtId) {
        this.coverArtId = coverArtId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
