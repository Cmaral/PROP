package Dominio;

/**
 * Created by Paola on 08/11/2016.
 */
import java.util.*;
public class LlistaVectorsRellevancia {
    private ArrayList<Pair<Pair<String,String>,VectorRellevancia>> llistaVectors;
    private Set<String> paraulescutrescat;
    private VectorRellevancia plantilla;

    LlistaVectorsRellevancia() {

        this.plantilla = new VectorRellevancia();
        this.llistaVectors = new ArrayList<Pair<Pair<String,String>,VectorRellevancia>>();
        this.paraulescutrescat = new HashSet<String>();
        Scanner paraulescat = new Scanner("últim\n" + "última\n" + "últimes\n" + "últims\n" + "!\n" + "\"\n" + "#\n" + "##\n" + "###\n" + "%\n" +
                "&\n" + "'\n" + "'l\n" + "'ls\n" + "'m\n" + "'s\n" + "'t\n" + "(\n" + ")\n" + "+\n" + ",\n" + "-\n" + ".\n" + "...\n" +
                "/\n" + ":\n" + ";\n" + "?\n" + "a\n" + "abans\n" + "això\n" + "al\n" + "algun\n" + "alguna\n" + "algunes\n" + "alguns\n" + "allà\n" +
                "allí\n" + "allò\n" + "als\n" + "altra\n" + "altre\n" + "altres\n" + "amb\n" + "aprop\n" + "aquí\n" + "aquell\n" + "aquella\n" +
                "aquelles\n" + "aquells\n" +
                "aquest\n" +
                "aquesta\n" +
                "aquestes\n" +
                "aquests\n" +
                "cada\n" +
                "catorze\n" +
                "cent\n" +
                "cert\n" +
                "certa\n" +
                "certes\n" +
                "certs\n" +
                "cinc\n" +
                "com\n" +
                "cosa\n" +
                "d'\n" +
                "darrer\n" +
                "darrera\n" +
                "darreres\n" +
                "darrers\n" +
                "davant\n" +
                "de\n" +
                "del\n" +
                "dels\n" +
                "després\n" +
                "deu\n" +
                "dinou\n" +
                "disset\n" +
                "divuit\n" +
                "dos\n" +
                "dotze\n" +
                "durant\n" +
                "el\n" +
                "ell\n" +
                "ella\n" +
                "elles\n" +
                "ells\n" +
                "els\n" +
                "en\n" +
                "encara\n" +
                "et\n" +
                "extra\n" +
                "fins\n" +
                "hi\n" +
                "i\n" +
                "jo\n" +
                "l'\n" +
                "la\n" +
                "les\n" +
                "li\n" +
                "llur\n" +
                "lo\n" +
                "los\n" +
                "més\n" +
                "m'\n" +
                "ma\n" +
                "massa\n" +
                "mateix\n" +
                "mateixa\n" +
                "mateixes\n" +
                "mateixos\n" +
                "mes\n" +
                "meu\n" +
                "meva\n" +
                "mig\n" +
                "molt\n" +
                "molta\n" +
                "moltes\n" +
                "molts\n" +
                "mon\n" +
                "mons\n" +
                "n'\n" +
                "na\n" +
                "ni\n" +
                "no\n" +
                "nosaltres\n" +
                "nostra\n" +
                "nostre\n" +
                "nou\n" +
                "ns\n" +
                "o\n" +
                "on\n" +
                "onze\n" +
                "pel\n" +
                "per\n" +
                "però\n" +
                "perquè\n" +
                "perque\n" +
                "poc\n" +
                "poca\n" +
                "pocs\n" +
                "poques\n" +
                "primer\n" +
                "primera\n" +
                "primeres\n" +
                "primers\n" +
                "prop\n" +
                "què\n" +
                "qual\n" +
                "quals\n" +
                "qualsevol\n" +
                "qualssevol\n" +
                "quan\n" +
                "quant\n" +
                "quanta\n" +
                "quantes\n" +
                "quants\n" +
                "quatre\n" +
                "que \n" +
                "qui\n" +
                "quin\n" +
                "quina\n" +
                "quines\n" +
                "quins\n" +
                "quinze\n" +
                "res\n" +
                "s'\n" +
                "sa\n" +
                "segon\n" +
                "segona\n" +
                "segones\n" +
                "segons\n" +
                "sense\n" +
                "ses\n" +
                "set\n" +
                "setze\n" +
                "seu\n" +
                "seus\n" +
                "seva\n" +
                "seves\n" +
                "sino\n" +
                "sis\n" +
                "sobre\n" +
                "son\n" +
                "sons\n" +
                "sota\n" +
                "t'\n" +
                "ta\n" +
                "tal\n" +
                "tals\n" +
                "tan\n" +
                "tant\n" +
                "tanta\n" +
                "tantes\n" +
                "tants\n" +
                "tes\n" +
                "teu\n" +
                "teus\n" +
                "teva\n" +
                "teves\n" +
                "ton\n" +
                "tons\n" +
                "tot\n" +
                "tota\n" +
                "totes\n" +
                "tots\n" +
                "tres\n" +
                "tretze\n" +
                "tu\n" +
                "un\n" +
                "una\n" +
                "unes\n" +
                "uns\n" +
                "vint\n" +
                "vos\n" +
                "vosaltres\n" +
                "vosté\n" +
                "vostés\n" +
                "vostra\n" +
                "vostre\n" +
                "vuit\n");
        while(paraulescat.hasNextLine()) { this.paraulescutrescat.add(paraulescat.nextLine()); }




    }


    public ArrayList<Pair<Pair<String,String>,VectorRellevancia>> getLlistaVectorsRellevancia() {
        return this.llistaVectors;
    }

    public void añadirVector(Pair<Pair<String,String>,VectorRellevancia> pv) {
        this.llistaVectors.add(pv);
    }


    public VectorRellevancia getVectorRellevancia(Pair p) {
        Integer i= posicioVectorRellevancia(p);
        return this.llistaVectors.get(i).getSecond();
    }



    public Integer posicioVectorRellevancia(Pair p) {
        for(int i=0; i< this.llistaVectors.size(); i++) {
            if(this.llistaVectors.get(i).getFirst().getFirst().equals(p.getFirst()) && this.llistaVectors.get(i).getFirst().getSecond().equals(p.getSecond())) {
                return i;
            }

        }
        return -1;


    }

    private boolean cutreSalchichera(String p) {

        if(this.paraulescutrescat.contains(p)) return true;
        return false;
    }



    public VectorRellevancia calcularVectorRellevancia(Documento d) {
        ArrayList <Frase> content = d.getContenido();
        VectorRellevancia vecdocumento = new VectorRellevancia();
        for (int i=0; i<content.size(); i++) {
            ArrayList<String> frase  = content.get(i).getFrase();
            for (int j=0; j<frase.size(); ++j) {
                String palabra = frase.get(j);
                if (!cutreSalchichera(palabra)) {
                    this.plantilla.añadirPalabra(palabra);
                    vecdocumento.añadirPalabra(palabra);
                }
            }
        }
        return vecdocumento;

    }

    public void calcularLlista(HashMap<Pair,Documento> conjunt) {
        Set<Pair> set = conjunt.keySet();
        for (Pair<String,String> key : set ) {
            int pos = posicioVectorRellevancia(key);
            if(pos<0) {
                VectorRellevancia vecdocumento = calcularVectorRellevancia(conjunt.get(key));
                Pair<Pair<String,String>,VectorRellevancia> pvec = new Pair(key,vecdocumento);
                añadirVector(pvec);
            }
        }


    }





}
