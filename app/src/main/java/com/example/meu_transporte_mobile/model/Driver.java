package com.example.meu_transporte_mobile.model;

import com.example.meu_transporte_mobile.utils.CnhCategory;
import com.example.meu_transporte_mobile.utils.Gender;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Driver {

    private Long idDriver;
    private String name;
    private String cnh;
    private String cpf;
    private CnhCategory cnhCategory;
    private Gender gender;
    private Route route;
    private Truck truck;
    private Date firstDateCnh;
    @Builder
    public Driver(){
        this.idDriver = idDriver;
        this.name = name;
        this.cnh = cnh;
        this.cpf = cpf;
        this.cnhCategory = cnhCategory;
        this.gender = gender;
        this.route = route;
        this.truck = truck;
        this.firstDateCnh = firstDateCnh;
    }
}
