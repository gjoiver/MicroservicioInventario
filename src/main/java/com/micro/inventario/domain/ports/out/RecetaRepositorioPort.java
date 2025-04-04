package com.micro.inventario.domain.ports.out;

import com.micro.inventario.domain.entities.Receta;

import java.util.List;
import java.util.Optional;

public interface RecetaRepositorioPort {
    Receta guardar(Receta receta);
    List<Receta> obtenetTodos();
    Optional<Receta> obtenerPorId(Long id);
    Optional<Receta> actualizar(Receta receta);
    Boolean eliminar(Long id);
}
