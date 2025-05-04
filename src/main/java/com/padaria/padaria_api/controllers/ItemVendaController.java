package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.ItemVendaDTO;
import com.padaria.padaria_api.services.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-venda")
@CrossOrigin(origins = "*")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @GetMapping
    public List<ItemVendaDTO> listar() {
        return itemVendaService.listar();
    }

    @PostMapping
    public ItemVendaDTO salvar(@RequestBody ItemVendaDTO dto) {
        return itemVendaService.salvar(dto);
    }
}
