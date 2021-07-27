/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS SetzeColors
A NIVEL DE LECTURA
 */
package practicas2;

import java.io.*;

public class FicheroObjetosColoresIn {

    //ATRIBUTOS
    private ObjectInputStream fichero = null;

    //MÉTODO CONSTRUCTOR
    public FicheroObjetosColoresIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }

    }

    //MÉTODOS FUNCIONALES
    //lectura objeto SetzeColors desde fichero
    public SetzeColors lectura() {
        //declaración objeto Palabra para alamacenar el objeto SetzeColors a leer desde el fichero
        SetzeColors colores = null /*= new SetzeColors()*/;

        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            colores = (SetzeColors) fichero.readObject();
        } catch (EOFException error) {
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        } catch (ClassNotFoundException | IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        //devolución objeto SetzeColors leido desde el fichero
        return colores;
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
