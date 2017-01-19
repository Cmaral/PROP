package Dominio;

import Dominio.Pair;
import Dominio.Documento;
import java.util.*;

/**
 * Created by alBa
 */

public class Vacios{

    private ArrayList<Documento> vacios;

    public Vacios() {
        vacios = new ArrayList<Documento>();
    }
    

    public ArrayList<Documento> buscar_doc_vacio(HashMap<Pair, Documento> todos) {
        for(Map.Entry<Pair,Documento> entry: todos.entrySet()) {
            Documento auxd = entry.getValue();

            if (auxd.esVacio()) {
                vacios.add(auxd);
            }
        }
        
	Collections.sort(vacios);
        return vacios;
    }
}
