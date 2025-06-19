package com.dailycodework.spdemoapp.repository;

import com.dailycodework.spdemoapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {}
