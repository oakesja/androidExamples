package com.example.joakes.cardsrecyclerviewexample;

/**
 * Created by joakes on 4/20/15.
 */
public class Game {
    public int coverArtId;
    public String title;

    public Game(int coverArtId, String title) {
        this.coverArtId = coverArtId;
        this.title = title;
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
}
