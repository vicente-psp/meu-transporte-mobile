package com.example.meu_transporte_mobile.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Address {
    private Long idAddress;
    private String cep;
    private String description;
    private String number;
    private String lat;
    private String longitude;
    @Builder
    public Address(){
        this.idAddress = idAddress;
        this.cep = cep;
        this.description = description;
        this.number = number;
        this.lat = lat;
        this.longitude = longitude;
    }
}
