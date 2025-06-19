package com.dailycodework.spdemoapp.service;

import com.dailycodework.spdemoapp.model.Product;
import com.dailycodework.spdemoapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {


    public List<Product> getProducts(){
        return ProductRepository.products;
    }
}
