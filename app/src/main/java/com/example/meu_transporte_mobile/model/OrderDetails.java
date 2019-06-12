package com.example.meu_transporte_mobile.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrderDetails {
    private long idOrderDetails;
    private Product idProduct;
    private Order idOrder;
    private int quantity;
    @Builder
    public OrderDetails(){
        this.idOrderDetails = idOrderDetails;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
    }
}
