package com.PrimeraEntidad.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoDTO {

    @NotBlank(message = "Nombre obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotNull @DecimalMin("0.01")
    private BigDecimal precio;

    @NotBlank
    private String categoria;


}
