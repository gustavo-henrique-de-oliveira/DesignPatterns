package com.av2.designpatterns.strategy;

import com.av2.designpatterns.domains.Pedido;

public interface FreteStrategy {
    Double calcularFrete(Double valorPedido);
}
