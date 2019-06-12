package com.example.meu_transporte_mobile.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Route {
    private Long idRoute;
    private Truck idTruck;
    private List<Order> orders;
    private Driver idDriver;
    @Builder
    public Route(){
        this.idRoute = idRoute;
        this.idTruck = idTruck;
        this.orders = orders;
        this.idDriver = idDriver;
    }
}
