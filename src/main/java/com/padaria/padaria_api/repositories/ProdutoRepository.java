package com.padaria.padaria_api.repositories;


import com.padaria.padaria_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

