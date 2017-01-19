/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.CtrlPersistencia;
import java.util.*;

/**
 *
 * @author Claudia Martinez Alquezar
 */
public class CtrlDominio {
    private CtrlPersistencia cPersistencia;
    private ConjuntoDocumentos ConDoc;
    private ConjuntoUsuarios conUs;
    boolean usuarioPrivilegiado = false;
    
    public CtrlDominio() {
        ConDoc = new ConjuntoDocumentos();
        conUs = new ConjuntoUsuarios();
        cPersistencia = new CtrlPersistencia();
    }
        
    public boolean llamadaExisteKey(String titulo, String autor) {
        ConDoc.setMap(cPersistencia.cargaConjunto());
        Pair<String,String> key = new Pair<String,String>(autor,titulo);
        return ConDoc.existeKey(key);
    }
    
    public ArrayList<String> llamadaDevuelveContenido(String titulo, String autor) {
        ConDoc.setMap(cPersistencia.cargaConjunto());
        Pair<String,String> key = new Pair<>(autor,titulo);
        ArrayList<Frase> contenidoFrase = ConDoc.devuelveContenido(key);
        ArrayList<String> contenidoString = new ArrayList<>();
        for (Frase f: contenidoFrase) {
            contenidoString.add(f.getString());
        }
        return contenidoString;
    }
    
    public ArrayList<Frase> arraylistFrase(ArrayList<String> contenidoString) {
        ArrayList<Frase> contenidoFrase = new ArrayList<Frase>();
        Frase f = new Frase();
        for (String s: contenidoString) {
            f.stringAFrase(s);
            contenidoFrase.add(f);
        }
        return contenidoFrase;
    }
    
    public void llamadaAltaDoc(String titulo, String autor, ArrayList<String> contenidoString) {
        ArrayList<Frase> contenidoFrase = arraylistFrase(contenidoString);
        Pair<String,String> key = new Pair<String,String>(autor,titulo);
        ConDoc.altaDoc(key, contenidoFrase);
        cPersistencia.guardaConjunto(ConDoc.getMap());
        
    }
    
    public void llamadaBajaDoc(String titulo, String autor) {
        Pair<String,String> key = new Pair<String,String>(autor,titulo);
        ConDoc.bajaDoc(key);      
        cPersistencia.guardaConjunto(ConDoc.getMap());
        
    }
    
    public void llamadaModificaDoc(String titulo, String autor, ArrayList<String> contenido, String opcion) {
         ArrayList<Frase> contenidoFrase = arraylistFrase(contenido);
         Pair<String,String> key = new Pair<String,String>(autor,titulo);
         ConDoc.modificaDoc(key, contenidoFrase, "S");
         cPersistencia.guardaConjunto(ConDoc.getMap());
    }
       
    
    public Set<AbstractMap.SimpleEntry<String,String> > llamadaConsulta(String seleccion, String tipoConsulta) {
       ConDoc.setMap(cPersistencia.cargaConjunto());
       HashMap<Pair,Documento> todos = ConDoc.getMap();
       Set<AbstractMap.SimpleEntry<String,String> > lista = new HashSet< >();
       AbstractMap.SimpleEntry<String,String> e;
       SortedSet<String> s;
       ArrayList<Documento> a;
       
       switch (tipoConsulta) {
            case "TitulosA":
                TitulosAutor ta = new TitulosAutor();
                s = ta.conseguir_doc(todos, seleccion);
                for(final Iterator it = s.iterator(); it.hasNext(); ) {
                    e = new AbstractMap.SimpleEntry< >((String) it.next(), seleccion);
                    lista.add(e);
                }
                break;
            case "AutoresT":
                AutoresTitulo at = new AutoresTitulo();
                s = at.conseguir_doc(todos, seleccion);
                for(final Iterator it = s.iterator(); it.hasNext(); ) {
                    e = new AbstractMap.SimpleEntry< >(seleccion, (String) it.next());
                    lista.add(e);
                }
                break;
            case "Vacios":
                Vacios v = new Vacios();
                a = v.buscar_doc_vacio(todos);
                for (Documento d: a) {
                    e = new AbstractMap.SimpleEntry< >(d.getTitulo().getString(), d.getAutor().getString());
                    lista.add(e);
                }
                break;
            case "Boolean":
                ExpresionBooleana eb = new ExpresionBooleana();
                HashSet<Documento> h = eb.expresionbooleana(seleccion, todos);
                
                for (Documento d : h) {
                    e = new AbstractMap.SimpleEntry< >(d.getTitulo().getString(), d.getAutor().getString());
                    lista.add(e);
                }                
                break;
        }      
       return lista;
   }
    
    public SortedSet<String> llamadaConsultaPrefijo(String prefijo) {
        ConDoc.setMap(cPersistencia.cargaConjunto());
        HashMap<Pair,Documento> todos = ConDoc.getMap();
        SortedSet<String> listaP = new TreeSet<String>();
        Prefijo p = new Prefijo();
        listaP = p.mostrarAutores(prefijo, todos);
        return listaP;
    }
    
    public Set<AbstractMap.SimpleEntry<String,String> > llamadaConsultaParecidos(String titulo, String autor, int k) {
        ConDoc.setMap(cPersistencia.cargaConjunto());
        HashMap<Pair,Documento> todos = ConDoc.getMap();
        Set<AbstractMap.SimpleEntry<String,String> > lista = new LinkedHashSet< >();
        AbstractMap.SimpleEntry<String,String> e;
        Frase a = new Frase(autor);
        Frase t = new Frase(titulo);
        Pair<String,String> key = new Pair< >(autor,titulo);
        Documento d = new Documento(a,t);
        d.modifica(ConDoc.devuelveContenido(key));
        
        DocumentosParecidos dp = new DocumentosParecidos();        
        ArrayList<Documento> al = dp.documentosparecidos(todos, d, k);
        int i=0;
        for (Documento d1: al) {
            if (i < k) {
                e = new AbstractMap.SimpleEntry< >(d1.getTitulo().getString(), d1.getAutor().getString());
                lista.add(e);
                ++i;
            }
        }
        
        return lista;
    }
    
     public boolean comprobarContraseña(String usuario, String password) {
         usuarioPrivilegiado = conUs.contrasenaCorrecta(usuario, password);
         return usuarioPrivilegiado;
   }
     
     public boolean esPrivilegiado() {
         return usuarioPrivilegiado;
     }
    
}
