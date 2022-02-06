package com.test.productlist.controller;

import com.test.productlist.data.Dto.ProductDto;
import com.test.productlist.data.Dto.ProductListDto;
import com.test.productlist.data.entity.ProductList;
import com.test.productlist.service.ProductListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name="Product list controller", description="Process all base operations")
public class ProductListController {

    private final ProductListService service;

    @PostMapping("/list")
    @Operation(
            summary = "Create list",
            description = "Create new list in base"
    )
    public void createList(
            @RequestParam
            @Parameter(description = "Name of new list")
                    String name
    ) {
        service.createList(name);
    }

    @PostMapping("/product")
    @Operation(
            summary = "Create product",
            description = "Create new product in base"
    )
    public void createProduct(
            @RequestBody
            @Parameter(description = "Params of product(name, description, kcal)")
                    ProductDto productDto) {
        service.createProduct(productDto);
    }

    @GetMapping("/{listId}")
    @Operation(
            summary = "Get list",
            description = "Get list by identifier in base"
    )
    public ResponseEntity<ProductListDto> getListById(
            @PathVariable
            @Parameter(description = "Identifier of require list")
                    Long listId
    ) {
        ProductList list = service.getListWithProducts(listId);
        if (list == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ProductListDto(list));
    }

    @PutMapping("/tolist")
    @Operation(
            summary = "Set product to list",
            description = "Set exist product to exist list"
    )
    public void addProductToList(
            @RequestParam
            @Parameter(description = "Identifier of product for add to list")
                    long productId,
            @Parameter(description = "Identifier of list")
            long listId) {
        service.addProductToList(productId, listId);
    }
}
