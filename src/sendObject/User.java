package sendObject;

import java.io.Serializable;

/**
 * Created by Klincaja on 21/10/16.
 */
public class User implements Serializable{


    private String usuario;
    private String password;
    private String email;


    public User(String usuario, String password, String email) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString(){
        return "Usuario:"+usuario+"\n"+"Email:"+email;
    }
}
