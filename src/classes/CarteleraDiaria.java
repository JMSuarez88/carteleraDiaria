package classes;



import cartelera.*;
import server.ServerCartelera;


/**
 * Created by kaotiks on 08/08/16.
 */

public class CarteleraDiaria {

    private static String[] sedes = {"Sarmiento","Rivadavia","Monteagudo","Ecana","Inta"};

    public static void main(String [ ] args){
        Cartelera sarmiento = new Cartelera("sarmiento");
        SingletonClass.getInstance().getCarteleraArrayList().add(sarmiento);
        //Seteamos las carreras cargadas hardcore
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearANALISTAENSISTEMAS());
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearINGENIERIAENINFORMATICA());
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearLICINFORMATICO());

        ServerCartelera sr = new ServerCartelera(4040);
    }

    public void updateResources(){

    }
}
