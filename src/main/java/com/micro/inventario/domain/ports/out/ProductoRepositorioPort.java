package com.micro.inventario.domain.ports.out;

import com.micro.inventario.domain.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositorioPort {
   Producto guardar(Producto producto);
   List<Producto> obtenerTodos();
   Optional<Producto> obtenerPorId(Long id);
   Optional<Producto> actualizar(Producto producto);
   boolean eliminar(Long id);
}
