package com.padaria.padaria_api.services;

import com.padaria.padaria_api.DTOs.ItemVendaDTO;
import com.padaria.padaria_api.models.ItemVenda;
import com.padaria.padaria_api.models.Produto;
import com.padaria.padaria_api.models.Venda;
import com.padaria.padaria_api.repositories.ItemVendaRepository;
import com.padaria.padaria_api.repositories.ProdutoRepository;
import com.padaria.padaria_api.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public List<ItemVendaDTO> listar() {
        return itemVendaRepository.findAll().stream().map(item -> {
            ItemVendaDTO dto = new ItemVendaDTO();
            dto.setId(item.getId());
            dto.setQuantidade(item.getQuantidade());
            dto.setPrecoUnitario(item.getPrecoUnitario());
            dto.setProdutoId(item.getProduto().getId());
            dto.setVendaId(item.getVenda().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public ItemVendaDTO salvar(ItemVendaDTO dto) {
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Venda venda = vendaRepository.findById(dto.getVendaId())
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        ItemVenda item = new ItemVenda(null, dto.getQuantidade(), dto.getPrecoUnitario(), produto, venda);
        item = itemVendaRepository.save(item);

        dto.setId(item.getId());
        return dto;
    }
}

