package com.micro.inventario.domain.entities;

import java.util.HashMap;
import java.util.List;

public class Receta {
    private Long id;
    private String nombre;
    private HashMap<Ingrediente, Integer> ingredientes;

    public Receta(Long id, String nombre, HashMap<Ingrediente, Integer> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
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

    public HashMap<Ingrediente, Integer> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashMap<Ingrediente, Integer> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
