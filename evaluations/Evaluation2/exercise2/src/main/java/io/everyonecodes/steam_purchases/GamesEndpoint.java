package io.everyonecodes.steam_purchases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GamesEndpoint {

    private final PurchaseService purchaseService;

    public GamesEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // TODO: GET to “/games” -> returns all Game entries [available for everyone]

    @GetMapping("/games")
    List<Game> getAllGames(){
        return purchaseService.getAllGames();
    }
}
