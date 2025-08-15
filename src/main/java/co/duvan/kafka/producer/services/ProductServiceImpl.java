package co.duvan.kafka.producer.services;

import co.duvan.kafka.producer.controller.CreateProductRestModel;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {
        return "";
    }

}
