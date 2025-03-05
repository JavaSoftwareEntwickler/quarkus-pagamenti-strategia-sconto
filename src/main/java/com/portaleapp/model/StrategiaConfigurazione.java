package com.portaleapp.model;

import com.portaleapp.model.strategia.pagamento.StrategiaPagamento;
import com.portaleapp.model.strategia.sconto.StrategiaSconto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class StrategiaConfigurazione {

    @Produces
    public Map<String, StrategiaPagamento> produceMappaPagamento(Set<StrategiaPagamento> strategiePagamento) {
        Map<String, StrategiaPagamento> mappa = new HashMap<>();
        for (StrategiaPagamento strategia : strategiePagamento) {
            //NomeStrategia nomeStrategia = strategia.getClass().getAnnotation(NomeStrategia.class);
            //mappa.put(nomeStrategia.value(), strategia);
            String key = strategia.getClass().getSimpleName().replace("Pagamento", "").toLowerCase();
            mappa.put(key, strategia);
        }
        return mappa;
    }

    @Produces
    public Map<String, StrategiaSconto> produceMappaSconto(Set<StrategiaSconto> strategieSconto) {
        Map<String, StrategiaSconto> mappa = new HashMap<>();
        for (StrategiaSconto strategia : strategieSconto) {
            //NomeStrategia nomeStrategia = strategia.getClass().getAnnotation(NomeStrategia.class);
            //mappa.put(nomeStrategia.value(), strategia);
            String key = strategia.getClass().getSimpleName().replace("Sconto", "").toLowerCase();
            mappa.put(key, strategia);
        }
        return mappa;
    }
}
