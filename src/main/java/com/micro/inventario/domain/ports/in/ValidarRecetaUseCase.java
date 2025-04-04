package com.micro.inventario.domain.ports.in;

import com.micro.inventario.domain.entities.Receta;

import java.util.List;
import java.util.Optional;

public interface ValidarRecetaUseCase {
    Optional<Receta> validarReceta(Long id);
    List<Receta> validarRecetas();
}
