package com.av2.designpatterns.state;

import com.av2.designpatterns.domains.Pedido;
import com.av2.designpatterns.domains.enums.StatusPedido;

public class Pago implements PedidoState {
    @Override
    public void pagar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido já foi pago"
        );
    }

    @Override
    public void cancelar(Pedido pedido) {

        pedido.setStatus(StatusPedido.CANCELADO);
    }

    @Override
    public void enviar(Pedido pedido) {

        pedido.setStatus(StatusPedido.ENVIADO);
    }
}
