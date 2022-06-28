package com.projectify.product.controller;

import com.projectify.product.entity.Product;
import com.projectify.product.model.AddDummyProductResponse;
import com.projectify.product.model.AddProductResponse;
import com.projectify.product.model.GetProductResponse;
import com.projectify.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        AddProductResponse addProductResponse = productService.addProduct(product);
        return new ResponseEntity<Object>(addProductResponse,HttpStatus.OK);
    }

    @GetMapping("/getproducts")
    public ResponseEntity<Object> getProducts(){
        GetProductResponse getProductResponse = productService.getProducts();
        return new ResponseEntity<Object>(getProductResponse,HttpStatus.OK);
    }

    @GetMapping("/adddummyproducts")
    public ResponseEntity<Object> addDummyProducts(){
        AddDummyProductResponse addDummyProductResponse = productService.addDummyProductResponse();
        return new ResponseEntity<Object>(addDummyProductResponse,HttpStatus.OK);
    }

}
