package com.microservice.product.controller;
import com.microservice.product.entity.Product;
import com.microservice.product.payload.ProductData;
import com.microservice.product.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
  private productService productService;



@PostMapping ("/created")
public ResponseEntity<Long>addProduct(@RequestBody ProductData productData){
    long productId= productService.addProduct(productData);

    return new ResponseEntity<>(productId,HttpStatus.CREATED);

    //http://localhost:8080/product
}
@GetMapping("/{Id}")
public ResponseEntity<ProductData> getProductById(@PathVariable ("Id")Long productId){
  ProductData productData=productService.getProductByID(productId);
    return new ResponseEntity<>(productData,HttpStatus.OK);
    //http://localhost:8080/product/1
}

  @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void>reduceQuantity(@PathVariable ("id") long productId,@RequestParam long quantity){
            productService.reduceQuantity(productId,quantity);
      return new ResponseEntity<>(HttpStatus.OK);
      // http://localhost:8080/product/reduceQuantity/1?quantity=10
  }

}
