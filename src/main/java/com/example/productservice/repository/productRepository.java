package com.example.productservice.repository;

import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface productRepository extends JpaRepository<Product, UUID> {
}
