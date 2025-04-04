package com.micro.inventario.domain.entities;

public class Ingrediente {
    private Long id;
    private String nombre;
    private String unidad;
    private Integer cantidadDisponible;

    public Ingrediente(Long id, String nombre, String unidad, Integer cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidadDisponible = cantidadDisponible;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}
