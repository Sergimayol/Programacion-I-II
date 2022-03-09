/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class FicheroEn {

    private Palabra F;
    private BufferedReader br;
    private FileReader fr;
    private Character c;

    public FicheroEn(Palabra P) {
        F = P;
        try {
            fr = new FileReader(F.toString());
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception abriendo fichero:"
                    + " " + F + " error: " + ex);
        }
    }

    // Método de lectura carácter a carácter del fichero. 
    public Character leer() {
        int x;
        Character ca = null;
        try {
            x = br.read();
            if (x == -1) {
                ca = null;
            } else {
                ca = (char) x;                
            }
        } catch (IOException e) {
            System.out.println("Exception leyendo fichero: " + F + " error: " + e);
        }
        return ca;
    }   
    
    //Leer una palabra del fichero.
    public Palabra leerP() {
        Palabra aux = new Palabra();
        saltarEsp();
        while ((c != null) && ((c.charValue() >= 65 && c.charValue() <= 90)
                ||(c.charValue() >= 97 && c.charValue() <= 122))) {//valor 65 = A.
            aux.añadir(c);
            c = leer();
        }
        return aux;
    }

    //Saltar espacios en blanco y más
    private void saltarEsp() {
        c = leer();
        while ((c != null) && (c.charValue() <= 32)) { //valor 32 = espacio.
            c = leer();
        }
    }

    public void close() {
        try {
            fr.close(); //Cerrar FileReader
            br.close(); // Cerrar BufferedReader
        } catch (Exception ex) {
            System.out.println("Exception cerrando fichero " + F + ": " + ex);
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("Exception cerrando fichero " + F + ": " + e);
            }
        }
    }
}
