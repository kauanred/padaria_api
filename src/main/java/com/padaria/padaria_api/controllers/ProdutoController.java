package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.ProdutoDTO;
import com.padaria.padaria_api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public ProdutoDTO salvar(@RequestBody ProdutoDTO dto) {
        return service.salvar(dto);
    }
}
