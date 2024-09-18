package org.example.dao;

import org.example.entities.Cliente;
import org.example.entities.Usuario;

import java.util.List;

public interface ClienteDao {
    void create(Cliente cliente);
    List<Cliente> read();

    void update(Cliente cliente);

    void delete(Long id);
}
