package io.everyonecodes.flea_market;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class FleaMarketEndpoint {

    private final List<Item> items;

    public FleaMarketEndpoint(List<Item> items) {
        this.items = items;
    }

    @GetMapping
    List<Item> getItems() {
        return items;
    }

    @PostMapping("/{item}")
    Item post(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @GetMapping("/{name}")
    List<Item> getSpecificItem(@PathVariable String name) {
        return items.stream().filter(x -> x.getName().equalsIgnoreCase(name)).toList();
    }
}
