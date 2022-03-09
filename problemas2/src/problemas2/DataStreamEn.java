/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class DataStreamEn {

    //DECLARACIONES
    //declaración objeto DataInputStream para posibilitar la lectura de un
    //fichero a nivel de enteros
    private DataInputStream DInS;
    //declaración variable entera para representar los valores enteros a leer
    //en el fichero ficheroEnteros
    private int entero;
    private final int FINAL_TEXTO = -1;

    public DataStreamEn(String s) {
        try {
            DInS = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public int leerEntero() {
        try {
            //lectura primer elemento entero desd el fichero ficheroEnteros.dat
            entero = DInS.readInt();
            //bucle de lectura y visualización
//            if (true) {
//                //visualización entero leido desde el fichero
//                System.out.print(entero + " ");
//            }
        } catch (EOFException ex) {
            return FINAL_TEXTO;
        } catch (IOException error) {
            System.out.println(error.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
        return entero;
    }

    public int getFinal_texto() {
        return FINAL_TEXTO;
    }

    public void close() {
        try {
            DInS.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        } finally {
            try {
                DInS.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception error) {
                System.out.println(error.toString());
            }
        }
    }
}
