package org.example.dao;

import org.example.entities.Usuario;

import java.util.List;

public interface UsuarioDao {


    void create(Usuario usuario);
    List<Usuario> read();

    void update(Usuario usuario);

    void delete(Long id);
}
