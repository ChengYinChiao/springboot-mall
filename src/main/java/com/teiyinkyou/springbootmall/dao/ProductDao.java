package com.teiyinkyou.springbootmall.dao;

import com.teiyinkyou.springbootmall.model.Product;

//CRUD方法
public interface ProductDao {

    Product getProductById(Integer productId);

}
