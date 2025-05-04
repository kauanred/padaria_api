package com.padaria.padaria_api.repositories;

import com.padaria.padaria_api.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

