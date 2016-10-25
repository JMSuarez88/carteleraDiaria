package finales;

import classes.HttpScraping;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Klincaja on 25/10/16.
 */
public class ScrapingFinalesMesa {
    public static String URL = "https://g3w.unnoba.edu.ar/g3w2/fecha_examen?formulario_filtro[carrera]=&formulario_filtro[plan]=&formulario_filtro[materia]=&formulario_filtro[fecha_desde]=&formulario_filtro[fecha_hasta]=&formulario_filtro[tipo_mesa]=";

    public static String getMesasFinales(){
        // Compruebo si me da un 200 al hacer la petición
        if (HttpScraping.getStatusConnectionCode(URL) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = HttpScraping.getHtmlDocument(URL);

            // Busco todas las historias de meneame que estan dentro de:
            Elements entradas = document.select("div");
            System.out.println("Número de entradas en la página inicial de Jarroba: "+entradas.size()+"\n");

            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                String titulo = elem.getElementsByClass("span12").text();


                System.out.println(titulo);

                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }

        }else {
            System.out.println("El Status Code no es OK es: " + HttpScraping.getStatusConnectionCode(URL));
        }
        return "";
    }
}
