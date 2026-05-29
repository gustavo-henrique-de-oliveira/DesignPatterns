package com.av2.designpatterns.state;

import com.av2.designpatterns.domains.Pedido;

public class Enviado implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido já enviado"
        );
    }

    @Override
    public void cancelar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido enviado não pode ser cancelado"
        );
    }

    @Override
    public void enviar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido já enviado"
        );
    }
}
