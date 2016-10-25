package com.kaotiks.cartelera.sendObject;

import java.io.Serializable;

/**
 * Created by Klincaja on 23/10/16.
 */
public class Cursadas implements Serializable {
    private static final long serialVersionUID = -6374678792440967465L;

    private String aula;
    private String nombre;
    private String horario;

    public Cursadas(String aula, String nombre, String horario) {
        this.aula = aula;
        this.nombre = nombre;
        this.horario = horario;
    }
}
