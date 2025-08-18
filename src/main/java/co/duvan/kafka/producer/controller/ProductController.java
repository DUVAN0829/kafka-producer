package co.duvan.kafka.producer.controller;

import co.duvan.kafka.producer.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    //* Vars
    private final ProductService service;

    //* Constructor
    public ProductController(ProductService service) {
        this.service = service;
    }

    //* Methods
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRestModel product) {

        String productId = null;
        try {
            productId = service.createProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }



}
