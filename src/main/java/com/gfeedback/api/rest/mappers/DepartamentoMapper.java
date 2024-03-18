package com.gfeedback.api.rest.mappers;

import com.gfeedback.api.rest.dto.DepartamentoRequest;
import com.gfeedback.api.rest.dto.DepartamentoResponse;
import com.gfeedback.api.rest.entidades.Departamento;

public class DepartamentoMapper {

    public static Departamento departamentoRequestToDepartamento(DepartamentoRequest departamento) {
        Departamento out = new Departamento();

        out.setId(departamento.getId());
        out.setNome(departamento.getNome());

        return out;
    }

    public static DepartamentoResponse departamentoToDepartamentoResponse(Departamento departamento) {
        DepartamentoResponse out = new DepartamentoResponse();

        out.setId(departamento.getId());
        out.setNome(departamento.getNome());

        return out;
    }

}
