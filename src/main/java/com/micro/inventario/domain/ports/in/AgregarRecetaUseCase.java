package com.micro.inventario.domain.ports.in;

import com.micro.inventario.domain.entities.Receta;


public interface AgregarRecetaUseCase {
    Receta agregarReceta(Receta receta);
}
