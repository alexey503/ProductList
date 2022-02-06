package com.test.productlist.data.repository;

import com.test.productlist.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product>getById(long id);
    Optional<Product>findByName(String name);

}
