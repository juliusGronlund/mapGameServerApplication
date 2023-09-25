package com.mapgameserverapplication.lists;

import com.mapgameserverapplication.objects.Player;

import java.util.ArrayList;
import java.util.List;

public class Matches {
    private List<Player> seekers = new ArrayList<>();
    private List<Player> hiders = new ArrayList<>();

    public void matchPlayers(Player seeker, Player hider) {
        seekers.add(seeker);
        seekers.add(hider);
    }
}
