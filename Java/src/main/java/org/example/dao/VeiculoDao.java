package org.example.dao;

import org.example.entities.Usuario;
import org.example.entities.Veiculo;

import java.util.List;

public interface VeiculoDao {
    void create(Veiculo veiculo);
    List<Veiculo> read();

    void update(Veiculo veiculo);

    void delete(Long id);
}
