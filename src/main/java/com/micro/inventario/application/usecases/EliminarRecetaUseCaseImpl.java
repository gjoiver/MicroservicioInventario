package com.micro.inventario.application.usecases;

import com.micro.inventario.domain.ports.in.EliminarRecetaUseCase;
import com.micro.inventario.domain.ports.out.RecetaRepositorioPort;

public class EliminarRecetaUseCaseImpl implements EliminarRecetaUseCase {
    private final RecetaRepositorioPort recetaRepositorio;

    public EliminarRecetaUseCaseImpl(RecetaRepositorioPort recetaRepositorio) {
        this.recetaRepositorio = recetaRepositorio;
    }

    @Override
    public boolean eliminar(Long id) {
        return this.recetaRepositorio.eliminar(id);
    }
}
