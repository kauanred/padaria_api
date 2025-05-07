package com.padaria.padaria_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.padaria.padaria_api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
