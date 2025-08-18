package co.duvan.kafka.producer.controller;

import co.duvan.kafka.producer.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/products")
public class ProductController {

    //* Vars
    private final ProductService service;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //* Constructor
    public ProductController(ProductService service) {
        this.service = service;
    }

    //* Methods
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRestModel product) {

        String productId = "";

        try {
            productId = service.createProduct(product);
        } catch (Exception e) {

            LOGGER.info(e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(new Date(), e.getMessage(), "/products"));

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);

    }



}
