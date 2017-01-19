package Dominio;

import java.util.*;
import java.io.*;

/* @author: Claudia Martinez Alquezar */

public class ConjuntoDocumentos {

    private static String error_campoVacio = "Este campo no puede ser vacío.";
    private static String error_docExistente = "Este documento ya existe.";
    private static String error_docInexistente = "Este documento no existe.";

    /* Mapa donde guardaremos los Documentos */
    private static HashMap<Pair, Documento> Conjunto;


    /* Constructor */
    public ConjuntoDocumentos() {
        Conjunto = new HashMap<Pair, Documento>();
    }
    
    public HashMap<Pair, Documento> getMap() {
        return Conjunto;
    }
    
     public void setMap(HashMap<Pair, Documento> Conjunto) {
        this.Conjunto = Conjunto;
    }


    /* Devuelve true si la key esta en el mapa */
    public Boolean existeKey(Pair<String,String> key) {
        return (Conjunto.containsKey(key));
    }

    /* Lee secuencia de Strings y devuelve ArrayList<Frase> */
    private static ArrayList<Frase> getContenido() {
      Scanner S = new Scanner(System.in);
      ArrayList<Frase> contenido = new ArrayList<Frase>();
      Frase f = new Frase();

      while (S.hasNextLine()) {
          f = new Frase();
          String string = S.nextLine();
          if (string.equals("")) break;
          f.stringAFrase(string);
          contenido.add(f);
        }

      return contenido;
    }



    /* __________GESTIÓN___________ */

    /* Añade documento al conjunto */
    public void altaDoc(Pair<String,String> key, ArrayList<Frase> contenido) {
        
        if (Conjunto.containsKey(key)) System.out.println(error_docExistente);
        else {
            Frase autor = new Frase(key.getFirst());
            Frase titulo = new Frase(key.getSecond());
            Documento D = new Documento(autor,titulo);
            if (contenido != null) D.modifica(contenido);
            this.Conjunto.put(key, D);
        }
        
    }


    /* Elimina documento del conjunto */
    public void bajaDoc(Pair<String,String> key) {
        if (!Conjunto.containsKey(key)) {
            System.out.println(error_docInexistente + "\n");
        } else {
            this.Conjunto.remove(key);
        }
    }


    /* Modifica documento existente, con opcion de sobreescribirlo o crear un
    documento nuevo en el Conjunto */
    public void modificaDoc(Pair<String,String> key, ArrayList<Frase> nuevoContenido, String opcion) {
        if (!Conjunto.containsKey(key)) {
            System.out.println(error_docInexistente + "\n");
        } else {
        Frase autor = new Frase(key.getFirst());
        Frase titulo = new Frase(key.getSecond());
        Documento D;
        Boolean end = false;
        while (!end) {
        switch(opcion) {
            case "S":
                D = new Documento(autor,titulo);
                D.modifica(nuevoContenido);
                this.Conjunto.replace(key, D);
                end=true;
                break;
            case "N":
                Pair<String,String> keyNuevo = key;
                autor = new Frase(keyNuevo.getFirst());
                titulo = new Frase(keyNuevo.getSecond());
                D = new Documento(autor,titulo);
                D.modifica(nuevoContenido);
                this.Conjunto.put(keyNuevo, D);
                end=true;
                break;
            default:
                break;

            }
        }

    }
    }

    /* Elimina todos los documentos */
    public void vacia() {
        this.Conjunto.clear();
    }




  /*  __________CONSULTA __________ */
    
  /* Devuelve contenido de un documento del Conjunto segun su key */
  public ArrayList<Frase> devuelveContenido(Pair<String,String> key) {
        Documento D = this.Conjunto.get(key);
        ArrayList<Frase> contenido = D.getContenido();
        return contenido;
  }



}
