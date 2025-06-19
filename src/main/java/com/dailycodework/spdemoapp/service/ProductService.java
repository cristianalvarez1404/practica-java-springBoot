package com.dailycodework.spdemoapp.service;

import com.dailycodework.spdemoapp.model.Product;
import com.dailycodework.spdemoapp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService implements  IProductService{
    private final ProductRepository productRepository;

    private final List<Product> products = Arrays.asList(
            new Product(1L,"Samsung",100,"Some smart phones"),
            new Product(2L,"iPhone",500,"Some smart phones"),
            new Product(3L,"Sneakers",150,"Some smart shoes"),
            new Product(4L,"Dell",200,"Some smart laptops"),
            new Product(5L,"HP",100,"Some laptop")
    );

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return productRepository.findById(id)
                .map(oldProduct -> {
                    oldProduct.setName(product.getName());
                    oldProduct.setDescription(product.getDescription());
                    oldProduct.setPrice(product.getPrice());
                    return productRepository.save(oldProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void deleteProduct(Long productId) {
        if(productRepository.findById(productId).isPresent()){
            productRepository.deleteById(productId);
        }
    }

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /*@PostConstruct
    public List<Product> saveProducts(){
        return productRepository.saveAll(products);
    }*/
}
