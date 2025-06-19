package com.dailycodework.spdemoapp.repository;

import com.dailycodework.spdemoapp.model.Product;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository {
    List<Product> products = Arrays.asList(
            new Product(1L,"Samsung",100,"Some smart phones"),
            new Product(2L,"iPhone",500,"Some smart phones"),
            new Product(3L,"Sneakers",150,"Some smart shoes"),
            new Product(4L,"Dell",200,"Some smart laptops"),
            new Product(5L,"HP",100,"Some laptop")
    );
}
