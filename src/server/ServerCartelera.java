package server;

import classes.Client;
import classes.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Created by Klincaja on 21/10/16.
 */
public class ServerCartelera extends Server implements Runnable {

    public ServerCartelera(int port) {
        super(port);
        startServer();
    }


    @Override
    public void sendAll() {
        for (Client c : this.getClients()) {
            //c.sendMessage();
        }
    }

    @Override
    public void startServer() {
        setThreadServer(new Thread(this));
        getThreadServer().start();
    }

    @Override
    public void run() {
        try{
            while(isConnectedServer()){
                setSocket(this.getServerSocket().accept());
                setObjectOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
                setObjectInputStream(new ObjectInputStream(getSocket().getInputStream()));
                getClients().add(new ClientesCartelera(getObjectOutputStream(),getObjectInputStream()));
            }
        }catch(IOException ex){
            System.out.println("Ocurrio un problema al intentar recibir un nuevo cliente [Class LobbyServer] Linea 37\n"+ex.getMessage());
            setPackageDataError(getPackageDataError()+1);

        }
    }
}
