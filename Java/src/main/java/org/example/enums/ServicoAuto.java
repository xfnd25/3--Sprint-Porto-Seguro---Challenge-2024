package org.example.enums;

import org.example.interfaces.Calculavel;
import org.example.interfaces.Descritivel;

public enum ServicoAuto implements Descritivel, Calculavel {
    ALINHAMENTO_DIRECAO("Alinhamento de Direção", 150.0),
    AMORTECEDOR_E_MOLAS("Amortecedor e Molas", 250.0),
    LIMPEZA_AR_CONDICIONADO("Limpeza de Ar Condicionado", 120.0),
    ARREFECIMENTO("Sistema de Arrefecimento", 180.0),
    BATERIA("Troca de Bateria", 200.0),
    BALANCEAMENTO_DE_RODAS("Balanceamento de Rodas", 100.0),
    CABOS("Troca de Cabos", 130.0),
    CAMBAGEM("Ajuste de Cambagem", 110.0),
    CORREIAS_DO_MOTOR("Substituição de Correias do Motor", 210.0),
    DIRECAO("Sistema de Direção", 220.0),
    EXTINTOR_DE_INCENDIO("Verificação do Extintor de Incêndio", 50.0),
    FILTROS("Troca de Filtros", 90.0),
    FREIOS("Revisão dos Freios", 200.0),
    IGNICAO("Sistema de Ignição", 160.0),
    INJECAO_ELETRONICA("Revisão de Injeção Eletrônica", 190.0),
    OLEO_DO_MOTOR("Troca de Óleo do Motor", 80.0),
    PALHETAS_DO_LIMPADOR("Substituição de Palhetas do Limpador", 70.0),
    PNEUS("Troca de Pneus", 300.0),
    SUSPENSAO("Revisão da Suspensão", 240.0);

    private final String descricao;
    private final double precoServico;

    ServicoAuto(String descricao, double precoServico) {
        this.descricao = descricao;
        this.precoServico = precoServico;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double calcularPreco() {
        return precoServico;
    }
}
