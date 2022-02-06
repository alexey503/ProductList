package com.test.productlist.data.Dto;

import com.test.productlist.data.entity.Product;
import com.test.productlist.data.entity.ProductList;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Schema(description = "Entity of list")
public class ProductListDto {
    private long id;
    @Schema(description = "Name of list", example = "List of products for shopping")
    private String name;

    @Schema(description = "List of products in this product list")
    private List<ProductDto> products;

    private int totalKcal;

    public ProductListDto(ProductList list) {
        this.id = list.getId();
        this.name = list.getName();
        this.products = list.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
        this.totalKcal = list.getProducts().stream().mapToInt(Product::getKcal).reduce(0, Integer::sum);
    }
}
