package classes;

import cartelera.Cartelera;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Klincaja on 27/10/16.
 * clase automatiza los update de datos de las carteleras
 * y los almacena en la "Memoria local(RAM)" de el servidor hasta que sean remplazados por un nuevo update
 * tambien el archivo pdf almacenado en C:/pdfcartelera/
 */
public class UpdateAutomatic implements Runnable{


    private int timeUpdate;
    private int hour = 0;
    private int minutes = 0;
    private Timer timer ;
    private TimerTask task;
    private FileHandler fileHandler;
    private PdfManager manager;
    /**
     @param timeUpdate Es el tiempo que queres que refresque los datos el update
     */
    public UpdateAutomatic(int timeUpdate){
        this.timeUpdate = timeUpdate;
        fileHandler = new FileHandler();
        manager = new PdfManager();
    }

    public void startUpdateAutomatic(){
        for (int i = 0; i<CarteleraDiaria.INSTITUCIONES.length;i++) {
            try {
                File file = fileHandler.downloadFile(CarteleraDiaria.INSTITUCIONES[i], SingletonClass.getInstance().getLocalTime(), CarteleraDiaria.INSTITUCIONES[i]);
                Cartelera cartelera = new Cartelera(CarteleraDiaria.INSTITUCIONES[i], file );
                SingletonClass.getInstance().getCarteleraArrayList().add(cartelera);
            }catch (Exception e){
                System.out.println("Error en sede:"+CarteleraDiaria.INSTITUCIONES[i]);
            }
        }
        System.out.println("Termino");
        timer = new Timer();
        task = new TimerTask() {
            // tic es el contador de segundos
            int tic = 0;

            @Override
            public void run()
            {
                tic++;
                if(tic == 60){
                    tic = 0;
                    minutes++;
                }
                if(minutes==60){
                    minutes=0;
                    //Date dt = new Date();
                    //SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                    //SingletonClass.getInstance().setLocalTime(sdf.format(dt));
                    hour++;
                }
                if(hour==timeUpdate){
                    //Thread update = new Thread(this);
                    //update.start();
                    hour = 0;
                }
            }

        };
        timer.schedule(task, 0, 1000);

    }

    public void forceUpdate(){
        String institucion = "";
        for(int i = 0; i<CarteleraDiaria.INSTITUCIONES.length; i++){
            institucion = CarteleraDiaria.INSTITUCIONES[i];

        }
    }

    @Override
    public void run() {

    }
}
