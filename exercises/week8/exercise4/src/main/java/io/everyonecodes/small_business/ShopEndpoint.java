package io.everyonecodes.small_business;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopEndpoint {

    private final ShopService shopService;

    public ShopEndpoint(ShopService shopService) {
        this.shopService = shopService;
    }

    @PutMapping("/open")
    void open() {
        shopService.open();
    }

    @PutMapping("/open")
    void close() {
        shopService.close();
    }


}
