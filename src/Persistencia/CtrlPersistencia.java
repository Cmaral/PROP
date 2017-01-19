/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Documento;
import Dominio.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author claudia
 */
public class CtrlPersistencia {
    
    private static HashMap<Pair, Documento> Conjunto;
    
    public CtrlPersistencia() {
        Conjunto = new HashMap<Pair, Documento>();
        cargaConjunto();        
    }
    
     public void guardaConjunto(HashMap<Pair, Documento> Conjunto) {
        try {
            this.Conjunto = Conjunto;
            File datos = new File("datos");
            FileOutputStream fos = new FileOutputStream(datos);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Conjunto);
            oos.flush();
            oos.close();
            fos.close();
        } catch(Exception e) {}
    }

    /* Carga HashMap desde el archivo datos */
    public HashMap<Pair,Documento> cargaConjunto() {
        try {
            File datos = new File("datos");
            FileInputStream fis=new FileInputStream(datos);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Conjunto = (HashMap<Pair, Documento>)ois.readObject();

            ois.close();
            fis.close();
        } catch(Exception e) {}
        return Conjunto;
    }
    
    
    
    
}
