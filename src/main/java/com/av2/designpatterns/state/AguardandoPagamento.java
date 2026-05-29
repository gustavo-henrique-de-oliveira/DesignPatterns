package com.av2.designpatterns.state;

import com.av2.designpatterns.domains.Pedido;
import com.av2.designpatterns.domains.enums.StatusPedido;

public class AguardandoPagamento implements PedidoState{

    @Override
    public void pagar(Pedido pedido) {
        pedido.setStatus(StatusPedido.PAGO);
    }
    @Override
    public void cancelar(Pedido pedido) {
        pedido.setStatus(StatusPedido.CANCELADO);
    }
    @Override
    public void enviar(Pedido pedido) {

        throw new RuntimeException(
                "Pedido precisa estar pago"
        );
    }
}
