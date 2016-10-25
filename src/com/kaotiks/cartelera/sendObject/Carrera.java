package com.kaotiks.cartelera.sendObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kaotiks on 10/08/16.
 */
public class Carrera implements Serializable {

    private static final long serialVersionUID = -6374678792440967465L;

    // Variables
    private String sede;
    private String nombre;
    private ArrayList<MateriaCarrera> materiaArrayList;


    public Carrera(String nombre,String sede) {
        materiaArrayList = new ArrayList<MateriaCarrera>();
        this.nombre = nombre;
        this.sede = sede;
    }

    public ArrayList<MateriaCarrera> getMateriaArrayList(){
        return materiaArrayList;
    }



    @Override
    public String toString(){
        return "Nombre:"+nombre+"\n"+sede;
    }

    public String getSede() {
        return sede;
    }
    public String getName(){
        return nombre;
    }
}
