/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Sergi
 */
public class ObjectStreamEn {

    //DECLARACIONES
    //declaración variable entera
    private int numero;
    //declaración objeto ObjectInputStream
    private ObjectInputStream OSIn;

    public ObjectStreamEn(String s) {
        try {
            OSIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(s)));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public int leer() {
        try {
            //lectura primer entero desde el fichero
            numero = (int) OSIn.readObject();
            //bucle de lectura desde el fichero y visualización a nivel
            //de objetos Palabra
//            while (true) {
//                //visualización entero resultante del casting Integer
//                System.out.println(numero);
//                //lectura siguiente entero desde el fichero
//                numero = (int) OSIn.readObject();
//            }
        } catch (EOFException error) {
            //NO HACEMOS NADA - SIGNIFICARÁ QUE EL FICHERO HA SIDO LEIDO
            return -1;
            //COMPLETAMENTE
        } catch (IOException | ClassNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
        return numero;
    }

    public void close() {
        try {
            OSIn.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        } finally {
            try {
                OSIn.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception error) {
                System.out.println(error.toString());
            }
        }
    }
}
