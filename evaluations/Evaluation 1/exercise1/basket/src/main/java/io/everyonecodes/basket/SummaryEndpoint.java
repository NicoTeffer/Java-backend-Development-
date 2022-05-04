package io.everyonecodes.basket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SummaryEndpoint {

    // TODO:  Injects the Basket bean.
    //  Mappings:
    //  GET to “/summaries”

    private final Basket basket;

    public SummaryEndpoint(Basket basket) {
        this.basket = basket;
    }

    @GetMapping("/summaries")
    List<Summary> get(){
        return basket.getSummaries();
    }
}
