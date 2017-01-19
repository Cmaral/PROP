package Dominio;


import java.util.*;
/**
 * Created by Paola on 07/11/2016.
 */
public class DocumentosParecidos {
    public LlistaVectorsRellevancia llistavec;
    public ArrayList <Pair<Pair<String,String>,Integer>> vectorUnos;
    public VectorRellevancia vecdocumento;
    public Documento d;
    public Integer k;




    public DocumentosParecidos() {
        this.llistavec = new LlistaVectorsRellevancia();
        this.vectorUnos = new ArrayList <Pair<Pair<String,String>,Integer>>();
        this.vecdocumento = new VectorRellevancia();
        this.d = new Documento();

    }


    private void ordenar_unos() {
        Collections.sort(this.vectorUnos, new Comparator< Pair< Pair<String,String> ,Integer> >() {
            @Override
            public int compare(Pair<Pair<String,String>,Integer> o1, Pair<Pair<String,String>,Integer> o2) {
                return o2.getSecond().compareTo(o1.getSecond());
            }
        });
    }

    private int calcular_unos(VectorRellevancia vec) {
        int i=0, contador=0;
        while(i<vec.getVector().size()) {
            if(this.vecdocumento.posicionPalabra(vec.getVector().get(i).getFirst()) >= 0) ++contador;
            ++i;
        }
        return contador;


    }

    private void setVectorUnos() {
        for(int i=0; i<this.llistavec.getLlistaVectorsRellevancia().size(); i++) {

                int unos = calcular_unos(this.llistavec.getLlistaVectorsRellevancia().get(i).getSecond());
                if(unos!=0) {
                    Pair<Pair<String, String>, Integer> newvalue = new Pair(this.llistavec.getLlistaVectorsRellevancia().get(i).getFirst(), unos);
                    this.vectorUnos.add(newvalue);
                    ordenar_unos();
                }

        }

    }

    public ArrayList<Documento> documentosparecidos(HashMap<Pair,Documento> conjunto, Documento d, Integer k) {
        this.llistavec.calcularLlista(conjunto); 
        this.vecdocumento = this.llistavec.calcularVectorRellevancia(d);
        setVectorUnos();
        ArrayList<Documento> result = new ArrayList<Documento>();
        for(int i=0; i<this.vectorUnos.size() & i<k; ++i) {
            result.add(conjunto.get(this.vectorUnos.get(i).getFirst()));
        }
        return result;

    }





}