package org.example.entities;

import org.example.enums.ServicoAuto;

import java.util.Date;

public class AgendaServico {
    private Usuario cliente;
    private Veiculo veiculo;
    private Date data;
    private Oficina oficina;
    private ServicoAuto servicoAuto;
    private Orcamento orcamento;

    // Construtores
    public AgendaServico(Usuario cliente, Veiculo veiculo, Date data, Oficina oficina, ServicoAuto servicoAuto, Orcamento orcamento) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.data = data;
        this.oficina = oficina;
        this.servicoAuto = servicoAuto;
        this.orcamento = orcamento;
    }

    // Getters e Setters
    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public ServicoAuto getServicoAuto() {
        return servicoAuto;
    }

    public void setServicoAuto(ServicoAuto servicoAuto) {
        this.servicoAuto = servicoAuto;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    // Métodos
    public void adicionarServico(ServicoAuto servicoAuto) {
        this.servicoAuto = servicoAuto;
    }

    public void removerServico() {
        this.servicoAuto = null;
    }

    public void consultarServico() {
        if (this.servicoAuto != null) {
            System.out.println("Serviço agendado: " + servicoAuto);
            System.out.println("Descrição: " + servicoAuto.getDescricao());
        } else {
            System.out.println("Nenhum serviço agendado.");
        }
    }
}

