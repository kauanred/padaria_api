package com.padaria.padaria_api.services;

import com.padaria.padaria_api.models.Produto;
import com.padaria.padaria_api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // LISTAR TODOS OS PRODUTOS
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // CRIAR PRODUTO
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // EDITAR
    public Produto editarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setDescricao(produtoAtualizado.getDescricao());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    produtoExistente.setEstoque(produtoAtualizado.getEstoque());
                    produtoExistente.setCategoria(produtoAtualizado.getCategoria());
                    return produtoRepository.save(produtoExistente);
                }).orElse(null); // retorna null se não existir
    }

    // DELETAR
    public boolean excluirProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
