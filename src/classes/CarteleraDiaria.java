package classes;



import cartelera.*;
import comisiones.Comisiones;
import comisiones.Materia;
import databaseConnection.ConnectionDB;
import jdk.nashorn.api.scripting.JSObject;
import server.ServerCartelera;

import java.util.ArrayList;


/**
 * Created by kaotiks on 08/08/16.
 */

public class CarteleraDiaria {

    private static String[] sedes = {"Sarmiento","Rivadavia","Monteagudo","Ecana","Inta"};

    public static void main(String [ ] args){
        /*Cartelera sarmiento = new Cartelera("sarmiento");
        SingletonClass.getInstance().getCarteleraArrayList().add(sarmiento);
        //Seteamos las carreras cargadas hardcore
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearANALISTAENSISTEMAS());
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearINGENIERIAENINFORMATICA());
        SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearLICINFORMATICO());

        ServerCartelera sr = new ServerCartelera(4040);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);*/
        ArrayList<String> json = new ArrayList<String>();
        json.add("Hola");
        json.add("chau");
        json.add("Temprano");

        System.out.println(Transform.getToStringArray(json));

        Transform.getArrayListToString(Transform.getToStringArray(json)).forEach(System.out::println);




        // --CARGA DE MATERIAS A BASE DE DATOS DESDE EL PDF DE SEGUNDO CUATRIMESTRE
        /*Comisiones comisiones = new Comisiones();
        ArrayList<String> json = new ArrayList<String>();
        ArrayList<Materia> materias = new ArrayList<Materia>();
        boolean f = true;
        for (Materia m:comisiones.getMateriaArrayList()) {
            for (Materia mm:materias) {
                if(m.getCodigo() == mm.getCodigo()) {
                    f = false;
                    break;
                }
                f = true;
            }
            if(f) {
                materias.add(m);
                ConnectionDB.getInstance().crearMateria(m.getName(), m.getCodigo(), json);
            }
        }
            */
    }

    public void updateResources(){

    }
}
