/*
DECLARACIONES Y FUNCIONALIDADES PARA LA GESTIÓN DE FICHEROS DE OBJETOS Persona
A NIVEL DE LECTURA
 */
package practicas1;

import java.io.*;

public class FicheroObjetosPersonaIn {

    //ATRIBUTOS
    private ObjectInputStream fichero = null;

    //MÉTODO CONSTRUCTOR
    public FicheroObjetosPersonaIn(String nombreFichero) {
        try {
            fichero = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreFichero)));
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }

    }

    //MÉTODOS FUNCIONALES
    //lectura objeto Persona desde fichero
    public Persona lectura() {
        //declaración objeto Palabra para alamacenar el objeto Persona a leer desde el fichero
        Persona persona = new Persona();

        //ACCIONES       
        try {
            //lectura objeto Palabra leido desde el fichero
            persona = (Persona) fichero.readObject();
        } catch (EOFException error) {
            //devolución valor null porque hemos llegado al final del fichero
            return null;
        } catch (ClassNotFoundException | IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        //devolución objeto Persona leido desde el fichero
        return persona;
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
