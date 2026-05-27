package com.example.vetclinic.model.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String bairro;
    private String cidade;
    private String cep;
    private String rua;
    private String numero;
}
