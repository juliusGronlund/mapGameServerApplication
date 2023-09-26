package com.mapgameserverapplication;

import com.mapgameserverapplication.lists.Mapper;
import com.mapgameserverapplication.objects.LatLngLocation;
import com.mapgameserverapplication.objects.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Mapper mapper = new Mapper();

    //Kanske skicka med ett avsändar-id också för att förhindra då flera använder samma läsenord samtidigt. Detta anrop borde nog kolla fler saker. Som om den andra spelaren har lämnat osv
    @GetMapping("/hasConnection")
    public boolean hasConnection(@RequestParam String password, @RequestParam boolean seeker) {
        Player player = new Player(password, seeker);
        return mapper.checkMatch(player);
    }

    @GetMapping("/quitGame")
    public boolean quitGame(@RequestParam String password) { //Kanske också roll och id i framtiden för att undvika att yttre personer avslutar
        return mapper.quitGame(password);
    }

    @GetMapping("/getLastKnownLocation")
    public String getLastKnownLocation(@RequestParam String password, @RequestParam boolean seeker) { //return latitude + ":" + longitude;
        Player player = new Player(password, seeker);
        LatLngLocation latLngLocation = mapper.getLastKnownLocation(player);
        String locationInString = latLngLocation.toReturnString();
        return locationInString;
    }

    @GetMapping("/setLastKnownLocation")
    public boolean setLastKnownLocation(@RequestParam String password, @RequestParam boolean seeker, @RequestParam double latitude, @RequestParam double longitude) {
        Player player = new Player(password, seeker);
        LatLngLocation latLngLocation = new LatLngLocation(latitude, longitude);
        return mapper.setLastKnownLocation(player, latLngLocation);
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
