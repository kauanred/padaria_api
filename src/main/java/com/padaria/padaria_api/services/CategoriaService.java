package com.padaria.padaria_api.services;


import com.padaria.padaria_api.DTOs.CategoriaDTO;
import com.padaria.padaria_api.models.Categoria;
import com.padaria.padaria_api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaDTO> listar() {
        return repository.findAll().stream().map(c -> {
            CategoriaDTO dto = new CategoriaDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            return dto;
        }).collect(Collectors.toList());
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        Categoria categoria = new Categoria(null, dto.getNome());
        categoria = repository.save(categoria);
        dto.setId(categoria.getId());
        return dto;
    }
}
