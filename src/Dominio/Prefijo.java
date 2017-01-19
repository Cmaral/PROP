package Dominio;

import java.util.*;

public class Prefijo {


    private SortedSet<String> autores;

    public Prefijo() {
        autores = new TreeSet<String>();
    }

    private void mostrarTodos(HashMap<Pair, Documento> todos) {

        for(Map.Entry<Pair,Documento> entry: todos.entrySet()) {
            Documento auxd = entry.getValue();
                autores.add(auxd.getAutor().getString());

            }
        }


    public SortedSet<String> mostrarAutores (String prefijo, HashMap<Pair, Documento> todos) {
        if (prefijo.length()==0 || prefijo==null) {
            mostrarTodos(todos);
        } else {
            int max = prefijo.length();
            Set<Pair> set = todos.keySet();
            for (Pair<String,String> key : set) {
                    String aut = key.getFirst();
                    if (max <= aut.length() && aut.substring(0,max).contains(prefijo)) {
                        autores.add(todos.get(key).getAutor().getString());
                    }
                }
            //mostrarAutores();
            }
        return autores;
    }
    
    
}



           
