/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 * Crea objeto CtrlPresentacion e inicia presentacion
 * @author Claudia Martinez Alquezar
 */
public class Main {
        
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (new Runnable() {
            
            public void run() {
            CtrlPresentacion cPresentacion = new CtrlPresentacion();
            cPresentacion.iniPresentacion();
            }
        });
    }
}
