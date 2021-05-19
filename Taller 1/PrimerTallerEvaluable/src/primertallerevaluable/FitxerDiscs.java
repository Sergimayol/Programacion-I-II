/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Sergi
 */
//CLASE QUE ESCRIBE OBJECTOS DISCO CON LA CLASE RANDOMACCESS FILE
public class FitxerDiscs {

    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Contacto desde/en fichero
    private RandomAccessFile fichero = null;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FitxerDiscs(String nombreFichero) throws Exception {
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero, "rw");
        } catch (FileNotFoundException error) {
            System.out.println("ERROR abriendo fichero: " + error.toString());
        } 
    }

    //método lectura que posibilita la lectura de un objeto Contacto desde el
    //fichero
    public Disc lectura() {
        //DECLARACIONES
        //declaración objeto Contacto
        Disc disco = new Disc();
        //ACCIONES
        try {
            //lectura campo atributo Album del objeto Disc a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            disco.setTituloAlbum(lecturaString(32));
            //lectura campo atributo Artista del objeto Disc a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            disco.setArtista(lecturaString(32));
            //lectura campo atributo edad del objeto Contacto
            disco.setAnyoEdicion(fichero.readInt());
        } catch (EOFException error) {
//            System.out.println("ERROR lectura 1: " + error.toString());
            return null;
        } catch (IOException error) {
            System.out.println("ERROR lectura 2: " + error.toString());
        }
        return disco;
    }

    //método que lleva a cabo la lectura de un String desde el fichero a través 
    //de la lectura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private String lecturaString(int dimension) {
        //DECLARACIONES
        //declaración String para ir concatenando los caracteres que van a ser
        //leidos desde el fichero
        String string = "";
        try {
            //ACCIONES
            //bucle de lectura y concatenación de los caracteres desde el fichero
            for (int i = 0; i < dimension; i++) {
                //concatenación en el Stringcampo del caracter leido desde el
                //fichero
                string = string + fichero.readChar();
            }
        } catch (IOException error) {
//            System.out.println("ERROR lectura String: " + error.toString());
            return string;
        }
        //devolución del String resultante
        return string;
    }

    //método escritura que posibilita la escritura de un objeto Contacto en el
    //fichero
    public void escritura(Disc disco) {
        try {
            //escritura en el fichero del atributo Album. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo Album
            escrituraString(disco.getTituloAlbum(), 32);
            //escritura en el fichero del atributo Artista. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo Artista
            escrituraString(disco.getArtista(), 32);
            //escritura en el fichero del atributo año edición correspondiente al
            //objeto disco 
            fichero.writeInt(disco.getAnyoEdicion());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método que lleva a cabo la escritura de un String en el fichero a través 
    //de la escritura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private void escrituraString(String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en función de la dimensión dada
            for (int i = 0; ((i < dimension) && (i < campo.length())); i++) {
                //escritura en el fichero del caracter i-ésimo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensión del String dado es menor que la dimensión
            //del atributo que debe representar del objeto Contacto
            if (campo.length() < dimension) {
                //al ser la dimnensión del String menor que la dimensión del atributo
                //que representa del objeto Contacto se escribirán caracteres
                //espacio hasta llegar a la dimensión del atributo
                for (int i = 0; i < (dimension - campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //cierre del enlace con el fichero
    public void cierre() {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
