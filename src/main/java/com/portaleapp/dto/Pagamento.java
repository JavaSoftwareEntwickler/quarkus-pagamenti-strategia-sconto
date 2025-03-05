package com.portaleapp.dto;

public class Pagamento {
    private String tipoPagamento;
    private String tipoSconto;
    private double prezzo;

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoSconto() {
        return tipoSconto;
    }

    public void setTipoSconto(String tipoSconto) {
        this.tipoSconto = tipoSconto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
