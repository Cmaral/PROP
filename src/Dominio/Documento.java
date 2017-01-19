package Dominio;

import java.util.*;
import java.io.Serializable;

/* @author: Claudia Martinez Alquezar */

public class Documento implements Serializable, Comparable<Documento> {

  private Frase titulo;
  private Frase autor;
  private ArrayList<Frase> contenido;
  private Boolean esVacio;


  /* Constructor vacio */
  public Documento () {
      this.titulo = new Frase();
      this.autor = new Frase();
      contenido = new ArrayList<Frase>();
      esVacio = true;
  }

  /* Constructor con frases*/
  public Documento (Frase a, Frase t) {
    autor = a;
    titulo = t;
    contenido = new ArrayList<Frase>();
    esVacio = true;
  }

  /* Devuelve el título del documento */
  public Frase getTitulo () {
    return titulo;
  }

  /* Devuelve el autor del documento */
  public Frase getAutor () {
    return autor;
  }

  /* Devuelve el contenido del documento */
  public ArrayList<Frase> getContenido () {
    return contenido;
  }

  /* Indica si el contenido está vacío */
  public Boolean esVacio() {
      if (contenido.size() == 0) esVacio=true;
      return this.esVacio;
  }

  /*Dado un nuevo contenido, sobreescribe el contenido del documento con el nuevo */
  public void modifica(ArrayList<Frase> contenido) {
    this.contenido = contenido;
    esVacio = false;
  }

  @Override
    public int compareTo(Documento d) {
        String tit = new String(String.valueOf(this.getTitulo().getString()));
        String tit1 = new String(String.valueOf(d.getTitulo().getString()));
        return tit.compareTo(tit1);
        
    }

}
