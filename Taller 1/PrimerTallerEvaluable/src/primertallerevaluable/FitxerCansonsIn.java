/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Sergi
 */
//CON ESTA CLASE SE LEEN OBJECTOS CANCION(CLASE ObjectInputStream)
public class FitxerCansonsIn {

    //ATRIBUTOS
    private ObjectInputStream fichero = null;

    //MÉTODO CONSTRUCTOR
    public FitxerCansonsIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream
                    (new FileInputStream(nombreFichero)));
        } catch (FileNotFoundException error) {
            System.out.println("ERROR (Fichero no existe): " + error.toString());
        } catch (IOException error) {
            System.out.println("ERROR abriendo fichero: " + error.toString());
        }
    }

    //lectura objeto Canso desde fichero
    public Canso lectura() {
        //declaración objeto Canso para alamacenar el objeto Canso a leer desde el fichero
        Canso cancion = new Canso();
        try {
            //lectura objeto Canso leido desde el fichero
            cancion = (Canso) fichero.readObject();
        } catch (EOFException error) {
//            System.out.println("(FitxerCansonsIn,lectura)ERROR lectura 1: " + error.toString());
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        } catch (ClassNotFoundException | IOException error) {
            System.out.println("(FitxerCansonsIn,lectura)ERROR lectura 2: " + error.toString());
        }
        //devolución objeto Canso leido desde el fichero
        return cancion;
    }

    //cierre enlace con fichero
    public void cierre() {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR cerrando fichero: " + error.toString());
        }
    }
}
