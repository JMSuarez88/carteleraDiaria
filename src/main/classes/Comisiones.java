package main.classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaotiks on 24/08/2016.
 */
public class Comisiones {
    private String filePath = "C:\\Users\\kaotiks\\workspace\\sata\\CarteleraDiaria\\src\\main\\resources\\prueba.pdf";
    private PdfManager pdfManager = new PdfManager();
    private Map<String,String> materias = new HashMap<>();

    public Comisiones() {
        this.materias = pdfManager.analizePdfComisiones(filePath);
    }

    static void uploadComisiones(){

    }
}
