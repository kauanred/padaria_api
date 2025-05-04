package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.VendaDTO;
import com.padaria.padaria_api.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<VendaDTO> listar() {
        return vendaService.listar();
    }

    @PostMapping
    public VendaDTO salvar(@RequestBody VendaDTO dto) {
        return vendaService.salvar(dto);
    }
}
