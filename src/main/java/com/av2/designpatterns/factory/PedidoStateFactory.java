package com.av2.designpatterns.factory;

import com.av2.designpatterns.domains.enums.StatusPedido;
import com.av2.designpatterns.state.*;

public class PedidoStateFactory {
    public static PedidoState getState(StatusPedido status) {

        return switch (status) {

            case AGUARDANDO_PAGAMENTO ->
                    new AguardandoPagamento();

            case PAGO ->
                    new Pago();

            case ENVIADO ->
                    new Enviado();

            case CANCELADO ->
                    new Cancelado();
        };
    }
}
