package com.portaleapp.model.strategia.sconto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
//@NomeStrategia("scontoPercentuale")
public class ScontoPercentuale implements StrategiaSconto {
    @Inject
    @ConfigProperty(name = "sconto.percentuale.valore")
    private Double percentuale;

    @Override
    public double applicaSconto(double prezzo) {
        return prezzo - (prezzo * percentuale / 100);
    }

}
