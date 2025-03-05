package com.portaleapp.model.strategia.sconto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.swing.*;

@ApplicationScoped
//@NomeStrategia("scontoFisso")
public class ScontoFisso implements StrategiaSconto {
    @Inject
    @ConfigProperty(name = "sconto.fisso.valore")
    private Double valore;

    @Override
    public double applicaSconto(double prezzo) {
        return prezzo - valore;
    }

}
