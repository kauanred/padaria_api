package com.padaria.padaria_api.repositories;

import com.padaria.padaria_api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
