package com.test.productlist.data.Dto;

import com.test.productlist.data.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Entity of product")
public class ProductDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @Schema(description = "Name of product", example = "Milk")
    private String name;
    @Schema(description = "Description", example = "The milk need for add to coffee and other drinks")
    private String description;
    @Schema(description = "KCal value", example = "1000")
    private int kcal;

    ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.kcal = product.getKcal();
    }
}
