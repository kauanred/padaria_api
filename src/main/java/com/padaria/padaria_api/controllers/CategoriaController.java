package com.padaria.padaria_api.controllers;


import com.padaria.padaria_api.DTOs.CategoriaDTO;
import com.padaria.padaria_api.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public CategoriaDTO salvar(@RequestBody CategoriaDTO dto) {
        return service.salvar(dto);
    }
}

