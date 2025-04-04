package org.example;


import java.util.List;

public class Inscripcion {


    public Boolean aprobada(Alumno alumno, Materia ... materia){

        //Verificar si la materia enviada existe en el plan, en caso de ser necesario, podrías saltar un excepcion

        return alumno.tieneTodasCorrelativas(List.of(materia)) && !alumno.yaLasCurso(List.of(materia));
    }


}