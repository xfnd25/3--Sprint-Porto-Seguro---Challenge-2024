package org.example.entities;

import org.example.enums.ServicoAuto;

public class Orcamento {
    private ServicoAuto servicoAuto;
    private double precoServico;
    private double precoPeca;

    // Construtor

    public Orcamento(ServicoAuto servicoAuto, double precoServico, double precoPeca) {
        this.servicoAuto = servicoAuto;
        this.precoServico = precoServico;
        this.precoPeca = precoPeca;
    }

    // Getters e Setters
    public ServicoAuto getServicoAuto() {
        return servicoAuto;
    }

    public void setServicoAuto(ServicoAuto servicoAuto) {
        this.servicoAuto = servicoAuto;
        this.precoServico = servicoAuto.calcularPreco();
    }

    public double getPrecoServico() {
        return precoServico;
    }

    public double getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(double precoPeca) {
        this.precoPeca = precoPeca;
    }

    // Métodos
    public double calcularOrcamentoTotal() {
        return precoServico + precoPeca;
    }
}


