package io.everyonecodes.small_business;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getNonPremium() {
        return productService.findNonPremium();
    }

    @GetMapping("/premium")
    List<Product> getPremium() {
        return productService.findPremium();
    }

    @PostMapping
    Product post(@RequestBody Product product) {
        return productService.save(product);
    }
}
