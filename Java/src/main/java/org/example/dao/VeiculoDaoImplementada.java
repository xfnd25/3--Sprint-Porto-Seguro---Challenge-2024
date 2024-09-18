package org.example.dao;

import org.example.DatabaseConfig;
import org.example.entities.Veiculo;

import java.util.List;

public class VeiculoDaoImplementada implements VeiculoDao{

    private final DatabaseConfig db;
    public VeiculoDaoImplementada(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void create(Veiculo veiculo) {

    }

    @Override
    public List<Veiculo> read() {
        return null;
    }

    @Override
    public void update(Veiculo veiculo) {

    }

    @Override
    public void delete(Long id) {

    }
}
