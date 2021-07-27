package practicas2;

/*
CLASE FicheroObjetosSetzeColorsOut
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS SetzeColors A NIVEL DE ESCRITURA
autor: Juan Montes de Oca
 */
import java.io.*;

public class FicheroObjetosColoresOut {

    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos SetzeColors
    private ObjectOutputStream fichero = null;

    //MÉTODO CONSTRUCTOR
    public FicheroObjetosColoresOut(String nombreFichero) {
        try {
            //instanciación objeto ObjectOutputStream con el fichero dado
            //para posibilitar la escritura de objetos SetzeColors
            fichero = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(nombreFichero)));
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //MÉTODOS FUNCIONALES
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO SetzeColors EN EL FICHERO
    //ENLAZADO CON EL OBJETO FicheroObjetosSetzeColorsOut
    public void escritura(SetzeColors colores) {
        try {
            //escritura objeto SetzeColors dado
            fichero.writeObject(colores);
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }

    }

    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el enlace con el fichero no es null
            if (fichero != null) {
                fichero.close();
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
