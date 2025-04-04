package com.micro.inventario.domain.entities;

public class Producto {
    private Long id;
    private String nombre;
    private Receta receta;

    public Producto(String nombre, Long id, Receta receta) {
        this.nombre = nombre;
        this.id = id;
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
