package org.example.entities;

import org.example.enums.Genero;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private Long idade;
    private List<Veiculo> veiculos;
    private Genero genero;
    private String cpf;

    // Construtor completo com validação de idade
    public Cliente(Long id, String nome, String email, String telefone, String endereco, Long idade, Genero genero, String cpf) {
        super(id, nome, email, telefone, endereco);
        if (isMaiorDeIdade(idade)) {
            this.idade = idade;
        } else {
            throw new RuntimeException("A pessoa não é maior de idade");
        }
        this.genero = genero;
        this.cpf = cpf;
        this.veiculos = new ArrayList<>();
    }

    // Construtor alternativo
    public Cliente(Long id, String nome, String email, String telefone, String endereco, String cpf) {
        super(id, nome, email, telefone, endereco);
        this.cpf = cpf;
        this.veiculos = new ArrayList<>();
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        if (isMaiorDeIdade(idade)) {
            this.idade = idade;
        } else {
            throw new RuntimeException("A pessoa não é maior de idade");
        }
    }


    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    //
    // Método que valida se é maior de idade
    private boolean isMaiorDeIdade(Long idade) {
        return idade >= 18;
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}

