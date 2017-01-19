package Dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paola
 */
import java.util.*;
public class ExpresionBooleana {
    public HashSet<Documento> resultado;
    public ArbolBool comparador;

    public ExpresionBooleana() {
        this.comparador = new ArbolBool();
        resultado = new HashSet<>();
    }
   

    public boolean comparar(Nodo raiz, ArrayList<String> f) {
        if(raiz.getLeft() != null && raiz.getRight() != null)
        {
            if(raiz.getData().equals("&")) {
                return comparar(raiz.getLeft(),f) & comparar(raiz.getRight(),f);
            }
            else if(raiz.getData().equals("|")) {
                return comparar(raiz.getLeft(),f) | comparar(raiz.getRight(),f);
            }
          
        }
        else if(raiz.getLeft()!=null & raiz.getRight() == null) {
            if(raiz.getData().equals("!")) {
                return !(comparar(raiz.getLeft(),f));
            }
            return comparar(raiz.getLeft(),f);
        }
        else if(raiz.getRight()!=null & raiz.getLeft() == null) {
            if(raiz.getData().equals("!")) {
                return !(comparar(raiz.getRight(),f));
            }
            return comparar(raiz.getRight(),f);
        }
        
        String[] separado = raiz.getData().split(" ");
        if(separado[0].equals("{")) {
            int i=1;
            while(i < separado.length  & !separado[i].equals("}")) {
                if(!f.contains(separado[i])) return false;
                ++i;
            }
            return true;
            
        }
        else if(separado[0].equals("\"")) {
            for(int j=0; j<f.size(); ++j) {
                if(f.get(j).equals(separado[1])) {
                    boolean t = true;
                    int i=2;
                    ++j;
                    while(i<= separado.length - 2 & t) {
                        if(!f.get(j).equals(separado[i])) t = false;
                        ++j;
                        ++i;  
                    }
                    if(t) return true;
                }
                  
            }
            return false;
           
        }
        return f.contains(raiz.getData());
    }
            


    private boolean satisface(ArrayList<Frase> contenido) {
        boolean f = false;
        for(int i=0; i<contenido.size() && !f; ++i) {
            if(comparar(this.comparador.getRaiz(), contenido.get(i).getFrase())) f= true;
        }
        return f;

    }
    
    public HashSet<Documento> expresionbooleana(String expresion, HashMap<Pair,Documento> conjunto) {
       this.comparador.createArbol(expresion);
        Set<Pair> set = conjunto.keySet();
        for (Pair<String,String> key : set ) {
            if(satisface(conjunto.get(key).getContenido())) this.resultado.add(conjunto.get(key));
        }
    return this.resultado;
    }
}
