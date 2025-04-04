package com.micro.inventario.domain.ports.in;

import com.micro.inventario.domain.entities.Ingrediente;

public interface AgregarIngredienteUseCase {
    Ingrediente agregarIngredienteExistente(Long id, Integer cantidad);
    Ingrediente agregarIngredienteNuevo(Ingrediente ingrediente);
}
