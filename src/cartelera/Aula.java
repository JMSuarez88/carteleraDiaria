package cartelera;

import java.util.ArrayList;

/**
 * Created by Klincaja on 21/10/16.
 */
public class Aula {

    private String numero;
    private ArrayList<ClaseAula> claseAulas;

    public Aula(String numero) {
        this.numero = numero;
        setClaseAulas(new ArrayList<ClaseAula>());
    }

    public ArrayList<ClaseAula> getClaseAulas() {
        return claseAulas;
    }

    public void setClaseAulas(ArrayList<ClaseAula> claseAulas) {
        this.claseAulas = claseAulas;
    }
    @Override
    public String toString(){
        String aux = "";
        for (ClaseAula claseAula :claseAulas) {
            aux = aux + claseAula.toString() +"\n";
        }
        return  "Aula:"+numero+"\n"
                +aux;
    }
}
