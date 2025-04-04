package com.micro.inventario.application.usecases;

import com.micro.inventario.domain.entities.Producto;
import com.micro.inventario.domain.ports.in.AgregarProductoUseCase;
import com.micro.inventario.domain.ports.out.IngredienteRepositorioPort;
import com.micro.inventario.domain.ports.out.ProductoRepositorioPort;

public class AgregarProductoUseCaseImpl implements AgregarProductoUseCase {
    private final ProductoRepositorioPort productoRepositorio;

    public AgregarProductoUseCaseImpl(ProductoRepositorioPort productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }


    @Override
    public Producto agregarProducto(Producto producto) {
        return this.productoRepositorio.guardar(producto);
    }
}
