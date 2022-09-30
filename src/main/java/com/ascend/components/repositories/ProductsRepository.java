package com.ascend.components.repositories;

import com.ascend.components.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String>, QueryByExampleExecutor<Products> {
}
