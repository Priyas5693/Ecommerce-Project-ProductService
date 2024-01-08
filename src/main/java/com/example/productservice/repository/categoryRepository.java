package com.example.productservice.repository;

import com.example.productservice.Models.Category;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface categoryRepository extends JpaRepository<Category, UUID> {

}
