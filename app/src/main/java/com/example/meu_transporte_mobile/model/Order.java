package com.example.meu_transporte_mobile.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Order {
    private Long idOrder;
    private double value;
    private Client idClient;
    private Route idRoute;
	private OrderDetails orderDetails;
	@Builder
    public Order(){
	    this.idOrder = idOrder;
	    this.value = value;
	    this.idClient = idClient;
	    this.idRoute = idRoute;
	    this.orderDetails = orderDetails;
    }
}
