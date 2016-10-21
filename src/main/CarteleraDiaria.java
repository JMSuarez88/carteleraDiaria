package main;

import main.classes.Cartelera;
import main.classes.Comisiones;
import main.classes.PdfManager;

/**
 * Created by kaotiks on 08/08/16.
 */

public class CarteleraDiaria {
    private static String[] sedes = {"Sarmiento","Rivadavia","Monteagudo","Ecana","Inta"};
    static PdfManager pdfManager = new PdfManager();

    public static void main(String [ ] args){
        Cartelera sarmiento = new Cartelera("sarmiento");
        //Comisiones comisiones = new Comisiones();
    }

    public void updateResources(){

    }
}
