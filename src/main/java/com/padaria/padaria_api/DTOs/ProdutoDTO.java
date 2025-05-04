package com.padaria.padaria_api.DTOs;

import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private Integer estoque;
    private Long categoriaId;
}
