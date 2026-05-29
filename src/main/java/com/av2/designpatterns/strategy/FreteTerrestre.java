package com.av2.designpatterns.strategy;

public class FreteTerrestre implements FreteStrategy {

    @Override
    public Double calcularFrete(Double valorPedido) {
        return valorPedido * 0.05;
    }
}
