package org.example.entities;

import org.example.entities.PecaAutomotiva;

import java.util.List;

public class ProblemaAutomotivo {
    private Long idProblema;
    private String descricao;

    private List<ImagemProblema> imagensRelacionadas;

    private PecaAutomotiva pecaAssociada;

    public ProblemaAutomotivo(Long idProblema, String descricao,List<ImagemProblema> imagensRelacionadas, PecaAutomotiva pecaAssociada) {
        this.idProblema = idProblema;
        this.descricao = descricao;
        this.imagensRelacionadas = imagensRelacionadas;
        this.pecaAssociada = pecaAssociada;
    }

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ImagemProblema> getImagensRelacionadas() {
        return imagensRelacionadas;
    }

    public void setImagensRelacionadas(List<ImagemProblema> imagensRelacionadas) {
        this.imagensRelacionadas = imagensRelacionadas;
    }

    public PecaAutomotiva getPecaAssociada() {
        return pecaAssociada;
    }

    public void setPecaAssociada(PecaAutomotiva pecaAssociada) {
        this.pecaAssociada = pecaAssociada;
    }
}
