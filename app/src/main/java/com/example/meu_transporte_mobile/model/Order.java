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
    private Client nameClient;
    private String startAddress;
    private String endAddress;
    private Route idRoute;
	private OrderDetails orderDetails;
	@Builder
    public Order(){
	    this.idOrder = idOrder;
	    this.value = value;
	    this.idClient = idClient;
	    this.nameClient = nameClient;
	    this.startAddress = startAddress;
	    this.endAddress = endAddress;
	    this.idRoute = idRoute;
	    this.orderDetails = orderDetails;
    }
}
