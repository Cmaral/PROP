package Dominio;

import java.util.*;


/**
 * Created by alBa
 */
public class AutoresTitulo {
    private SortedSet<String> autoresT;

    public AutoresTitulo(){
        autoresT = new TreeSet<String>();
    }

    public SortedSet<String> conseguir_doc (HashMap<Pair,Documento> todos, String eleccion){
        //System.out.println("Lista de autores con el título " + eleccion + " solicitado:");
        Set<Pair> set = todos.keySet();
        for (Pair<String,String> key : set ) {
            String aux = key.getSecond();
            if (aux.equals(eleccion)){
                autoresT.add(todos.get(key).getAutor().getString());
            }
        }
        //if(autoresT.isEmpty()) {System.out.println("No existe el titulo solicitado.");}
	//else{
		//mostrarAutores();
               
        return autoresT;
		
	}
    /*
    public static TreeMap<String,String> mapDocs(HashMap<Pair,Documento> todos, String eleccion){
        
        TreeMap<String,String> lista = new TreeMap<String,String>() {};
        Set<Pair> set = todos.keySet();
        for (Pair<String,String> key : set ) {
            String aux = key.getSecond();
            if (aux.equals(eleccion)){
                lista.put(todos.get(key).getAutor().getString(), todos.get(key).getTitulo().getString());
            }
        }
            return lista;
    }*/
       
}








