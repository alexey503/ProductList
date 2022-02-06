package com.test.productlist.data.repository;

import com.test.productlist.data.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductListRepository extends JpaRepository <ProductList, Long> {
    Optional<ProductList>getById(long id);
    Optional<ProductList>findByName(String name);

}
