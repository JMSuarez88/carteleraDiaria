package server;

import classes.Client;
import classes.SingletonClass;
import com.kaotiks.cartelera.sendObject.PackageData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Klincaja on 23/10/16.
 */
public class ClientesCartelera extends Client implements Runnable {



    public ClientesCartelera(ObjectOutputStream oos, ObjectInputStream ois) {
        super(oos, ois);
        initComponents();
    }

    private void initComponents() {
        this.setThread(new Thread(this));
        this.getThread().start();
    }

    @Override
    public void commandosListener(Object o) {
        PackageData packageData = (PackageData)o;
        switch (packageData.getIDMESSAGE()){
            case 0:
                this.sendMessage(new PackageData(0));
                // Test case
                break;
            case 1:
                this.sendMessage(new PackageData(1, SingletonClass.getInstance().getCarreraArrayList(),SingletonClass.getInstance().getVersionData()));
                break;
            case 2:
                if(packageData.getVersionDatos()==SingletonClass.getInstance().getVersionData()){
                    this.sendMessage(new PackageData(2));
                }else{
                    this.sendMessage(new PackageData(3,SingletonClass.getInstance().getCarreraArrayList(),SingletonClass.getInstance().getVersionData()));
                }
                break;
            case 3:

                break;
            case 4:
                break;
        }
    }

    @Override
    public void sendMessage(Object o) {
        try {
            this.getObjectOutputStream().writeObject(o);
            this.getObjectOutputStream().reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isConnected()){
            try {
                commandosListener(this.getObjectInputStream().readObject());
            } catch (IOException | ClassNotFoundException e) {
                this.setPackageDataError(this.getPackageDataError()+1);
            }
            if(this.getPackageDataError()==10){
                break;
            }
        }
    }
}
