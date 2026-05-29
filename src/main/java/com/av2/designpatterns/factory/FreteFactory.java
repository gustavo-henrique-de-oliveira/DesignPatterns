package com.av2.designpatterns.factory;

import com.av2.designpatterns.strategy.FreteAereo;
import com.av2.designpatterns.strategy.FreteStrategy;
import com.av2.designpatterns.strategy.FreteTerrestre;

public class FreteFactory {

    public static FreteStrategy criar(String tipoFrete) {

        if(tipoFrete.equalsIgnoreCase("AEREO")) {
            return new FreteAereo();
        }

        return new FreteTerrestre();
    }
}
