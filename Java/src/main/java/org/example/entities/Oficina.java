package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Oficina extends Usuario {
    private String cnpj;
    private String razaoSocial;
    private List<Veiculo> veiculosParaServico;

    public Oficina(Long id,String nome, String email, String telefone, String endereco) {
        super(id, nome, email, telefone, endereco);
    }

    public Oficina(Long id, String nome, String email, String telefone, String endereco, String cnpj, String razaoSocial) {
        super(id, nome, email, telefone, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.veiculosParaServico = new ArrayList<>();
    }


    //getter e setters


    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Veiculo> getVeiculosParaServico() {
        return veiculosParaServico;
    }

    public void setVeiculosParaServico(List<Veiculo> veiculosParaServico) {
        this.veiculosParaServico = veiculosParaServico;
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosParaServico.add(veiculo);
    }

    @Override
    public void removerVeiculo(Veiculo veiculo) {
        veiculosParaServico.remove(veiculo);
    }

    public List<Veiculo> getveiculosParaServico() {
        return veiculosParaServico;
    }
}