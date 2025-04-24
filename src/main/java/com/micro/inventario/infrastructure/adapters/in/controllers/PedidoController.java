package com.micro.inventario.infrastructure.adapters.in.controllers;

import com.micro.inventario.application.ports.in.ProcesarPedidoUseCase;
import com.micro.inventario.domain.entities.ItemPedido;
import com.micro.inventario.domain.entities.Pedido;
import com.micro.inventario.infrastructure.adapters.in.dto.PedidoRequest;
import com.micro.inventario.infrastructure.adapters.in.dto.PedidoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final ProcesarPedidoUseCase procesarPedidoUseCase;

    public PedidoController(ProcesarPedidoUseCase procesarPedidoUseCase) {
        this.procesarPedidoUseCase = procesarPedidoUseCase;
    }

    @PostMapping("/procesar")
    public ResponseEntity<PedidoResponse> procesarPedido(@RequestBody PedidoRequest pedidoRequest) {
        List<ItemPedido> items = pedidoRequest.getItems().stream()
                .map(item -> new ItemPedido(Long.valueOf(item.getIdProducto()), item.getCantidad()))
                .collect(Collectors.toList());

        Pedido pedido = new Pedido(null, items);

        boolean processado = procesarPedidoUseCase.procesarPedido(pedido);

        if (processado) {
            return ResponseEntity.ok(new PedidoResponse(pedido.getId(), "Pedido procesado correctamente"));
        } else {
            return ResponseEntity.badRequest().body(new PedidoResponse(null, "Inventario insuficiente"));
        }

    }
}
