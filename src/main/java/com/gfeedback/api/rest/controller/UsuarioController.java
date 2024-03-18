package com.gfeedback.api.rest.controller;

import com.gfeedback.api.rest.dto.UsuarioRequest;
import com.gfeedback.api.rest.dto.UsuarioResponse;
import com.gfeedback.api.rest.entidades.Usuario;
import com.gfeedback.api.rest.mappers.UsuarioMapper;
import com.gfeedback.api.rest.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<UsuarioResponse>> carregarUsuarios() {
        List<Usuario> retorno = usuarioRepository.findAll();

        List<UsuarioResponse> out = retorno.stream()
                .map(UsuarioMapper :: usuarioToUsuarioResponse)
                .toList();

        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public  ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest usuario) {
        Usuario envio = UsuarioMapper.usuarioRequestToUsuario(usuario);

        Usuario retorno = usuarioRepository.save(envio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UsuarioMapper.usuarioToUsuarioResponse(retorno));
    }

}
