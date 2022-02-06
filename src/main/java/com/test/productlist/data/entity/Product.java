package com.test.productlist.data.entity;

import com.test.productlist.data.Dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int kcal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_list")
    private ProductList productList;

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.kcal = productDto.getKcal();
    }
}
