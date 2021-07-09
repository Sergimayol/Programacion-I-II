/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroLecturaMunicipio {

    private BufferedReader br;
    private FileReader fr;

    public FicheroLecturaMunicipio(String nombreFichero) {
        try {
            fr = new FileReader(nombreFichero);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception abriendo fichero:"
                    + " " + nombreFichero + " error: " + ex);
        }
    }

    //Lectura de objetos Municipios
    public Municipio lectura() {
        String linea = null;
        Municipio municipio = new Municipio();
        try {
            //lectura titulo municipio
            linea = br.readLine();
            if (linea != null) {
                municipio.setMunicipio(linea);
            } else {
                //se ha llegado al final del fichero y por lo tanto se devuelve
                //el objeto Municipio centinela
                return Municipio.getCentinela();
            }
            municipio.setIsla(br.readLine());
            municipio.setSuperficie(Double.parseDouble(br.readLine()));
            municipio.setPoblacion(Integer.parseInt(br.readLine()));
            municipio.setAnyo(Integer.parseInt(br.readLine()));
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        //devolución del objeto Municipio leido
        return municipio;
    }

    // Método de lectura un int del fichero. 
    public int leer() {
        int x = 0;
        try {
            x = br.read();
        } catch (IOException e) {
            System.out.println("Exception leyendo fichero error: " + e);
        }
        return x;
    }

    //Método de cierre de enlace con fichero.
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
