package com.kaotiks.cartelera.sendObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Klincaja on 22/10/16.
 * Clase que maneja todos los datos que se envian la accion se evalua atravez de el IDMESSAGE
 */
public class PackageData implements Serializable {

    //Variables
    private final int IDMESSAGE;
    private double versionDatos;
    private User user; // Datos del usuario
    private ArrayList<Carrera> carreraArrayList; // Todas las carreras con sus respectivas materias
    private ArrayList<MateriaCarrera> cursadas; // Materias a la cual el usuario esta cursando
    private ArrayList<Cursadas> cursadasArrayList; // Cursadas con N° Aula y Horario dependiendo de lo que haya elegido el usuario

    //Constructor
    public PackageData(int IDMESSAGE) {
        this.IDMESSAGE = IDMESSAGE;
    }


    public PackageData(int IDMESSAGE,ArrayList<MateriaCarrera> cursadas ){
        this.IDMESSAGE = IDMESSAGE;
        this.cursadas = cursadas;
    }
    public PackageData(int IDMESSAGE, ArrayList<Carrera> carreraArrayListrrera, double versionDatos ){
        this.IDMESSAGE = IDMESSAGE;
        this.carreraArrayList = carreraArrayListrrera;
        this.versionDatos = versionDatos;
    }


    //Getters & Setters
    public int getIDMESSAGE(){
        return IDMESSAGE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Carrera> getCarreraArrayList() {
        return carreraArrayList;
    }

    public void setCarreraArrayList(ArrayList<Carrera> carreraArrayList) {
        this.carreraArrayList = carreraArrayList;
    }

    public ArrayList<MateriaCarrera> getCursadas() {
        return cursadas;
    }

    public void setCursadas(ArrayList<MateriaCarrera> cursadas) {
        this.cursadas = cursadas;
    }

    public ArrayList<Cursadas> getCursadasArrayList() {
        return cursadasArrayList;
    }

    public void setCursadasArrayList(ArrayList<Cursadas> cursadasArrayList) {
        this.cursadasArrayList = cursadasArrayList;
    }

    public double getVersionDatos() {
        return versionDatos;
    }

    public void setVersionDatos(int versionDatos) {
        this.versionDatos = versionDatos;
    }
}
