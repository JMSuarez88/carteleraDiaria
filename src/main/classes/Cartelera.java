package main.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaotiks on 08/08/16.
 */

public class Cartelera {

    // Variables
    private String nombreSede;
    private String ciudad;
    private Map<Integer,Map<String,String>> aulas = new HashMap<>();
    private PdfManager pdfManager = new PdfManager();
    private Date fechaActual;
    // todo: fechaAnterior = ultima fecha usada (db)
    private Date fechaAnterior;

    // Constructor
    public Cartelera(String name) {
        this.nombreSede = name;
        this.setNombreCiudad();
        this.setAulasFromPdf();
        this.fechaActual = new Date();
    }

    // Getters
    public String getNombreSede() {return nombreSede;}
    public String getCiudad() {return ciudad;}
    public Map<Integer, Map<String, String>> getAulas() {return aulas;}

    // Setters
    public void setNombreSede(String nombreSede) {this.nombreSede = nombreSede;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public void setAulas(Map<Integer, Map<String, String>> aulas) {this.aulas = aulas;}

    // Métodos
    // Asigna la ciudad segun el nombre de la sede
    public void setNombreCiudad(){
        if(this.nombreSede.equals("Sarmiento") || this.nombreSede.equals("Rivadavia")){
            this.ciudad = "Junin";
        } else {
            this.ciudad = "Pergmino";
        }
    }
    // Recopila los datos de las carteleras en PDF y asigna cada aula con sus cursadas
    public void setAulasFromPdf(){
        // todo: esto no esta guardando ningun valor, falta agregar el resto
        this.pdfManager.gatherData(this.nombreSede,"27082016");
        //Map<Integer, Map<String, String>> aux = this.pdfManager.gatherData(this.nombreSede);
        //this.setAulas(aux);
    }

    public String getFecha(){
        DateFormat completeDate = new SimpleDateFormat("ddMMyyyy");

        if(compareDates(fechaAnterior,fechaActual)){
            return completeDate.format(fechaActual);
        } else {
            return completeDate.format(fechaAnterior);
        }
    }

    public Boolean compareDates(Date current, Date newDate){
        DateFormat day = new SimpleDateFormat("dd");
        DateFormat month = new SimpleDateFormat("MM");
        DateFormat year = new SimpleDateFormat("yyyy");

        // todo: si newDate.month < currentDate.month ??? NO DEBERIA PASAR NUNCA, PEEEERO
        if(Integer.valueOf(year.format(newDate)) > Integer.valueOf(year.format(current))) {
            return true;
        } else {
            if(Integer.valueOf(month.format(newDate)) > Integer.valueOf(month.format(current))){
                return true;
            } else {
                if(Integer.valueOf(day.format(newDate)) > Integer.valueOf(day.format(current))){
                    return true;
                }
            }
        }

        return false;
    }
}
