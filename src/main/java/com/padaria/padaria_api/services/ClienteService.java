package com.padaria.padaria_api.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.padaria.padaria_api.DTOs.ClienteDTO;
import com.padaria.padaria_api.models.Cliente;
import com.padaria.padaria_api.repositories.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente(null, dto.getNome(), dto.getCpf(), dto.getTelefone());
        cliente = clienteRepository.save(cliente);
        dto.setId(cliente.getId());
        return dto;
    }

    public List<ClienteDTO> listar() {
        return clienteRepository.findAll().stream().map(c -> {
            ClienteDTO dto = new ClienteDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setCpf(c.getCpf());
            dto.setTelefone(c.getTelefone());
            return dto;
        }).collect(Collectors.toList());
    }
}
