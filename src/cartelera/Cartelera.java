package cartelera;

import classes.PdfManager;
import classes.SingletonClass;
import org.apache.pdfbox.pdfparser.PDFParser;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kaotiks on 08/08/16.
 * Updates by Klincaja on 29/10/16
 */

public class Cartelera {

    // Variables
    private String nombreSede;
    private String ciudad;
    private String institucion;
    private ArrayList<Aula> aulaArrayList;
    private PdfManager pdfManager = new PdfManager();
    private PDFParser parser;
    private boolean existCartelera;  // Existe Cartelera V - F
    // Constructor
    public Cartelera(String name,File file) {
        try{
            parser = new PDFParser(new FileInputStream(file));
            parser.parse();
            existCartelera = true;
        }catch (Exception e){
            existCartelera = false;
        }
        if(existCartelera) {
            pdfManager.setFile(file);
            setAulaArrayList(new ArrayList<Aula>());
            this.nombreSede = name;
            this.setNombreCiudad();
            this.setAulasFromPdf();
        }
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
        if(this.nombreSede.equals("anexo") || this.nombreSede.equals("evaperon")){
            this.ciudad = "Junin";
        } else {
            this.ciudad = "Pergmino";
        }
    }
    // Recopila los datos de las carteleras en PDF y asigna cada aula con sus cursadas
    public void setAulasFromPdf(){
        aulaArrayList.clear();
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyyyy");
        String currentTime = sdf.format(dt);

        for (Map.Entry<String, String> entry : this.pdfManager.getAnalizedData(this.institucion,currentTime).entrySet())
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
    }


    public ArrayList<Aula> getAulaArrayList() {
        return aulaArrayList;
    }

    public void setAulaArrayList(ArrayList<Aula> aulaArrayList) {
        this.aulaArrayList = aulaArrayList;
    }
    @Override
    public String toString(){
        String aulas = "";
        for (Aula aula:this.aulaArrayList) {
            aulas = aulas+aula.toString();
        }
        return "Ciudad:"+this.ciudad+"\n"
                +"Sede:"+this.nombreSede+"\n"
                +"Aulas:"+aulas;
    }
}
