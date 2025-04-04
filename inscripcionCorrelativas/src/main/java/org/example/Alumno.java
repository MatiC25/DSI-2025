package org.example;

import java.util.List;


public class Alumno {


    private String nombre;
    private String apellido;
    private Integer legajo;
    private String especialidad;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Integer legajo, String especialidad, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.especialidad = especialidad;
        this.materiasAprobadas = materiasAprobadas;
    }

    //private List<Materia> materiasRegularizadas; Para luego implementar si es necesario

    // Saber si una materia está aprobada o no
    public Boolean estaAprobado(Materia materia){
        return this.materiasAprobadas.contains(materia);
    }

    // Consideramos que un alumno ya curso una materia cuando la regularizó o la aprobó
    public Boolean yaLaCurso(Materia materia){
        return this.estaAprobado(materia); // || this.materiasRegularizadas.contains(materia);
    }

    public Boolean yaLasCurso(List<Materia> materias){
        return materias.stream().allMatch(this::yaLaCurso);
    }

    public Boolean tieneCorrelativas(Materia materia){
        return this.materiasAprobadas.containsAll(materia.getCorrelativas());
    }

    public Boolean tieneTodasCorrelativas(List<Materia> materias){
        return materias.stream().allMatch(this::tieneCorrelativas); // m -> this.tieneCorrelativas(m)
    }

}
