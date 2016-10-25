package classes;

import com.kaotiks.cartelera.sendObject.User;
import databaseConnection.ConnectionDB;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klincaja
 */
public abstract class Client {
    
    private ConnectionDB connectionDB;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInpuStream;
    private boolean Connected = false;  
    private Thread thread;
    private User user;
    private int packageDataError = 0;
    
    
    public Client(ObjectOutputStream oos, ObjectInputStream ois){
        this.objectOutputStream = oos;
        this.objectInpuStream = ois;
        this.Connected = true;
        this.connectionDB = ConnectionDB.getInstance();
    }

    public void closeClient(){
        try {
            this.Connected = false;
            this.objectOutputStream.close();
            this.objectInpuStream.close();
            this.thread.join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            System.out.println("El usuario:"+user.toString()+" se ha desconectado \n"
            +"Package Data Error:"+this.getPackageDataError());
        }
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInpuStream;
    }

    public boolean isConnected() {
        return Connected;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
    
    public ConnectionDB getConnectionBD() {
        return connectionDB;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public abstract void commandosListener(Object o);
    public abstract void sendMessage(Object o);

    public int getPackageDataError() {
        return packageDataError;
    }

    public void setPackageDataError(int packageDataError) {
        this.packageDataError = packageDataError;
    }

}
