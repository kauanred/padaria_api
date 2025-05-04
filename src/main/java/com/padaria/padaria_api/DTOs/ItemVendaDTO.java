package com.padaria.padaria_api.DTOs;

import lombok.Data;

@Data
public class ItemVendaDTO {
    private Long id;
    private Integer quantidade;
    private Double precoUnitario;
    private Long produtoId;
    private Long vendaId;
}
