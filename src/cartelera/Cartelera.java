package cartelera;

import classes.PdfManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kaotiks on 08/08/16.
 */

public class Cartelera {

    // Variables
    private String nombreSede;
    private String ciudad;
    private ArrayList<Aula> aulaArrayList;
    private PdfManager pdfManager = new PdfManager();
    private Date fechaActual;
    // todo: fechaAnterior = ultima fecha usada (db)
    private Date fechaAnterior;

    // Constructor
    public Cartelera(String name) {
        setAulaArrayList(new ArrayList<Aula>());
        this.nombreSede = name;
        this.setNombreCiudad();
        this.setAulasFromPdf();
        this.fechaActual = new Date();
    }

    // Getters
    public String getNombreSede() {return nombreSede;}
    public String getCiudad() {return ciudad;}

    // Setters
    public void setNombreSede(String nombreSede) {this.nombreSede = nombreSede;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

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

        for (Map.Entry<String, String> entry : this.pdfManager.gatherData(this.nombreSede,"29082016").entrySet())
        {
            if(entry.getKey().length()>entry.getValue().length()){
                continue;
            }else{
                Aula aula = new Aula(entry.getKey().substring(0,3));
                String aux = entry.getValue();
                String materia = "";
                String horario = "";
                while(aux.length()!=0) {
                    try {
                        materia = aux.substring(0, aux.indexOf(':') - 3);
                        if (aux.indexOf("0 ") != -1) {
                            horario = aux.substring(aux.indexOf(':') - 3, aux.indexOf(" a ") + 8);
                            aux = aux.substring(aux.indexOf(" a ") + 8, aux.length());
                        } else {
                            horario = aux.substring(aux.indexOf(':') - 3, aux.lastIndexOf('0') + 1);
                        }
                        aula.getClaseAulas().add(new ClaseAula(materia, horario));
                    } catch (Exception e) {
                        break;
                    }
                }
                aulaArrayList.add(aula);

            }
        }
        //Map<Integer, Map<String, String>> aux = this.pdfManager.gatherData(this.nombreSede,"27082016");
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

    public ArrayList<Aula> getAulaArrayList() {
        return aulaArrayList;
    }

    public void setAulaArrayList(ArrayList<Aula> aulaArrayList) {
        this.aulaArrayList = aulaArrayList;
    }
}
