package com.microservice.product.service.Impl;

import com.microservice.product.Exception.ProductServiceCustomException;
import com.microservice.product.entity.Product;
import com.microservice.product.payload.ProductData;
import com.microservice.product.reopsitory.productRepository;
import com.microservice.product.service.productService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ProductServiceImpl implements productService {

     @Autowired
     private productRepository productRepository;

    private final ModelMapper modelMapper;

    public ProductServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public long addProduct(ProductData productData) {
        log.info("Adding a product to the database");

        Product product = modelMapper.map(productData, Product.class);
        productRepository.save(product);

        log.info("Product created");
        return product.getProductId();

    }

    @Override
    public ProductData getProductByID(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product not found with ID","NOT Found"));
        return modelMapper.map(product, ProductData.class);
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ProductServiceCustomException("Product by given Id not Found","PRODUCT_NOT_FOUND"));
        if (product.getQuantity()<quantity){
            throw new ProductServiceCustomException("Sorry Out of Stock","OUT_ OF_STOCK");
        }
        product.setQuantity(product.getQuantity()-quantity);{
            productRepository.save(product);
        }
    }
}

