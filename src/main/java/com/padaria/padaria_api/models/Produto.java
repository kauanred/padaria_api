package com.padaria.padaria_api.models;

import com.padaria.padaria_api.enums.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatorio!")
    @Size(min = 2, max = 50, message = "O nome deve ter ao menos 2 caracteres.")
    @Column(name = "nome", length = 200, nullable = true)
    private String nome;
    
    
    @NotBlank(message = "O preço é obrigatorio!")
    private Double preco;

    private String descricao;

    
    @NotBlank(message = "Quantidade em estoque é obrigatorio!")
    private Long estoque;

//    @ManyToOne
//    @JoinColumn(name = "categoria_id")
//    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
}
