/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Libro
A NIVEL DE ESCRITURA
 */
package problema4;

import java.io.*;

public final class FicheroObjetosLibroOut {

    //ATRIBUTOS
    private ObjectOutputStream fichero = null;

    public FicheroObjetosLibroOut(String nombreFichero) {
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

    //grabación de un objeto Libro en el fichero correspondiente
    public void escritura(Libro objeto) {
        try {
            //grabación objeto Libro en fichero 
            fichero.writeObject(objeto);
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //cierre enlace con el fichero
    public void cierre() throws Exception {
        try {
            if (fichero != null) {
                fichero.close();
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
