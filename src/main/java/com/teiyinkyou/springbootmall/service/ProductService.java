package com.teiyinkyou.springbootmall.service;

import com.teiyinkyou.springbootmall.dto.ProductRequest;
import com.teiyinkyou.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
