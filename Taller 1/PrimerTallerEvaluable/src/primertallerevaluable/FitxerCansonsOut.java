/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sergi
 */
//CON ESTA CLASE SE ESCRIBEN OBJECTOS CANCION(CLASE OBJECTOUTPUT)
public class FitxerCansonsOut {

    private ObjectOutputStream fichero = null;

    public FitxerCansonsOut(String nombreFichero) {
        try {
            //se establece el enlace con el fichero a través de un objeto ObjectOutputStream
            fichero = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(nombreFichero)));
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //Grabación de un objeto Canso en el fichero
    public void escritura(Canso objeto) {
        try {        
            fichero.writeObject(objeto);
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //cierre enlace con el fichero
    public void cierre() {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
