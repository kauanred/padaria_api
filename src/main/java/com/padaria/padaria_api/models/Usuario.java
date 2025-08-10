package com.padaria.padaria_api.models;

 @Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;
}
