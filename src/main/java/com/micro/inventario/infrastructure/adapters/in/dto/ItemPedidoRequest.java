package com.micro.inventario.infrastructure.adapters.in.dto;

public class ItemPedidoRequest {
    private String idProducto;
    private int cantidad;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
