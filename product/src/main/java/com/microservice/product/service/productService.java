package com.microservice.product.service;

import com.microservice.product.payload.ProductData;

public interface productService {


    long addProduct(ProductData productData);

    ProductData getProductByID(Long productId);


    void reduceQuantity(long productId, long quantity);
}
