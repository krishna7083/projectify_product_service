package com.projectify.product.service;
import com.projectify.product.entity.Product;
import com.projectify.product.model.AddProductResponse;
import com.projectify.product.model.GetProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public AddProductResponse addProduct(Product product);
    public GetProductResponse getProducts();
}
