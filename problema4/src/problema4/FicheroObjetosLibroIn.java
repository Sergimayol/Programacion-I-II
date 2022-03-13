/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Libro
A NIVEL DE LECTURA
 */
package problema4;

import java.io.*;

public class FicheroObjetosLibroIn {

    //ATRIBUTOS
    private ObjectInputStream fichero = null;

    //MÉTODO CONSTRUCTOR
    public FicheroObjetosLibroIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }

    }

    //MÉTODOS FUNCIONALES
    //lectura objeto Libro desde fichero
    public Libro lectura() {
        //declaración objeto Palabra para alamacenar el objeto Libro a leer desde el fichero
        Libro libro = new Libro();

        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            libro = (Libro) fichero.readObject();
        } catch (EOFException error) {
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        } catch (ClassNotFoundException | IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        //devolución objeto Libro leido desde el fichero
        return libro;
    }

    //cierre enlace con fichero
    public void cierre() throws Exception {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
