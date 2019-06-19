package com.example.meu_transporte_mobile.model;

import com.example.meu_transporte_mobile.utils.CnhCategory;
import com.example.meu_transporte_mobile.utils.Gender;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder
public class Driver {

    private Long idUser;
    private String userName;
    private String password;
    private String name;
    private String role = "ROLE_DRIVER";
    private String cnh;
    private String cpf;
    private String phone;
    private CnhCategory cnhCategory;
    private Gender gender;
    private String firstDateCnh;
    private String validityOfCnh;
    private String dateOfBirth;

//    public Driver(){
//        this.idUser = idUser;
//        this.userName = userName;
//        this.password = password;
//        this.name = name;
//        this.role = role;
//        this.cnh = cnh;
//        this.cpf = cpf;
//        this.phone = phone;
//        this.cnhCategory = cnhCategory;
//        this.gender = gender;
//        this.firstDateCnh = firstDateCnh;
//        this.validityOfCnh = validityOfCnh;
//        this.dateOfBirth = dateOfBirth;
//    }
}
