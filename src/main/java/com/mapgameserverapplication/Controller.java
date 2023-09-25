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

}
