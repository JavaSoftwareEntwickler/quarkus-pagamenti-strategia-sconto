package com.portaleapp.model.strategia.pagamento;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@NomeStrategia("payPal")
public class PagamentoPayPal implements StrategiaPagamento {
    @Override
    public boolean eseguiPagamento(double importo) {
        System.out.println("Pagamento di " + importo + " tramite PayPal.");
        return true;
    }
}