package com.projectify.product.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_key;
    private String product_tag;
    private String product_description;
    private String product_image_link;
    private String product_price;

    public Long getProduct_key() {
        return product_key;
    }

    public void setProduct_key(Long product_key) {
        this.product_key = product_key;
    }

    public String getProduct_tag() {
        return product_tag;
    }

    public void setProduct_tag(String product_tag) {
        this.product_tag = product_tag;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_image_link() {
        return product_image_link;
    }

    public void setProduct_image_link(String product_image_link) {
        this.product_image_link = product_image_link;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_key='" + product_key + '\'' +
                ", product_tag='" + product_tag + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_image_link='" + product_image_link + '\'' +
                ", product_price='" + product_price + '\'' +
                '}';
    }
}
