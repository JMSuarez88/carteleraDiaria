package classes;

import cartelera.Cartelera;
import com.kaotiks.cartelera.sendObject.Carrera;

import java.util.ArrayList;

/**
 * Created by Klincaja on 23/10/16.
 */
public class SingletonClass {



    private ArrayList<Cartelera> carteleraArrayList;
    private ArrayList<Carrera> carreraArrayList;
    private double versionData = 1.00;
    private static SingletonClass ourInstance = new SingletonClass();

    public static SingletonClass getInstance() {
        return ourInstance;
    }


    private SingletonClass() {
        carteleraArrayList = new ArrayList<Cartelera>();
        carreraArrayList = new ArrayList<Carrera>();
    }

    public ArrayList<Cartelera> getCarteleraArrayList(){
        return carteleraArrayList;
    }

    public double getVersionData() {
        return versionData;
    }

    public void setVersionData(double versionData) {
        this.versionData = versionData;
    }

    public ArrayList<Carrera> getCarreraArrayList() {
        return carreraArrayList;
    }

    public void setCarreraArrayList(ArrayList<Carrera> carreraArrayList) {
        this.carreraArrayList = carreraArrayList;
    }
}
