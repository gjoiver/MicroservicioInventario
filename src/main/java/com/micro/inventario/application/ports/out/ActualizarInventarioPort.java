package com.micro.inventario.application.ports.out;

import com.micro.inventario.domain.entities.Ingrediente;

public interface ActualizarInventarioPort {
    void actualizarInventario(Ingrediente ingrediente);
}
