package com.av2.designpatterns.domains;

import com.av2.designpatterns.domains.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private Double valor;
    private Double valorFrete;
    private String tipoFrete;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
