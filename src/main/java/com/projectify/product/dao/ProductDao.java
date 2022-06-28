package com.projectify.product.dao;

import com.projectify.product.entity.Product;
import com.projectify.product.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

}
