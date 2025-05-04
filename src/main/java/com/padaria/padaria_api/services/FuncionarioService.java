package com.padaria.padaria_api.services;


import com.padaria.padaria_api.DTOs.FuncionarioDTO;
import com.padaria.padaria_api.models.Funcionario;
import com.padaria.padaria_api.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioDTO> listar() {
        return repository.findAll().stream().map(f -> {
            FuncionarioDTO dto = new FuncionarioDTO();
            dto.setId(f.getId());
            dto.setNome(f.getNome());
            dto.setCpf(f.getCpf());
            dto.setCargo(f.getCargo());
            dto.setSalario(f.getSalario());
            return dto;
        }).collect(Collectors.toList());
    }

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getCpf(), dto.getCargo(), dto.getSalario());
        funcionario = repository.save(funcionario);
        dto.setId(funcionario.getId());
        return dto;
    }
}
