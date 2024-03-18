package com.gfeedback.api.rest.mappers;

import com.gfeedback.api.rest.dto.UsuarioRequest;
import com.gfeedback.api.rest.dto.UsuarioResponse;
import com.gfeedback.api.rest.entidades.Usuario;

public class UsuarioMapper {

    public static Usuario usuarioRequestToUsuario(UsuarioRequest usuario) {
        Usuario out = new Usuario();

        out.setNome(usuario.getNome());
        out.setEmail(usuario.getEmail());
        out.setDepartamento(usuario.getDepartamento());

        return out;
    }

    public static UsuarioResponse usuarioToUsuarioResponse(Usuario usuario) {
        UsuarioResponse out = new UsuarioResponse();

        out.setNome(usuario.getNome());
        out.setEmail(usuario.getEmail());
        out.setDepartamento(usuario.getDepartamento());

        return out;
    }
}
