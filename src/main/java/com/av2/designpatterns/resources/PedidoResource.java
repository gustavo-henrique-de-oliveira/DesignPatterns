package com.av2.designpatterns.resources;

import com.av2.designpatterns.domains.Pedido;
import com.av2.designpatterns.domains.dtos.PedidoDTO;
import com.av2.designpatterns.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @PostMapping
    public Pedido criarPedido(
            @Valid @RequestBody PedidoDTO dto
    ) {

        return service.criarPedido(dto);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {

        return service.listarPedidos();
    }

    @PutMapping("/{id}/pagar")
    public Pedido pagar(@PathVariable Long id) {

        return service.pagar(id);
    }

    @PutMapping("/{id}/cancelar")
    public Pedido cancelar(@PathVariable Long id) {

        return service.cancelar(id);
    }

    @PutMapping("/{id}/enviar")
    public Pedido enviar(@PathVariable Long id) {

        return service.enviar(id);
    }
}
