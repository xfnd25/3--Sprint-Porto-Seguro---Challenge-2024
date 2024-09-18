package org.example.dao;

import org.example.entities.ProblemaAutomotivo;
import org.example.entities.Usuario;

import java.util.List;

public interface ProblemaAutomotivoDao {

    void create(ProblemaAutomotivo problema);
    List<ProblemaAutomotivo> read();

    void update(ProblemaAutomotivo problema);

    void delete(Long idProblema);
}
