package com.hktv.warehouse.warehouse.repository;

import com.hktv.warehouse.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
