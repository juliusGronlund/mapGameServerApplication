package com.mapgameserverapplication;

import com.mapgameserverapplication.lists.Mapper;
import com.mapgameserverapplication.objects.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Mapper mapper = new Mapper();

    //Kanske skicka med ett avsändar-id också för att förhindra då flera använder samma läsenord samtidigt
    @GetMapping("/hasConnection")
    public boolean hasConnection (@RequestParam String password, @RequestParam Boolean seeker) {
        Player player = new Player(password, seeker);
        return mapper.checkMatch(player);
    }

    //Endpoint för att rensa alla spelare och matcher
    @GetMapping("/clearAll")
    public boolean clearAll(@RequestParam String myPassword) {
        if(myPassword.equals("snorlaxenclear")) {
            mapper.clearAll();
            return true;
        }
        return false;
    }

    @GetMapping("/getServerInfo")
    public String getServerInfo() {
        return mapper.toString();
    }

}
