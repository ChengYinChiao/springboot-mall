package com.teiyinkyou.springbootmall.controller;

import com.teiyinkyou.springbootmall.dto.ProductRequest;
import com.teiyinkyou.springbootmall.model.Product;
import com.teiyinkyou.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            //return ResponseEntity.ok(product);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //@RequestBody:接住前端傳過來的json參數
    //一定要記得加上@Valid註解進去，不然@NotNull不會生效
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        //返回資料庫生成的productId
        Integer productId = productService.createProduct(productRequest);

        //使用返回的productId去查詢新增商品的數據回來
        Product product = productService.getProductById(productId);

        //最後回傳一個ResponseEntity給前端，返回值http狀態碼為 201 Created，表示有一筆數據被創建出來
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    //@PathVariable:從Path取得值
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        Product product = productService.getProductById(productId);

        //檢查 product 是否存在
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品數據
        productService.updateProduct(productId, productRequest);

        //從資料庫取得更新過後的商品數據
        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);

        //只要確定商品不存在，就表示刪除商品功能是成功的
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
