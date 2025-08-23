package com.padaria.padaria_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;


@Data

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

//    @Enumerated(EnumType.STRING)
//    private UserEnum userEnum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 3, max = 50, message = "O nome deve ter ao menos 3 caracteres.")
    @Column(name = "nome", length = 200, nullable = true)
    private String nome;

    @NotBlank(message = "O email é obrigatorio!")
    @Column(name = "email" , length = 50, nullable = true)
    private String email;

    @NotBlank(message = "A senha é obrigatorio!")
    @Column(name = "senha" , columnDefinition = "TEXT", nullable = true)
    private String senha;

}
