package com.micro.inventario.domain.ports.in;

import com.micro.inventario.domain.entities.Producto;

public interface ValidarProductoUseCase {
    Boolean validarProducto(Long id);
}
