package com.portaleapp.model.strategia.sconto;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@NomeStrategia("noSconto")
public class NessunoSconto implements StrategiaSconto {

    @Override
    public double applicaSconto(double prezzo) {
        return prezzo;
    }
}
