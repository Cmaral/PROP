package Dominio;


import java.util.*;

public class ConjuntoUsuarios {
    public TreeMap<Usuario, Boolean> conjuntousers;

    public ConjuntoUsuarios() {
        this.conjuntousers = new TreeMap<Usuario, Boolean>(new Comparator<Usuario>(){
        public int compare(Usuario o1, Usuario o2)
        {
            return o1.getUsuario().compareTo(o2.getUsuario());
        } 


        });
        Usuario def = new Usuario("default","default");
        Usuario priv = new Usuario("admin","123");
        this.conjuntousers.put(def,false);
        this.conjuntousers.put(priv,true);
    }

    public void añadirUsuario(Usuario u, boolean b) {
        this.conjuntousers.put(u, b);

    }



    public void eliminarUsuario(Usuario u) {
        this.conjuntousers.remove(u);
    }


    public boolean existeUsuario(Usuario u) {
        return this.conjuntousers.containsKey(u);
    }



    public boolean contrasenaCorrecta(String user, String pass) {
        Iterator it = this.conjuntousers.keySet().iterator();
        boolean encontrado =false;
        while (it.hasNext() && !encontrado) {
            Usuario u = (Usuario) it.next();
            if (!u.getUsuario().equals(user) || !u.getPassword().equals(pass)) return false;
            else encontrado=true;

        }
        return true;

    }

    public boolean usuarioPrivilegiado(Usuario u) {
        return this.conjuntousers.get(u);

    }
}