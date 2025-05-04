package com.padaria.padaria_api.repositories;

import com.padaria.padaria_api.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
