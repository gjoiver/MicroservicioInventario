package com.micro.inventario.domain.ports.out;

import com.micro.inventario.domain.entities.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteRepositorioPort {
    Ingrediente guardar(Ingrediente ingrediente);
    List<Ingrediente> obtenerTodos();
    Optional<Ingrediente> obtenerPorId(Long id);
    Optional<Ingrediente> actualizar(Ingrediente ingrediente);
    Boolean eliminar(Long id);
}
