package main.classes;

import main.cartelera.Cartelera;

import java.util.ArrayList;

/**
 * Created by Klincaja on 23/10/16.
 */
public class SingletonClass {



    private ArrayList<Cartelera> carteleraArrayList;
    private static SingletonClass ourInstance = new SingletonClass();

    public static SingletonClass getInstance() {
        return ourInstance;
    }


    private SingletonClass() {
        carteleraArrayList = new ArrayList<Cartelera>();
    }

    public ArrayList<Cartelera> getCarteleraArrayList(){
        return carteleraArrayList;
    }
}
