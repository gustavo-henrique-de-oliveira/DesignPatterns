package com.av2.designpatterns.domains.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PedidoDTO {

    @NotEmpty
    private String cliente;

    @Positive
    private Double valor;

    @NotBlank
    private String tipoFrete;
}
