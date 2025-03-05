package com.portaleapp.model.strategia.pagamento;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@NomeStrategia("bonifico")
public class PagamentoBonifico implements StrategiaPagamento {
    @Override
    public boolean eseguiPagamento(double importo) {
        System.out.println("Pagamento di " + importo + " tramite bonifico bancario.");
        return true;
    }
}