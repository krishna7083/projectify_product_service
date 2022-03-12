package com.projectify.product.service;

import com.projectify.product.dao.ProductDao;
import com.projectify.product.entity.Product;
import com.projectify.product.model.AddProductResponse;
import com.projectify.product.model.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public AddProductResponse addProduct(Product product) {
        AddProductResponse addProductResponse = new AddProductResponse();
        try {
            productDao.save(product);
            addProductResponse.setError_code("00");
            addProductResponse.setError_message("Data added successfully");
        } catch (Exception ex) {
            addProductResponse.setError_code("01");
            addProductResponse.setError_message("Error in Call");
        }
        return addProductResponse;
    }

    @Override
    public GetProductResponse getProducts() {
        GetProductResponse getProductResponse = new GetProductResponse();
        List<Product> listofProducts = new ArrayList<>();
        try {
           listofProducts =  productDao.findAll();
           getProductResponse.setProductList(listofProducts);
           getProductResponse.setError_code("00");
           getProductResponse.setError_message("Retrieved list successfully");
        } catch (Exception ex){
            getProductResponse.setError_code("01");
            getProductResponse.setError_message("Error in Call");
        }
        return getProductResponse;
    }
}
