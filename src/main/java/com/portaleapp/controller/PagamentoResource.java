package com.portaleapp.controller;

import com.portaleapp.dto.Pagamento;
import com.portaleapp.service.PagamentoEScontoFactory;
import com.portaleapp.model.strategia.pagamento.StrategiaPagamento;
import com.portaleapp.model.strategia.sconto.StrategiaSconto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/pagamento")
public class PagamentoResource {

    @Inject
    PagamentoEScontoFactory pagamentoEScontoFactory;

    @POST
    @Path("/processa")
    @Produces("text/plain")
    @Consumes("application/json")
    public String processaPagamento(Pagamento pagamento) {
        StrategiaPagamento strategiaPagamento = pagamentoEScontoFactory.getStrategiaPagamento(pagamento.getTipoPagamento());
        StrategiaSconto strategiaSconto = pagamentoEScontoFactory.getStrategiaSconto(pagamento.getTipoSconto());
        double prezzoConSconto = strategiaSconto.applicaSconto(pagamento.getPrezzo());
        boolean pagamentoEffettuato = strategiaPagamento.eseguiPagamento(prezzoConSconto);
        if (pagamentoEffettuato) {
            String metodoOutput = strategiaPagamento.getClass().getSimpleName().replace("Pagamento", "").replace("_ClientProxy", "");
            String tipoScontoOutput = strategiaSconto.getClass().getSimpleName() .replace("Sconto", "").replace("_ClientProxy", "");
            return "Pagamento processato con successo!\nMetodo usato: "+metodoOutput+".\nTipo di sconto: "+tipoScontoOutput+".\nPrezzo finale: " + prezzoConSconto ;
        } else {
            return "Errore nel pagamento.";
        }
    }
}