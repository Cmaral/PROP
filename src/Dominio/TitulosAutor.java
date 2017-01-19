package Dominio;

import java.util.*;


/**
 * Created by alBa
 */
public class TitulosAutor {
    private static SortedSet<String> titulosA;

    public TitulosAutor(){
        titulosA = new TreeSet<String>();
    }


    public static SortedSet<String> conseguir_doc (HashMap<Pair,Documento> todos, String eleccion){
        //System.out.println("Lista de titulos del autor " + eleccion + " solicitado:");
        Set<Pair> set = todos.keySet();
        for (Pair<String,String> key : set ) {
            String aux = key.getFirst();
            if (aux.equals(eleccion)){
                titulosA.add(todos.get(key).getTitulo().getString());
            }
        }
        //if(titulosA.isEmpty()) {System.out.println("No existe el autor solicitado.");}
	//else {
       
	//mostrarTitulos();}
	
	return titulosA;
    }
    /*
    public static TreeMap<String,String> mapDocs(HashMap<Pair,Documento> todos, String eleccion){
        
        TreeMap<String,String> lista = new TreeMap<String,String>() {};
        Set<Pair> set = todos.keySet();
        for (Pair<String,String> key : set ) {
            String aux = key.getFirst();
            if (aux.equals(eleccion)){
                lista.put(todos.get(key).getTitulo().getString(), todos.get(key).getAutor().getString());
            }
        }
            return lista;
    }*/

}






