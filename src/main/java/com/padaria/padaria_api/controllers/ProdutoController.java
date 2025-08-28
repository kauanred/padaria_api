package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.ProdutoDTO;
import com.padaria.padaria_api.models.Produto;
import com.padaria.padaria_api.services.ProdutoService;
import com.padaria.padaria_api.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtosService;

    public ProdutoController(ProdutoService produtosService) {
        this.produtosService = produtosService;
    }

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.status(200).body(produtosService.listarProdutos());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
        return produtosService.listarProdutos().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    // CRIAR PRODUTO
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto criado = produtosService.criarProduto(produto);
        return ResponseEntity.status(201).body(criado);
    }

    // ATUALIZAR PRODUTO
    @PutMapping("/{id}")
    public ResponseEntity<Produto> editarProduto(@PathVariable Long id,
                                                 @RequestBody Produto produtoAtualizado) {
        Produto atualizado = produtosService.editarProduto(id, produtoAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETAR PRODUTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtosService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
