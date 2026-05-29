package com.av2.designpatterns.repositories;

import com.av2.designpatterns.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<Pedido,Long> {

}
