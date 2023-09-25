package com.mapgameserverapplication.lists;

import com.mapgameserverapplication.objects.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Mapper {
    private Set<Player> unmatchedPlayers = new HashSet<>();
    private Matches matches = new Matches();

    Logger logger = LoggerFactory.getLogger(Mapper.class);

    public boolean checkMatch(Player player) {
        for(Player p : unmatchedPlayers) {
            logger.trace(p.getPassword() + " " + p.isSeeker());

            //Om spelare redan är i unmatchedPlayers och väntar på en annan spelare
            if(p.getPassword().equals(player.getPassword()) &&
            p.isSeeker() == player.isSeeker())
                return false;

            //Om det är matchning på password och de har olika roller
            if(p.getPassword().equals(player.getPassword()) &&
            p.isSeeker() != player.isSeeker()) {
                unmatchedPlayers.remove(p);
                matches.matchPlayers(p, player);
                return true;
            }
        }
        unmatchedPlayers.add(player);
        return false;
    }

    public void clearAll() {
        unmatchedPlayers.clear();
        matches.clear();
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "unmatchedPlayers=" + unmatchedPlayers +
                ", matches=" + matches +
                '}';
    }
}
