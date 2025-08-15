package co.duvan.kafka.producer.services;

import co.duvan.kafka.producer.controller.CreateProductRestModel;

public interface ProductService {

    String createProduct(CreateProductRestModel productRestModel);

}
