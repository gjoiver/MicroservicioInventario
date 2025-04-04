package com.micro.inventario.domain.ports.in;

import com.micro.inventario.domain.entities.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface ValidarIngredientesUseCase {
    Optional<Ingrediente> validarIngrediente(Long id);
    List<Ingrediente> validarIngredientes();

}
