package com.padaria.padaria_api.DTOs;

import lombok.Data;

@Data
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String cargo;
    private Double salario;
}

