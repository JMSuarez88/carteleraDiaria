package sendObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kaotiks on 10/08/16.
 */
public class Carrera implements Serializable {

    // Variables
    private String nombre;
    private ArrayList<MateriaCarrera> materiaArrayList;


    public Carrera(String nombre) {
        materiaArrayList = new ArrayList<MateriaCarrera>();
        this.nombre = nombre;
    }

    public ArrayList<MateriaCarrera> getMateriaArrayList(){
        return materiaArrayList;
    }

}
