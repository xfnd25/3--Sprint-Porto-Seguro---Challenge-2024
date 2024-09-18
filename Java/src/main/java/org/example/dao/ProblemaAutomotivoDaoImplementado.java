package org.example.dao;

import org.example.DatabaseConfig;
import org.example.entities.ProblemaAutomotivo;

import java.util.List;

public class ProblemaAutomotivoDaoImplementado implements ProblemaAutomotivoDao{

    private final DatabaseConfig db;

    public ProblemaAutomotivoDaoImplementado(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void create(ProblemaAutomotivo problema) {
        //TODO
    }

    @Override
    public List<ProblemaAutomotivo> read() {
        return null;
        //TODO
    }

    @Override
    public void update(ProblemaAutomotivo problema) {
        //TODO
    }

    @Override
    public void delete(Long idProblema) {
        //TODO
    }
}
