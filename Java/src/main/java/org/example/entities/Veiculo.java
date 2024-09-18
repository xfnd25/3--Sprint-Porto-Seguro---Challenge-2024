package org.example.entities;

import org.example.enums.Cambio;
import org.example.enums.TipoCombustivel;

public class Veiculo {
    private String idVeiculo;
    private String placa;
    private String modelo;
    private String marca;
    private TipoCombustivel tipoCombustivel;
    private Cambio cambio;

    public Veiculo(String idVeiculo, String placa, String modelo, String marca, TipoCombustivel tipoCombustivel, Cambio cambio) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoCombustivel = tipoCombustivel;
        this.cambio = cambio;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Cambio getCambio() {
        return cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    @Override
    public String toString() {
        return "Veiculo [placa: " + placa + ", modelo: " + modelo + ", marca: " + marca
                + ", tipoCombustivel: " + tipoCombustivel.getDescricao()
                + ", cambio: " + cambio.getDescricao() + "]";
    }
}

