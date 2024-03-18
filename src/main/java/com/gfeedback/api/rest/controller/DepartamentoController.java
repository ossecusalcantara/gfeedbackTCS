package com.gfeedback.api.rest.controller;

import com.gfeedback.api.rest.dto.DepartamentoRequest;
import com.gfeedback.api.rest.dto.DepartamentoResponse;
import com.gfeedback.api.rest.entidades.Departamento;
import com.gfeedback.api.rest.mappers.DepartamentoMapper;
import com.gfeedback.api.rest.repositorios.DepartamentoRepository;
import com.gfeedback.api.rest.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<DepartamentoResponse>> carregarDepartamentos() {
        List<Departamento> retorno = departamentoRepository.findAll();

        List<DepartamentoResponse> out = retorno.stream()
                .map(DepartamentoMapper :: departamentoToDepartamentoResponse)
                .toList();

        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<DepartamentoResponse> criarDepartamento(@RequestBody DepartamentoRequest departamento) {
        Departamento envio = DepartamentoMapper.departamentoRequestToDepartamento(departamento);

        Departamento retorno = departamentoRepository.save(envio);

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DepartamentoMapper.departamentoToDepartamentoResponse(retorno));
    }
}
