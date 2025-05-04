package com.padaria.padaria_api.repositories;

import com.padaria.padaria_api.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

