package com.padaria.padaria_api.services;


import com.padaria.padaria_api.DTOs.VendaDTO;
import com.padaria.padaria_api.models.Funcionario;
import com.padaria.padaria_api.models.Venda;
import com.padaria.padaria_api.repositories.FuncionarioRepository;
import com.padaria.padaria_api.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<VendaDTO> listar() {
        return vendaRepository.findAll().stream().map(v -> {
            VendaDTO dto = new VendaDTO();
            dto.setId(v.getId());
            dto.setDataHora(v.getDataHora());
            dto.setValorTotal(v.getValorTotal());
            dto.setFuncionarioId(v.getFuncionario().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public VendaDTO salvar(VendaDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Venda venda = new Venda(null, LocalDateTime.now(), dto.getValorTotal(), funcionario);
        venda = vendaRepository.save(venda);

        dto.setId(venda.getId());
        dto.setDataHora(venda.getDataHora());
        return dto;
    }
}
