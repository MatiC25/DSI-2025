package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Test de Inscripcion aprobada con materia con correlativa aledaña")

    void testInscripcionRechazada() {
        Materia sypn = new Materia("Sistemas y Procesos");
        Materia lyed = new Materia("Lenguajes y Estructuras de Datos");
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
        Materia ingles1 = new Materia("Ingles 1");

        Materia pdp = new Materia("Paradigmas", List.of(lyed, ayed));
        Materia asi = new Materia("Analisis de sistemas", List.of(sypn, ayed));

        Materia diseño = new Materia("Diseño", List.of(asi, pdp, ingles1, ayed, sypn));

        Alumno alumno = new Alumno("Matías", "Cao", 666 , "Ingeniería en sistemas", List.of(asi, ingles1, ayed, sypn));

        Inscripcion inscripcion2024 = new Inscripcion();

        Assertions.assertFalse(inscripcion2024.aprobada(alumno, diseño));
    }
@Test
@DisplayName("Test Inscripcion aceptada con una sola materia")
    void testInscripcionAceptada(){
        Materia sypn = new Materia("Sistemas y Procesos");
        Materia lyed = new Materia("Lenguajes y Estructuras de Datos");
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
        Materia ingles1 = new Materia("Ingles 1");

        Materia pdp = new Materia("Paradigmas", List.of(lyed, ayed));
        Materia asi = new Materia("Analisis de sistemas", List.of(sypn, ayed));

        Materia diseño = new Materia("Diseño", List.of(asi, pdp, ingles1, ayed, sypn));

        Alumno alumno = new Alumno("Matías", "Cao", 666 , "Ingeniería en sistemas", List.of(asi, pdp, ingles1, ayed, sypn));

        Inscripcion inscripcion2024 = new Inscripcion();

        Assertions.assertTrue(inscripcion2024.aprobada(alumno, diseño));

    }
    @Test
    @DisplayName("Test Inscripcion aceptada con varias materias")
    void testInscripcionAceptadaVariasMaterias(){
        Materia sypn = new Materia("Sistemas y Procesos");
        Materia lyed = new Materia("Lenguajes y Estructuras de Datos");
        Materia ayed = new Materia("Algoritmos y Estructuras de Datos");
        Materia ingles1 = new Materia("Ingles 1");

        Materia pdp = new Materia("Paradigmas", List.of(lyed, ayed));
        Materia asi = new Materia("Analisis de sistemas", List.of(sypn, ayed));

        Materia diseño = new Materia("Diseño", List.of(asi, pdp, ingles1, ayed, sypn));
        Materia ingles2 = new Materia("Ingles 2", List.of(ingles1));
        Materia fisica1 = new Materia("Fisica 1");


        Alumno alumno = new Alumno("Matías", "Cao", 666 , "Ingeniería en sistemas", List.of(asi, pdp, ingles1, ayed, sypn));

        Inscripcion inscripcion2024 = new Inscripcion();

        Assertions.assertTrue(inscripcion2024.aprobada(alumno, diseño, ingles2, fisica1));

    }

}