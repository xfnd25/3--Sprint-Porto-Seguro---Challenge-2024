package org.example.enums;

import org.example.interfaces.Descritivel;

public enum TipoCombustivel implements Descritivel {
    GASOLINA("Gasolina"),
    DIESEL("Diesel"),
    ETANOL("Etanol"),
    FLEX("Flex"),
    GNV("GNV"),
    ELETRICO("Elétrico"),
    HIBRIDO("Híbrido");

    private final String descricao;

    TipoCombustivel(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
