package com.test.productlist.service;

import com.test.productlist.data.Dto.ProductDto;
import com.test.productlist.data.entity.ProductList;
import com.test.productlist.data.entity.Product;
import com.test.productlist.data.repository.ProductListRepository;
import com.test.productlist.data.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductListService {
    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;

    public void createList(String name){

        ProductList newList = new ProductList();
        newList.setName(name);

        productListRepository.save(newList);

    }

    public long createProduct(String name, String description, int kcal){
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setKcal(kcal);
        productRepository.save(newProduct);
        return newProduct.getId();
    }

    public boolean addProductToList(long productId, long listId){
        System.out.println(11);
        Optional<ProductList> list = productListRepository.getById(listId);
        System.out.println(22);
        if(list.isEmpty()){
            return false;
        }

        Optional<Product> optionalProduct = productRepository.getById(productId);
        if (optionalProduct.isEmpty()) {
            return false;
        }

        Product product = optionalProduct.get();
        product.setProductList(list.get());
        productRepository.save(product);
        return true;
    }

    public ProductList getListWithProducts(long id){
        Optional<ProductList> list = productListRepository.getById(id);
        if(list.isPresent()) {
            return list.get();
        }else{
            return null;
        }
    }

    public void createProduct(ProductDto productDto) {
        Product newProduct = new Product(productDto);
        productRepository.save(newProduct);
    }
}
