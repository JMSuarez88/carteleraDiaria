package sendObject;

import java.io.Serializable;

/**
 * Created by Klincaja on 22/10/16.
 */
public class MateriaCarrera implements Serializable {



    private String nameID;
    private String name;

    public MateriaCarrera(String name,String nameID){
        this.name = name;
        this.nameID = nameID;
    }
}
