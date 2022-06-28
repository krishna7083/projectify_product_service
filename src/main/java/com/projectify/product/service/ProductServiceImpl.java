package com.projectify.product.service;

import com.github.javafaker.Faker;
import com.projectify.product.dao.ProductDao;
import com.projectify.product.entity.Product;
import com.projectify.product.model.AddDummyProductResponse;
import com.projectify.product.model.AddProductResponse;
import com.projectify.product.model.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public AddDummyProductResponse addDummyProductResponse() {
        AddDummyProductResponse addDummyProductResponse = new AddDummyProductResponse();
        try {
            for(int i=0; i<5; i++) {
                Faker faker = new Faker();
                Product dummyProduct = new Product();
                dummyProduct.setProduct_tag(faker.code().asin());
                dummyProduct.setProduct_description(faker.app().name());
                dummyProduct.setProduct_price(faker.number().toString());
                dummyProduct.setProduct_image_link("https://play-lh.googleusercontent.com/G5oF0mhpOcQzFTrU6TDUL0JoAjzRt38weiZKua7L61WVT1z3dPcE9gUu-W2EwtM9cZU=w240-h480-rw");
                productDao.save(dummyProduct);
            }
            addDummyProductResponse.setError_code("00");
            addDummyProductResponse.setError_message("Dummy Product Added Successfully");
        } catch (Exception ex){
            addDummyProductResponse.setError_code("01");
            addDummyProductResponse.setError_message("Error in call");
        }
        return addDummyProductResponse;
    }

}
