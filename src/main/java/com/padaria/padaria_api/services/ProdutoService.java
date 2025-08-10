package com.padaria.padaria_api.services;


import com.padaria.padaria_api.DTOs.ProdutoDTO;
import com.padaria.padaria_api.models.Categoria;
import com.padaria.padaria_api.models.Produto;
import com.padaria.padaria_api.repositories.CategoriaRepository;
import com.padaria.padaria_api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProdutoDTO> listar() {
        return produtoRepository.findAll().stream().map(p -> {
            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(p.getId());
            dto.setNome(p.getNome());
            dto.setPreco(p.getPreco());
            dto.setEstoque(p.getEstoque());
            dto.setCategoriaId(p.getCategoria().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = new Produto(null, dto.getNome(), dto.getPreco(), dto.getEstoque(), categoria);
        produto = produtoRepository.save(produto);

        dto.setId(produto.getId());
        return dto;
    }

    public void atualizar(Long id, Produto produto) {
    ProdutoDTO dto = new ProdutoDTO();
    dto.setId(id);
    dto.setNome(produto.getNome());
    dto.setPreco(produto.getPreco());
    dto.setEstoque(produto.getEstoque());
    dto.setCategoriaId(produto.getCategoria().getId());
    salvar(dto);
}

    public void excluir(Long id) {
}
}
