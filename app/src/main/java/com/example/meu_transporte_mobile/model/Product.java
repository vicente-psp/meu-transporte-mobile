package com.example.meu_transporte_mobile.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Product {
    private Long idProduct;
    private String description;
    private Double value;
    private Order idOrder;
    private OrderDetails orderDetails;
    @Builder
    public Product(){
        this.idProduct = idProduct;
        this.description = description;
        this.value = value;
        this.idOrder = idOrder;
        this.orderDetails = orderDetails;
    }
}
