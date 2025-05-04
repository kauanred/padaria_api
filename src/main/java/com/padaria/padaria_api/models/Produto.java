package com.padaria.padaria_api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
