package org.example.enums;

import org.example.interfaces.Descritivel;

public enum Genero implements Descritivel {
    MULHER_CIS("Mulher Cis"),
    MULHER_TRANS("Mulher Trans"),
    HOMEM_CIS("Homem Cis"),
    HOMEM_TRANS("Homem Trans"),
    NAO_BINARIO("Não Binário"),
    PREFIRO_NAO_IDENTIFICAR("Prefiro Não Identificar");

    private String descricao;

    //construtor
    Genero(String descricao) {
        this.descricao = descricao;
    }

    //método da interface
    @Override
    public String getDescricao() {
        return descricao;
    }
}

