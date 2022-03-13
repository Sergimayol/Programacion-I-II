/*
 * CALSE FicheroGruposInOut AGLUTINA LAS DECLARACIONES Y LAS FUNCIONALIDADES
 * QUE POSIBILITAN LA LECTURA Y ESCRITURA DE OBJETOS Grupos UTILIZANDO LA
 * CLASE RandomAccessFile.

 * NOTA: ES IMPORTANTE TENER EN CUENTA LA CORRESPONDENCIA EXISTENTE ENTRE EL
 * ATRIBUTO codigo DE UN OBJETO Grupos CON SU POSICIÓN EN EL FICHERO DONDE
 * ESTÁ CONTENIDO.

autor: Juan Montes de Oca
 */
package practicas1;

import java.io.*;

public class FicheroGrupoInOut {

    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Grupos desde/en fichero
    private RandomAccessFile fichero = null;
    //declaración objeto Grupos
    private Grupos grupos = new Grupos();

    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public FicheroGrupoInOut(String nombreFichero) throws Exception {
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero, "rw");
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //MÉTODOS FUNCIONALES
    //método lectura que posibilita la lectura de un objeto Grupos desde el
    //fichero
    public Grupos lectura() {
        //DECLARACIONES
        //declaración objeto Grupos
        Grupos grupos = new Grupos();
        //ACCIONES
        try {
            grupos.setCurados(fichero.readInt());
            grupos.setDifuntos(fichero.readInt());
            grupos.setInfectados(fichero.readInt());
            grupos.setSanos(fichero.readInt());
        } catch (EOFException error) {
            return null;
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return grupos;
    }

    //método escritura que posibilita la escritura de un objeto Grupos en el
    //fichero
    public void escritura(Grupos grupos) {
        try {
            //obtención y asignación del atributo codigo que le corresponde al
            //nuevo objeto Grupos a grabar en el fichero
//            grupos.setCodigo(getNuevoCodigo());
            //escritura en el fichero del atributo código correspondiente al
            //objeto grupos 
            fichero.writeInt(grupos.getSanos());
            fichero.writeInt(grupos.getInfectados());
            fichero.writeInt(grupos.getCurados());
            fichero.writeInt(grupos.getDifuntos());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método getNuevoCodigo() devuelve el código que hay que asignar al nuevo
    //objeto Grupos a grabar en el fichero
    public int getNuevoCodigo() {
        //DECLARACIONES
        //declaración variable entera para representar nuevo código
        int codigo = 0;

        try {
            //posicionamiento puntero del fichero para escribir el nuevo objeto
            //Grupos dado al final del fichero
            fichero.seek(fichero.length());
            //obtención y asignación del atributo codigo que le corresponde al
            //nuevo objeto Grupos a grabar en el fichero
            codigo = ((int) (fichero.length() / Grupos.getDimension()) + 1);
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return codigo;
    }

    //cierre del enlace con el fichero
    public void cierre() throws Exception {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

}
