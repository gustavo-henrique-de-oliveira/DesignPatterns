package com.av2.designpatterns.state;

import com.av2.designpatterns.domains.Pedido;

public class Cancelado implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido cancelado"
        );
    }

    @Override
    public void cancelar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido já cancelado"
        );
    }

    @Override
    public void enviar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido cancelado"
        );
    }
}
