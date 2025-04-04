package com.micro.inventario.application.usecases;

import com.micro.inventario.domain.ports.in.ValidarProductoUseCase;

public class ValidarProductoUseCaseImpl implements ValidarProductoUseCase {
    private final ValidarProductoUseCase validarProductoUseCase;

    public ValidarProductoUseCaseImpl(ValidarProductoUseCase validarProductoUseCase) {
        this.validarProductoUseCase = validarProductoUseCase;
    }

    @Override
    public boolean validarProducto(Long id) {
        return this.validarProductoUseCase.validarProducto(id);
    }
}
