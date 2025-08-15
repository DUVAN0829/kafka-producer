package co.duvan.kafka.producer.controller;

import java.math.BigDecimal;

public class CreateProductRestModel {

    //* Vars
    private String tittle;
    private BigDecimal price;
    private Integer quantity;

    //* Getters and Setters
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
