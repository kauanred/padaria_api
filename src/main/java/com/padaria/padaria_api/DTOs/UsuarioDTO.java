package com.padaria.padaria_api.DTOs;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Getter
@Service
public class UsuarioDTO {
        private Integer id;
        private String nome;
        private String email;
        private String senha;
}
