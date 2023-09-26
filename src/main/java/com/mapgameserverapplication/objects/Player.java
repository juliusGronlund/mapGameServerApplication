package com.mapgameserverapplication.objects;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Player{" +
                "password='" + password + '\'' +
                ", seeker=" + seeker +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Player p = (Player) o;
        if (this == o)
            return true;
        if (this.password.equals(p.password) && this.seeker == p.seeker)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, seeker);
    }
}
