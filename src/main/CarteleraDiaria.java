package main;

import main.cartelera.Aula;
import main.cartelera.Cartelera;
import main.classes.*;
import main.server.ServerCartelera;


/**
 * Created by kaotiks on 08/08/16.
 */

public class CarteleraDiaria {

    private static String[] sedes = {"Sarmiento","Rivadavia","Monteagudo","Ecana","Inta"};

    public static void main(String [ ] args){
        Cartelera sarmiento = new Cartelera("sarmiento");
        SingletonClass.getInstance().getCarteleraArrayList().add(sarmiento);
        ServerCartelera sr = new ServerCartelera();
    }

    public void updateResources(){
        // Que pensas hacer aca (?

    }
}
