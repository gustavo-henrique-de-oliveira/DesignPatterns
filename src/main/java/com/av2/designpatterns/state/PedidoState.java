package com.av2.designpatterns.state;

public interface PedidoState {

    void pagar(com.av2.designpatterns.domains.Pedido pedido);

    void cancelar(com.av2.designpatterns.domains.Pedido pedido);

    void enviar(com.av2.designpatterns.domains.Pedido pedido);
}
