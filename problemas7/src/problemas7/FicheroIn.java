/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class FicheroIn {

    private BufferedReader br;
    private FileReader fr;

    public FicheroIn(String nombreFichero) {
        try {
            fr = new FileReader(nombreFichero);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception abriendo fichero:"
                    + " " + nombreFichero + " error: " + ex);
        }
    }

    public String lectura() {
        String linea = "";
        try {
            linea = br.readLine();
            if (linea != null && !linea.isEmpty()) {
                linea = br.readLine();
            } else {
                return null;
            }
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }
        return linea;
    }

    public void close() {
        try {
            fr.close(); //Cerrar FileReader
            br.close(); // Cerrar BufferedReader
        } catch (IOException ex) {
            System.out.println("Exception cerrando fichero: " + ex);
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Exception cerrando fichero: " + e);
            }
        }
    }
}
