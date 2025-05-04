package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.FuncionarioDTO;
import com.padaria.padaria_api.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public FuncionarioDTO salvar(@RequestBody FuncionarioDTO dto) {
        return service.salvar(dto);
    }
}
