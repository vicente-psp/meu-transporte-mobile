package com.example.meu_transporte_mobile.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Client {

    private Long idClient;
    private String name;
    private String cnpj;
    private String socialName;
    @Builder
    public Client(){
        this.idClient = idClient;
        this.name = name;
        this.cnpj = cnpj;
        this.socialName = socialName;
    }
}
