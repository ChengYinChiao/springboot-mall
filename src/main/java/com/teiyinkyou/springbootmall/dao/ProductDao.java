package com.teiyinkyou.springbootmall.dao;

import com.teiyinkyou.springbootmall.dto.ProductQueryParams;
import com.teiyinkyou.springbootmall.dto.ProductRequest;
import com.teiyinkyou.springbootmall.model.Product;

import java.util.List;

//CRUD方法
public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
