package com.padaria.padaria_api.services;


import com.padaria.padaria_api.models.Produto;
import com.padaria.padaria_api.repositories.ProdutoRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }

    public Produto criarProduto(Produto produto) {
        Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;
    }

    public Produto editarProduto(Produto produto) {
        Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;
    }

    public Boolean excluirProduto(Long id) {
        produtoRepository.deleteById(id);
        return true;
    }
}
