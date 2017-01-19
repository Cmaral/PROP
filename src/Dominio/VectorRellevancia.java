package Dominio;


/**
 * Created by Paola on 08/11/2016.
 */
import java.util.*;
import java.util.Map.Entry.*;
import java.lang.String.*;
public class VectorRellevancia {
    private ArrayList<Pair<String,Integer>> vector;

    VectorRellevancia() {

        vector = new ArrayList<Pair<String,Integer>>();
    }




    private void ordenarVector() {
        Collections.sort(vector, new Comparator<Pair<String,Integer>>() {
            @Override
            public int compare(Pair<String,Integer> o1, Pair<String, Integer> o2) {
                return o1.getFirst().compareTo(o2.getFirst());
            }
        });

    }

    public ArrayList<Pair<String,Integer>> getVector() { return this.vector; }

    public void setVector(ArrayList<Pair <String,Integer> > vec) { this.vector = vec; }

    public void añadirPalabra(String p) {
        int pos = posicionPalabra(p);
        if(pos<0) {
            Pair<String,Integer> newvalor = new Pair(p,1);
            vector.add(newvalor);
            ordenarVector();
        }
        else {
            Integer newpeso = vector.get(pos).getSecond() + 1;
            Pair<String,Integer> newvalor = new Pair(p,newpeso);
            this.vector.set(pos,newvalor);
        }


    }

    public void eliminarPalabra(String p) {
        Integer pos = posicionPalabra(p);
        if(this.vector.get(pos).getSecond() == 1) {
            vector.remove(this.vector.get(pos));
        }
        else {
            Integer newpeso = this.vector.get(pos).getSecond()-1;
            Pair<String,Integer> newvalor = new Pair(p,newpeso);
            this.vector.set(pos,newvalor);
        }
        this.ordenarVector();
    }


    public Integer posicionPalabra(String p) {
        int low = 0;
        int high = vector.size() - 1;

        while(high >= low) {
            int middle = (low + high) / 2;
            if(vector.get(middle).getFirst().equals(p) ) {
                return middle;
            }
            int result = vector.get(middle).getFirst().compareTo(p);
            if(result < 0) {
                low = middle + 1;
            }
            if(result > 0) {
                high = middle - 1;
            }
        }
        return -1;

    }


}

