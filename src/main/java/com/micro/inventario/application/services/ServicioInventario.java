package com.micro.inventario.application.services;

import com.micro.inventario.application.ports.in.ProcesarPedidoUseCase;
import com.micro.inventario.application.ports.out.ActualizarInventarioPort;
import com.micro.inventario.application.ports.out.ObtenerIngredientePort;
import com.micro.inventario.application.ports.out.ObtenerProductoPort;

import com.micro.inventario.domain.entities.Ingrediente;
import com.micro.inventario.domain.entities.ItemPedido;
import com.micro.inventario.domain.entities.Pedido;
import com.micro.inventario.domain.entities.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicioInventario implements ProcesarPedidoUseCase {

    private final ObtenerProductoPort obtenerProductoPort;
    private final ObtenerIngredientePort obtenerIngredientePort;
    private final ActualizarInventarioPort actualizarInventarioPort;

    public ServicioInventario(ObtenerProductoPort obtenerProductoPort, ObtenerIngredientePort obtenerIngredientePort, ActualizarInventarioPort actualizarInventarioPort) {
        this.obtenerProductoPort = obtenerProductoPort;
        this.obtenerIngredientePort = obtenerIngredientePort;
        this.actualizarInventarioPort = actualizarInventarioPort;
    }

    @Override
    @Transactional
    public Boolean procesarPedido(Pedido pedido) {}

    private boolean validarIngredientes(Pedido pedido) {
        Map<Long, Integer> ingredientesRequeridos = calcularIngredientesRequeridos(pedido);

        for (Map.Entry<Long, Integer> entry : ingredientesRequeridos.entrySet()) {
            Optional<Ingrediente> ingrediente = obtenerIngredientePort.obtenerIngredientePorId(entry.getKey());

            if (ingrediente.isEmpty() || ingrediente.get().getStock() < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private void actualizarInventario(Pedido pedido) {
        Map<Long, Integer> ingredientesRequeridos = calcularIngredientesRequeridos(pedido);

        for (Map.Entry<Long, Integer> entry : ingredientesRequeridos.entrySet()) {
            Optional<Ingrediente> ingredienteModel = obtenerIngredientePort.obtenerIngredientePorId(entry.getKey());
            if (ingredienteModel.isPresent()) {
                Ingrediente ingrediente = ingredienteModel.get();
                ingrediente.usarStock(entry.getValue());
                actualizarInventarioPort.actualizarIngrediente(ingrediente);
            }
        }
    }

    private Map<Long, Integer> calcularIngredientesRequeridos(Pedido pedido) {
        Map<Long, Integer> ingredientesRequeridos = new HashMap<Long, Integer>();

        for (ItemPedido item : pedido.getItems()) {
            Optional<Producto> productoModel = obtenerProductoPort.ObtenerProductoPorId(item.getIdProducto());

            if (productoModel.isPresent()) {
                Producto producto = productoModel.get();

                for (Map.Entry<Long, Integer> ingredienteReceta : producto.getReceta().getIngredientes().entrySet()) {
                    Long idIngrediente = ingredienteReceta.getKey();
                    int cantidadPorProducto = ingredienteReceta.getValue();
                    int totalRequerido = cantidadPorProducto * item.getCantidad();

                    ingredientesRequeridos.merge(idIngrediente,totalRequerido, Integer::sum);
                }
            }
        }
        return ingredientesRequeridos;
    }

}
