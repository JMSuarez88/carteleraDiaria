package main.cartelera;

/**
 * Created by Klincaja on 21/10/16.
 */
public class ClaseAula {
    private String nombreMateria;
    private String horario;

    public ClaseAula(String nombreMateria, String horario) {
        this.nombreMateria = nombreMateria;
        this.horario = horario;
    }
    @Override
    public String toString(){
        return "Materia:"+nombreMateria+"\n"
                +"Horario:"+horario;
    }
}
