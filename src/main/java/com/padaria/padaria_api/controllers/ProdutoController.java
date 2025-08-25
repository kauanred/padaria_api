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
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtosService;

    public ProdutoController(ProdutoService produtosService) {
        this.produtosService = produtosService;
    }


    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.status(200).body(produtosService.listarProdutos());
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produtos) {
        return ResponseEntity.status(201).body(produtosService.criarProduto(produtos));
    }

    @PutMapping
    public ResponseEntity<Produto> editarProduto(@RequestBody Produto produtos) {
        return ResponseEntity.status(200).body(produtosService.editarProduto(produtos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        produtosService.excluirProduto(id);
        return ResponseEntity.status(204).build();
    }
}
