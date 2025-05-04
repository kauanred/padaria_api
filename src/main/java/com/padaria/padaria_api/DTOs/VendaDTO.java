package com.padaria.padaria_api.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VendaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private Double valorTotal;
    private Long funcionarioId;
}
