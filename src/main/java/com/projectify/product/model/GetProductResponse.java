package com.projectify.product.model;

import com.projectify.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class GetProductResponse extends Response {
    private List<Product> productList;
}
