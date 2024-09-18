package org.example.enums;

import org.example.interfaces.Descritivel;

public enum Cambio implements Descritivel {
    MANUAL("Manual"),
    AUTOMATICO("Automático"),
    SEMI_AUTOMATICO("Semi-Automático");

    private final String descricao;

    Cambio(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

