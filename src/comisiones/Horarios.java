package comisiones;

/**
 * Created by Klincaja on 21/10/16.
 */
public class Horarios {
    private String comision ;
    private String horario ;
    private String dia ;
    private String modalidad ;
    private String profesores ;
    private String tipocursada ;




    public Horarios(String comision, String horario, String dia, String modalidad, String profesores, String tipocursada) {
        this.comision = comision;
        this.horario = horario;
        this.dia = dia;
        this.modalidad = modalidad;
        this.profesores = profesores;
        this.tipocursada = tipocursada;
    }
    @Override
    public String toString(){
        return "Comision:"+comision+"\n"
                +"Dia:"+dia+"\n"
                +"Hora:"+horario+"\n"
                +"Tipo:"+tipocursada+"\n"
                +"Modalidad:"+modalidad+"\n"
                +"Profesores:"+profesores;
    }
}
