package com.example.productservice.repository;

import com.example.productservice.Models.Category;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface categoryRepository extends JpaRepository<Category, UUID> {

}
