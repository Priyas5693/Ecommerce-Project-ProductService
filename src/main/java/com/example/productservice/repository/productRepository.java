package com.example.productservice.repository;

import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface productRepository extends JpaRepository<Product, UUID> {
}
