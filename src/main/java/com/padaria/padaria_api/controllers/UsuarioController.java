package com.padaria.padaria_api.controllers;

import com.padaria.padaria_api.DTOs.CategoriaDTO;
import com.padaria.padaria_api.DTOs.ProdutoDTO;
import com.padaria.padaria_api.DTOs.UsuarioDTO;
import com.padaria.padaria_api.models.Usuario;
import com.padaria.padaria_api.repositories.UsuarioRepository;
import com.padaria.padaria_api.services.ProdutoService;
import com.padaria.padaria_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
    }

    @PostMapping
    public ResponseEntity <Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }
        @PutMapping
        public ResponseEntity <Usuario> editarUsuario(@RequestBody Usuario usuario){
            return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
            usuarioService.excluirUsuario(id);
            return ResponseEntity.status(204).build();
        }

        @PostMapping("/login")
        public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario){
        Boolean valid = usuarioService.validarSenha(usuario);
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
            return ResponseEntity.status(200).build();
    }
}



