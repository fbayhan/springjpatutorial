package com.springdata.tarik.repository;

import com.springdata.tarik.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
