package io.everyonecodes.small_business;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByType(String type);

    List<Product> findByTypeIsNot(String type);
}
