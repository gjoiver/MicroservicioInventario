package com.micro.inventario.application.usecases;

import com.micro.inventario.domain.ports.in.EliminarProductoUseCase;
import com.micro.inventario.domain.ports.out.ProductoRepositorioPort;

public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase {
    private final ProductoRepositorioPort productoRepositorio;

    public EliminarProductoUseCaseImpl(ProductoRepositorioPort productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public boolean eliminarProducto(Long id) {
        return this.productoRepositorio.eliminar(id);
    }
}
