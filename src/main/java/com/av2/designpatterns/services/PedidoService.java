package com.av2.designpatterns.services;

import com.av2.designpatterns.domains.Pedido;
import com.av2.designpatterns.domains.dtos.PedidoDTO;
import com.av2.designpatterns.domains.enums.StatusPedido;
import com.av2.designpatterns.factory.FreteFactory;
import com.av2.designpatterns.factory.PedidoStateFactory;
import com.av2.designpatterns.repositories.PedidoRepository;
import com.av2.designpatterns.state.PedidoState;
import com.av2.designpatterns.strategy.FreteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criarPedido(PedidoDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setCliente(dto.getCliente());
        pedido.setValor(dto.getValor());
        pedido.setTipoFrete(dto.getTipoFrete());

        FreteStrategy strategy =
                FreteFactory.criar(dto.getTipoFrete());

        pedido.setValorFrete(
                strategy.calcularFrete(dto.getValor())
        );

        pedido.setStatus(
                StatusPedido.AGUARDANDO_PAGAMENTO
        );

        return repository.save(pedido);
    }

    public List<Pedido> listarPedidos() {

        return repository.findAll();
    }

    public Pedido pagar(Long id) {

        Pedido pedido = buscarPedido(id);

        PedidoState state =
                PedidoStateFactory.getState(
                        pedido.getStatus()
                );

        state.pagar(pedido);

        return repository.save(pedido);
    }

    public Pedido cancelar(Long id) {

        Pedido pedido = buscarPedido(id);

        PedidoState state =
                PedidoStateFactory.getState(
                        pedido.getStatus()
                );

        state.cancelar(pedido);

        return repository.save(pedido);
    }

    public Pedido enviar(Long id) {

        Pedido pedido = buscarPedido(id);

        PedidoState state =
                PedidoStateFactory.getState(
                        pedido.getStatus()
                );

        state.enviar(pedido);

        return repository.save(pedido);
    }

    private Pedido buscarPedido(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Pedido não encontrado"
                        )
                );
    }
}
