package com.mapgameserverapplication.lists;

import com.mapgameserverapplication.objects.LatLngLocation;
import com.mapgameserverapplication.objects.Player;

import java.util.ArrayList;
import java.util.List;

public class Matches {
    private List<Player> seekers = new ArrayList<>();
    private List<Player> hiders = new ArrayList<>();

    public void matchPlayers(Player playerOne, Player playerTwo) {
        if(playerOne.isSeeker() && !playerTwo.isSeeker()) {
            seekers.add(playerOne);
            hiders.add(playerTwo);
        }
        else {
            seekers.add(playerTwo);
            hiders.add(playerOne);
        }
    }

    public boolean containsMatch(String password) {
        Player seeker = null;
        Player hider = null;

        for(Player s : seekers) {
            if(s.getPassword().equals(password))
                seeker = s;
        }

        for(Player h : hiders) {
            if(h.getPassword().equals(password))
                hider = h;
        }

        if(seeker == null || hider == null) {
            return false;
        }

        seekers.remove(seeker);
        hiders.remove(hider);
        return true;//Match removed
    }

    public LatLngLocation getLastKnownLocation(Player player) {
        for(Player h : hiders) {
            if(h.equals(player)) {
                return h.getLastKnownLocation();
            }

        }
        for(Player s : seekers) {
            if(s.equals(player)) {
                return s.getLastKnownLocation();
            }
        }
        return player.getLastKnownLocation();
    }

    public boolean setLastKnownLocation(Player player, LatLngLocation latLngLocation) {
        for(Player h : hiders) {
            if(h.equals(player)) {
                h.setLastKnownLocation(latLngLocation);
                return true;
            }

        }
        for(Player s : seekers) {
            if(s.equals(player)) {
                s.setLastKnownLocation(latLngLocation);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        seekers.clear();
        hiders.clear();
    }

    @Override
    public String toString() {
        return "Matches{" +
                "seekers=" + seekers +
                ", hiders=" + hiders +
                '}';
    }
}
