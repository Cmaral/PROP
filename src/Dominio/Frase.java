package Dominio;

import java.util.*;
import java.io.Serializable;

/* @author: Claudia Martinez Alquezar */

public class Frase implements Serializable{

  private String F;
  private ArrayList<String> palabras;

  private void fraseAPalabras() {
    String[] stringSeparado = F.split(" ");
    this.palabras = new ArrayList<String>(Arrays.asList(stringSeparado));
  }

  /* Constructor vacio */
  public Frase() {
      this.F = null;
      this.palabras = null;
  }

  /* Constructor con string */
  public Frase(String s) {
    F = s;
    fraseAPalabras();
  }

  /* Dada una Frase, lee una línea e introduce los elementos correctos en la Frase */
  public void leerFrase() {
    Scanner S = new Scanner(System.in);
    F = S.nextLine();
    fraseAPalabras();
  }

  /* Dada una Frase, devuelve la frase como String */
  public String getString() {
    return F;
  }

  /* Devuelve palabras */
  public ArrayList<String> getFrase() {
      return palabras;
  }

  /* Dado un String y una Frase, convierte e introduce los elementos correctos en la Frase */
  public void stringAFrase(String f) {
      F = f;
      fraseAPalabras();
  }


}
