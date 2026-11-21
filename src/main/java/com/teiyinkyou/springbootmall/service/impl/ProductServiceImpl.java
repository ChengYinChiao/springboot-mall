package com.teiyinkyou.springbootmall.service.impl;

import com.teiyinkyou.springbootmall.dao.ProductDao;
import com.teiyinkyou.springbootmall.dto.ProductRequest;
import com.teiyinkyou.springbootmall.model.Product;
import com.teiyinkyou.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    //Service層實作只要直接去call ProductDao的getProductById
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
}
