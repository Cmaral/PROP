package Dominio;

/**
 * Created by Paola on 27/10/2016.
 */

public class Usuario {
    private String usuario = "";
    private String password = "";


    //constructor
    public Usuario(String u, String p) {
        this.usuario = u;
        this.password = p;

    }

    public Usuario() {}


    public String getUsuario() {
        return this.usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsuario(String umodificat) {
        this.usuario = umodificat;
    }

    public void setPassword(String pmodificat) {
        this.password = pmodificat;
    }


}
