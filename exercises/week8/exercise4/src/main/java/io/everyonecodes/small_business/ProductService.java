package io.everyonecodes.small_business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductService {

    private final ShopService shopService;

    private final ProductRepository productRepository;

    private final String premium;

    public ProductService(ShopService shopService, ProductRepository productRepository,
                          @Value("${small-business.product.type}") String premium) {
        this.shopService = shopService;
        this.productRepository = productRepository;
        this.premium = premium;
    }

    public List<Product> findNonPremium() {
        return performIfOpen(() -> productRepository.findByTypeIsNot(premium));
    }

    public List<Product> findPremium() {
        return performIfOpen(() -> productRepository.findByType(premium));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    private List<Product> performIfOpen(Supplier<List<Product>> supplier) {
        if (shopService.isOpen()) {
            return supplier.get();
        }
        return List.of();
    }
}
