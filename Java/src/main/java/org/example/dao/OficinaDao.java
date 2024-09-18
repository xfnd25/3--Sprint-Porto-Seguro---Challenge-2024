package org.example.dao;

import org.example.entities.Oficina;
import org.example.entities.Usuario;

import java.util.List;

public interface OficinaDao {
    void create(Oficina oficina);
    List<Oficina> read();

    void update(Oficina oficina);

    void delete(Long id);
}
