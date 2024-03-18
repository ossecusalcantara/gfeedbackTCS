package com.gfeedback.api.rest.dto;

import com.gfeedback.api.rest.entidades.Departamento;

public class UsuarioRequest {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private DepartamentoRequest departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public DepartamentoRequest getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoRequest departamento) {
        this.departamento = departamento;
    }
}
