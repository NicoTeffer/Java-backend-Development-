package io.everyonecodes.steam_purchases;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GameUserEndpoint {

    private final PurchaseService purchaseService;

    public GameUserEndpoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    List<GameUser> getAllGameUsers(){
       return purchaseService.getAllGameUsers();
    }
}
