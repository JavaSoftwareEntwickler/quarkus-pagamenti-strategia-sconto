package com.portaleapp.model.strategia.pagamento;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@NomeStrategia("cartaCredito")
public class PagamentoCartaCredito implements StrategiaPagamento {
    @Override
    public boolean eseguiPagamento(double importo) {
        System.out.println("Pagamento di " + importo + " con carta di credito.");
        return true;
    }
}
