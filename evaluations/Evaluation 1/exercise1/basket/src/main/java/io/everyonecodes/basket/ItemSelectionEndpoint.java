package io.everyonecodes.basket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ItemSelectionEndpoint {

    // TODO: Injects the Basket bean.
    //  Mappings:
    //  POST an ItemSelection to “/itemselections”

    private final Basket basket;

    public ItemSelectionEndpoint(Basket basket) {
        this.basket = basket;
    }

    @PostMapping("/itemselections")
    ItemSelection post(@RequestBody ItemSelection itemSelection) {
        basket.transformItemSelection(itemSelection);
        return itemSelection;
    }
}
