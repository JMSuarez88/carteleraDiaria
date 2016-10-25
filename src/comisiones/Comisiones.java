package comisiones;

import classes.PdfManager;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kaotiks on 24/08/2016.
 */
public class Comisiones {
    private File file ;
    //--- Linea obsoleta busca desde raiz
    //private String filePath = "C:\\Dropbox\\SATA\\carteleraDiaria-master\\carteleraDiaria-master\\src\\main\\resources\\prueba.pdf";
    //--------------------------------------
    private PdfManager pdfManager = new PdfManager();
    private ArrayList<Materia> materiaArrayList;

    public Comisiones() {

        //Busca el archivo desde el proyecto mismo no importa la Raiz
        URL url = this.getClass().getResource("/main/resources/prueba.pdf");
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        materiaArrayList = pdfManager.analizePdfComisiones(file);

    }

    static void uploadComisiones(){

    }

    public ArrayList<Materia> getMateriaArrayList() {
        return materiaArrayList;
    }

}
