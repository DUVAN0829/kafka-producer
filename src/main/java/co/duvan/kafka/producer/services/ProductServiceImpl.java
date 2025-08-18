package co.duvan.kafka.producer.services;

import co.duvan.kafka.producer.controller.CreateProductRestModel;
import co.duvan.kafka.producer.events.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    //* Vars
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //* Constructor
    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //* Methods
    @Override
    public String createProduct(CreateProductRestModel productRestModel) {

        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productRestModel.getTittle(), productRestModel.getPrice(), productRestModel.getQuantity());

        CompletableFuture<SendResult<String, ProductCreatedEvent>> completableFuture = kafkaTemplate.send("product-created-events-topic", productId, productCreatedEvent);

        completableFuture.whenComplete((result, exception) -> {

            if(exception != null) {
                logger.error("***** Failed to send message {}", exception.getMessage());
            } else {
                logger.info("***** Message sent successfully {}", result.getRecordMetadata());
            }

        });

        logger.info("***** Returning product id");

        return productId;
    }

}
