package com.example.meu_transporte_mobile.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Truck {
    private Long idTruck;
    private String model;
    private String manufacturer;
    private Date yearManufacturing;
    private String board;
    private Driver driver;
    @Builder
    public Truck(){
        this.idTruck = idTruck;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearManufacturing = yearManufacturing;
        this.board = board;
        this.driver = driver;
    }
}
