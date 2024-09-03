package com.ODanielFilho.product_api.repository;

import com.ODanielFilho.product_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
