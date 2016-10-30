package classes;



import cartelera.Cartelera;
import org.apache.pdfbox.pdfparser.PDFParser;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by kaotiks on 08/08/16.
 */

public class CarteleraDiaria {

    // TODAS LAS SEDES POSIBLES----------------
    private static String SARMIENTO = "evaperon";
    private static String RIVADAVIA = "anexo";
    private static String MONTEAGUDO = "monteagudo";
    private static String ECANA = "ecana";
    private static String INTA = "inta";
    public static String [] INSTITUCIONES = {SARMIENTO,RIVADAVIA};
    //-----------------------------------------

    public static void main(String [ ] args){


        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        SingletonClass.getInstance().setLocalTime(sdf.format(dt));

        UpdateAutomatic updateAutomatic = new UpdateAutomatic(8);
        updateAutomatic.startUpdateAutomatic();
        System.out.println("QE HAGO ACA");
        for (Cartelera cartelera:SingletonClass.getInstance().getCarteleraArrayList()) {
            System.out.println("QE HAGO ACA2");

            System.out.println(cartelera.toString());
        }

        // POLYMER - FIREBASE ANOTADOR CAMPUS PARTY

        /*FileHandler fileHandler = new FileHandler();
        PDFParser parser;
        try{
            parser = new PDFParser(new FileInputStream(fileHandler.downloadFile("anexo","28102016","anexo")));
            parser.parse();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        //Cartelera sarmiento = new Cartelera("sarmiento");
        //SingletonClass.getInstance().getCarteleraArrayList().add(sarmiento);

        //Seteamos las carreras cargadas hardcore
        //SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearANALISTAENSISTEMAS());
        //SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearINGENIERIAENINFORMATICA());
        //SingletonClass.getInstance().getCarreraArrayList().add(CreadorCarreras.CrearLICINFORMATICO());

        //ServerCartelera sr = new ServerCartelera(4040);



        // FORMATO OBTENER HORA O FECHA TO STRING




        // --CARGA DE MATERIAS A BASE DE DATOS DESDE EL PDF DE SEGUNDO CUATRIMESTRE
        /*Comisiones comisiones = new Comisiones();
        ArrayList<String> json = new ArrayList<String>();
        ArrayList<Materia> materias = new ArrayList<Materia>();
        boolean f = true;
        for (Materia m:comisiones.getMateriaArrayList()) {
            for (Materia mm:materias) {
                if(m.getCodigo() == mm.getCodigo()) {
                    f = false;
                    break;
                }
                f = true;
            }
            if(f) {
                materias.add(m);
                ConnectionDB.getInstance().crearMateria(m.getName(), m.getCodigo(), json);
            }
        }
            */
    }

}
