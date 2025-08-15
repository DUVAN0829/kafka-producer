package co.duvan.kafka.producer.events;

import java.math.BigDecimal;

public class ProductCreatedEvent {

    //* Vars
    private String productId;
    private String tittle;
    private BigDecimal price;
    private Integer quantity;

    //* Constructor
    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String tittle, BigDecimal price, Integer quantity) {
        this.tittle = tittle;
        this.price = price;
        this.quantity = quantity;
    }

    //* Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
