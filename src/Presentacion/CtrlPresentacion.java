/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CtrlDominio;
import java.util.*;

/**
 * Crea instancia del controlador de presentacion y de la vista principal
 * Hace visible la vista
 * @author Claudia Martinez Alquezar
 */
public class CtrlPresentacion {
    //Variables
    private final CtrlDominio cDominio;    
    //Vistas
    private VistaPrincipal vPrincipal;
    private VistaAlta vAlta;
    private VistaBaja vBaja;
    private VistaModificacion vModificacion;
    private VistaDocumento vDocumento;
    private VistaConsultas vConsultas;
    private VistaMenuConsultas vMenuConsultas;
    private VistaConsultaDocumento vConsultaDocumento;
    private VistaPrefijo vPrefijo;
    private VistaTitulosA vTitulosA;
    private VistaAutoresT vAutoresT;
    private VistaExpreBool vExpreBool;
    private VistaDocParecidos vDocParecidos;
    private VistaUsuarioPrivilegiado vUsuarioPrivilegiado;
            
    //Ventanas
    private javax.swing.JFrame ventanaPrimaria;
    
    public CtrlPresentacion() {
        cDominio = new CtrlDominio();
        if (vPrincipal == null) {
            vPrincipal = new VistaPrincipal(this);
        }
    }
    
    public void iniPresentacion() {
        vPrincipal.setVisible(true);
    }
    
    /**
     * Para cambiar de vista segun tipoVista
     * @param tipoVista 
     */
    public void controlaVistas(String tipoVista) {
        if (tipoVista.equals("Principal")) {
            vPrincipal.setEnabled(true);
        } 
        if (tipoVista.equals("Alta")) {
            vPrincipal.disabled();
            vAlta = new VistaAlta(this);
            vAlta.visible();
        }
       if (tipoVista.equals("Baja")) {
            vPrincipal.disabled();
            vBaja = new VistaBaja(this);
            vBaja.visible();
        }
       if (tipoVista.equals("Modificacion")) {
            vPrincipal.disabled();
            vModificacion = new VistaModificacion(this);
            vModificacion.visible();
        }
       if (tipoVista.equals("Documento")) {
            vPrincipal.disabled();
            vDocumento = new VistaDocumento(this);
            vDocumento.visible();
        }
       if (tipoVista.equals("Consultas")) {
            vConsultas = new VistaConsultas(this);
            vConsultas.visible();
        }
       if (tipoVista.equals("MenuConsultas")) {
            vPrincipal.disabled();
            vMenuConsultas = new VistaMenuConsultas(this);
            vMenuConsultas.visible();
        }
       if (tipoVista.equals("ConsultaDocumento")) {
            vPrincipal.disabled();
            vConsultaDocumento = new VistaConsultaDocumento(this);
            vConsultaDocumento.visible();
        }
        if(tipoVista.equals("TitulosA")) {
            vTitulosA = new VistaTitulosA(this);
            vTitulosA.visible();
        }
        if(tipoVista.equals("AutoresT")) {
            vAutoresT = new VistaAutoresT(this);
            vAutoresT.visible();
        }
        if (tipoVista.equals("Prefijo")) {
           vPrefijo = new VistaPrefijo(this);
           vPrefijo.visible();
        }
        if (tipoVista.equals("Boolean")) {
           vExpreBool = new VistaExpreBool(this);
           vExpreBool.visible();
        }
        if (tipoVista.equals("Parecidos")) {
           vDocParecidos = new VistaDocParecidos(this);
           vDocParecidos.visible();
        }
        if (tipoVista.equals("Login")) {
           vPrincipal.disabled();
           vUsuarioPrivilegiado = new VistaUsuarioPrivilegiado(this);
           vUsuarioPrivilegiado.visible();
            
        }
    }
    
    public boolean existeDocumento(String titulo, String autor) {
        return cDominio.llamadaExisteKey(titulo, autor);
    }
    
    public boolean abreDocumento(String titulo, String autor) {
        if (cDominio.llamadaExisteKey(titulo, autor)) {
            controlaVistas("Documento");
            ArrayList<String> contenido = cDominio.llamadaDevuelveContenido(titulo,autor);
            vDocumento.setInformacion(titulo, autor, contenido, false);
            return true;
        } else return false;
    }
    
     public VistaDocumento abreDocumentoConsulta(String titulo, String autor) {
        controlaVistas("Documento");
        ArrayList<String> contenido = cDominio.llamadaDevuelveContenido(titulo,autor);
        vDocumento.setInformacion(titulo, autor, contenido, true);
        return vDocumento;
    }
    
        
    public boolean altaDocumento(String titulo, String autor, ArrayList<String> contenido) {
        if (cDominio.llamadaExisteKey(titulo, autor)) return true;
        else {
            cDominio.llamadaAltaDoc(titulo, autor, contenido);
            return false;
        }
    }
    
    public boolean bajaDocumento(String titulo, String autor) {
        if (cDominio.llamadaExisteKey(titulo, autor)) {
            cDominio.llamadaBajaDoc(titulo, autor);
            return true;
        } else {            
            return false;
        }
    }
    
    public boolean modificaDocumento(String titulo, String autor, ArrayList<String> contenidoN, ArrayList<String> contenidoA, String opcion) {
        switch (opcion) {
                case "Buscar": // Buscamos si existe, devuelve contenido antiguo
                    if (cDominio.llamadaExisteKey(titulo, autor)) {
                        contenidoA = cDominio.llamadaDevuelveContenido(titulo, autor);
                        return true;
                    } else {
                        return false;
                    }
                case "Sobreescribe": // Sobreescribimos documento existente con nuevo contenido
                    cDominio.llamadaModificaDoc(titulo, autor, contenidoN, "S");
                    return true;
                case "Nuevo": // Creamos nuevo documento, pasando el nuevo contenido
                    controlaVistas("Alta");
                    vAlta.setInformacion(titulo, autor, contenidoN);                    
                default:
                    return false;
            
        }
    }  
    
    public void consultar(String s, String opcion) {
        Set<AbstractMap.SimpleEntry<String,String> > lista = cDominio.llamadaConsulta(s, opcion);  
        controlaVistas("Consultas");
        vConsultas.iniTableDosColumnas(lista);
    }
    
    public void consultarPrefijo(String prefijo) {
        if (prefijo == null) prefijo="";
        SortedSet<String> lista = cDominio.llamadaConsultaPrefijo(prefijo);
        controlaVistas("Consultas");
        vConsultas.iniTableUnaColumna(lista);
    }
    
    public void consultarDocumentosParecidos(String titulo, String autor, int k) {
        Set<AbstractMap.SimpleEntry<String,String> > lista = cDominio.llamadaConsultaParecidos(titulo,autor,k);
        controlaVistas("Consultas");
        vConsultas.iniTableDosColumnas(lista);
    }

    public boolean comprobarContraseña(String usuario, String password) {
        return cDominio.comprobarContraseña(usuario,password);
    }
    
    public boolean esPrivilegiado() {
        return cDominio.esPrivilegiado();
    }
    
    public ArrayList<String> devuelveContenido(String titulo, String autor) {
        ArrayList<String> a = cDominio.llamadaDevuelveContenido(titulo,autor);
        return a;
    }
    
    
}
