/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
// CON ESTA CLASE SE LEEN LOS OBJECTOS CANSO DE LOS FICHEROS .TXT
public class FitxerTxtCansonsIn {

    private BufferedReader br;
    private FileReader fr;

    public FitxerTxtCansonsIn(String fichero) {
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException error) {
            System.out.println("(FitxerTxtCansonsIn)Error abriendo fichero:"
                    + " " + fichero + " error: " + error);
        }
    }

    //Leer un objecto Cancion del fichero.
    public Canso leerObjetoCancion() {
        Canso cancion = null;
        boolean bucle = false;
        String linea = "";
        int x = 0;
        try {
            //Se crea un nuevo objecto cancion cada vez que se llama al método
            cancion = new Canso();
            //Leer primera linea del texto
            linea = br.readLine();
            //mientras la linea leida no este vacia, entrar en el bucle
            if (linea != null && !linea.isEmpty()) {
                //Bucle principal de lectura objecto Cancion del fichero
                while (!bucle) {
                    switch (x) {
                        //Primera linea introducir titulo
                        case 0:
                            cancion.setTituloCancion(linea);
                            x++;
                            break;
                        //Segunda linea introducir Artista
                        case 1:
                            cancion.setArtista(linea);
                            x++;
                            break;
                        //Tercera linea introducir Album
                        case 2:
                            cancion.setAlbumPertenece(linea);
                            x++;
                            break;
                        //Cuarta linea introducir genero
                        case 3:
                            cancion.setGenero(linea);
                            x++;
                            break;
                        //Quinta linea introducir Año
                        case 4:
                            cancion.setAnyoEdicion(linea);
                            x++;
                            break;
                        //Segunda linea introducir Data
                        case 5:
                            cancion.setData(linea);
                            x++;
                            bucle = true;
                            break;
                    }
                    if (!bucle) {
                        linea = br.readLine();
                    }
                }
            } else {
                if (linea == null) {
                    cancion = cancion.getCentinela();
                } else {
                    linea = br.readLine();
                }
            }
        } catch (IOException error) {
            System.out.println("(FitxerTxtCansonsIn)Error leyendo objecto: " + error.toString());
        } catch (Exception error) {
            System.out.println("(FitxerTxtCansonsIn)Error leyendo objecto: " + error.toString());
        }
        return cancion;
    }

    public void close() {
        try {
            fr.close(); //Cerrar FileReader
            br.close(); // Cerrar BufferedReader
        } catch (IOException error) {
            System.out.println("(FitxerTxtCansonsIn)Error cerrando fichero: " + error.toString());
        } catch(Exception error){
            System.out.println("(FitxerTxtCansonsIn)Error cerrando fichero: " + error.toString());
        }
    }
}
