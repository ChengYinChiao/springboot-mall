package com.teiyinkyou.springbootmall.service.impl;

import com.teiyinkyou.springbootmall.dao.ProductDao;
import com.teiyinkyou.springbootmall.dto.ProductQueryParams;
import com.teiyinkyou.springbootmall.dto.ProductRequest;
import com.teiyinkyou.springbootmall.model.Product;
import com.teiyinkyou.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

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

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
