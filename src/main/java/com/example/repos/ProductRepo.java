package com.example.repos;

import com.example.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
