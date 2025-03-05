package com.portaleapp.service;

import com.portaleapp.model.strategia.pagamento.StrategiaPagamento;
import com.portaleapp.model.strategia.sconto.StrategiaSconto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PagamentoEScontoFactory {
    private final Map<String, StrategiaPagamento> strategiePagamento = new HashMap<>();
    private final Map<String, StrategiaSconto> strategieSconto = new HashMap<>();

    @Inject
    public PagamentoEScontoFactory(
            @Any Instance<StrategiaPagamento> strategiePagamento,
            @Any Instance<StrategiaSconto> strategieSconto
    ) {
        for (StrategiaPagamento sp : strategiePagamento) {
            this.strategiePagamento.put(sp.getClass().getSimpleName().toLowerCase().replace("_clientproxy", ""), sp);
        }
        for (StrategiaSconto ss : strategieSconto) {
            this.strategieSconto.put(ss.getClass().getSimpleName().toLowerCase().replace("_clientproxy", ""), ss);
        }
    }

    public StrategiaPagamento getStrategiaPagamento(String tipoPagamento) {
        System.out.println("Tipo di pagamento che stampo : " + tipoPagamento);
        strategiePagamento.forEach((k, v) -> System.out.println(k + " --->>" + v));
        return strategiePagamento.get(tipoPagamento.toLowerCase().replace("_clientproxy", ""));
    }

    public StrategiaSconto getStrategiaSconto(String tipoSconto) {
        strategieSconto.forEach((k, v) -> System.out.println(k + " --->>" + v));
        return strategieSconto.get(tipoSconto.toLowerCase().replace("_clientproxy", ""));
    }
}
