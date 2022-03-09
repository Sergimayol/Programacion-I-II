package problemas3;

/*
CLASE FicheroObjetosPalabraOutAdd
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Palabra A NIVEL DE ESCRITURA POSIBILITANDO, SI EL FICHERO
FÍSICO YA EXISTE, EL AÑADIR LOS OBJETOS EN ÉL.
autor: Juan Montes de Oca
 */
import java.io.*;

public class FicheroObjetosLibroOutAdd {

    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee crear un fichero nuevo
    private ObjectOutputStream fichero1 = null;
    //declaración objeto AdicionObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos cuando se desee añadir objetos en un fichero ya existente
    private AdicionObjectOutputStream fichero2 = null;

    //MÉTODO CONSTRUCTOR
    public FicheroObjetosLibroOutAdd(String nombreFichero) {
        try {
            //declaración objeto File que enlace con el fichero dado por parámetro
            File F = new File(nombreFichero);
            if (F.exists()) {
                //instanciación objeto AdicionObjectOutputStream con el fichero dado
                //para posibilitar la adición de objetos  en dicho fichero
                fichero2 = new AdicionObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero, true)));
            } else {
                //instanciación objeto ObjectOutputStream con el fichero dado
                //para posibilitar la escritura de objetos en dicho fichero que será creado
                //como nuevo
                fichero1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreFichero)));
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //MÉTODOS FUNCIONALES
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO Libro EN EL FICHERO
    //ENLAZADO CON EL OBJETO FicheroObjetosPalabraOutAdd
    public void escritura(Libro libro) {
        try {
            //verificar si el fichero es de nueva creación o es un fichero, ya existente, donde
            //se está añadiendo un nuevo objeto Libro
            if (fichero2 == null) {
                //escritura objeto Libro dado
                fichero1.writeObject(libro);
            } else {
                //escritura objeto Libro dado
                fichero2.writeObject(libro);
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }

    }

    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el fichero es de nueva creación o es un fichero, ya existente, donde
            //se está añadiendo un nuevo objeto Libro
            if (fichero2 == null) {
                fichero1.close();
            } else {
                fichero2.close();
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
