package main.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Klincaja on 21/10/16.
 */
public class ServerCartelera implements Runnable {

    private String lastUpdate;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private ServerSocket serverSocket;
    private Socket socket;

    private boolean connectedServer;

    private ArrayList<ClientesCartelera> clients;

    private Thread threadServer;

    public ServerCartelera(){
        connectedServer = true;
        clients = new ArrayList<ClientesCartelera>();
        threadServer = new Thread(this);
        threadServer.start();
    }


    public void closeServer(){
        try {
            this.getObjectInputStream().close();
            this.getObjectOutputStream().close();
            this.connectedServer = false;
            this.threadServer.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            while(isConnectedServer()){
                setSocket(this.getServerSocket().accept());
                setObjectOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
                setObjectInputStream(new ObjectInputStream(getSocket().getInputStream()));
                clients.add(new ClientesCartelera(this.getObjectOutputStream(),this.getObjectInputStream()));
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public boolean isConnectedServer() {
        return connectedServer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
