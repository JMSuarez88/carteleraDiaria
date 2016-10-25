package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kaotiks on 11/08/16.
 */

public class FileHandler {
    private String path = "http://www.unnoba.edu.ar/cursadas/archivo/";
    public void downloadFile(String sede){

        //return file;
    }

    // todo: No se si trabajar la fecha desde aca ¡?¡?¡?
    /*public String getFecha(){
        DateFormat completeDate = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();

        if(compareDates(currentDate,date)){
            return completeDate.format(date);
        } else {
            return completeDate.format(currentDate);
        }
    }*/

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
