package org.example;

import java.util.Collection;
import java.util.List;

public class Materia {

    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = List.of();
    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativa(Materia ... correlativa) {
        this.correlativas.addAll(List.of(correlativa));
    }
}
