/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergi
 */
public class ObjectStreamSal {

    //DECLARACIONES
    //declaración variable entera
    private int numero;
    //declaración objeto ObjectOutputStream
    private ObjectOutputStream OOutS;
    //declaración variable booleana para controlar el fin del programa
    private boolean fin = false;

    public ObjectStreamSal(String s) {
        try {
            //establecimiento enlace con fichero instanciación objeto ObjectOutputStream
            OOutS = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(s)));
        } catch (IOException ex) {
            Logger.getLogger(ObjectStreamSal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double escribir(double o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
