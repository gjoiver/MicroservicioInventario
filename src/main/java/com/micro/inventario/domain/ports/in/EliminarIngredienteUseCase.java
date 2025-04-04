package com.micro.inventario.domain.ports.in;

public interface EliminarIngredienteUseCase {
    Boolean eliminarIngrediente(Long id, Integer cantidad);
}
