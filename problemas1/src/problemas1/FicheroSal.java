/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class FicheroSal {

    private Palabra F;
    private FileWriter Fw;
    private BufferedWriter Bw;

    public FicheroSal(Palabra P) {
        F = P;
        try {
            Fw = new FileWriter(F.toString(), true);
            Bw = new BufferedWriter(Fw);
        } catch (IOException ex) {
            System.out.println("Exception abriendo fichero:"
                    + " " + F + " error: " + ex);
        }
    }

    //Escribir un objeto palabra en el fichero
    public void escribirPal(Palabra P) {
        try {
            Bw.write(P.toString());
        } catch (IOException ex) {
            System.out.println("Exception escribiendo fichero:"
                    + " " + F + " error: " + ex);
        }
    }

    //Escribir un espacio en blanco
    public void escribir_espacio() {
        try {
            Bw.write(" ");
        } catch (IOException ex) {
            System.out.println("Exception escribiendo fichero:"
                    + " " + F + " error: " + ex);
        }
    }

    //Escribir un salto de linea
    public void escribir_saltolinea() {
        String salto_linea = System.getProperty("line.separator");
        try {
            Bw.write(salto_linea);
        } catch (IOException ex) {
            System.out.println("Exception escribiendo fichero:"
                    + " " + F + " error: " + ex);
        }
    }

    public void close() {
        try {
            Bw.flush();
            Bw.close();
            Fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                Fw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
