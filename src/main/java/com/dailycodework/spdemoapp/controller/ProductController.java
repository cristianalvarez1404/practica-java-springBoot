package com.dailycodework.spdemoapp.controller;

import com.dailycodework.spdemoapp.model.Product;
import com.dailycodework.spdemoapp.service.IProductService;
import com.dailycodework.spdemoapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}/products")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product,@RequestParam Long id){
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteProduct(@PathVariable  Long id){
        productService.deleteProduct(id);
    }

}
