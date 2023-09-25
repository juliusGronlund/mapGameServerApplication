package com.mapgameserverapplication.objects;

public class Player {
    private String password;
    private boolean seeker;

    public Player(String password, boolean seeker) {
        this.password = password;
        this.seeker = seeker;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSeeker() {
        return seeker;
    }
}
