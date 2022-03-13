/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4;

import java.io.File;

/**
 *
 * @author Sergi
 */
public class Problema4_eliminacion_logica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Problema4_eliminacion_logica().inicio();
    }

    private void inicio() {
        //Declarar clases necesarias para lectura y escritura de fichero
        FicheroObjetosLibroIn ficheroLeido;
        FicheroObjetosLibroOut ficheroNuevo;
        //Declarar variables necesarias
        int codigo;
        Libro libro;
        boolean libroaborrar = false;
        boolean eliminado = false;
        String archivo = "libros.dat";
        String archivotemporal = "ficherotemporal.dat";
        try {
            //Pedir usuario que libro desea eliminar
            System.out.print("ESCRIBA EL CODIGO DEL LIBRO QUE DESEA ELIMINAR: ");
            codigo = LT.readInt();
            //Instanciar clases de lectura y escritura de ficheros
            ficheroLeido = new FicheroObjetosLibroIn(archivo);
            ficheroNuevo = new FicheroObjetosLibroOut(archivotemporal);
            try {
                //Leer el primer libro
                libro = ficheroLeido.lectura();
                //Mientras no sea final de texto(centinela)
                while (!libro.esCentinela()) {
                    //Si el libro leido no concincide con el libro que se desea eliminar
                    //escribirlo en un fichero nuevo temporal que contendrá el resto 
                    //de libros que no se quieren eliminar
                    if (codigo != libro.getCodigo()) {
                        ficheroNuevo.escritura(libro);
                    } else {
                        //Si el libro leido coincide con el que se desea borrar  
                        //se escribirá en el nuevo fichero temporal con el atributo 
                        //de eliminacion = true 
                        libro.setEstadoLibro(!eliminado);
                        ficheroNuevo.escritura(libro);
                        //Si se encuentra el libro libroaborrar=true
                        libroaborrar = true;
                        //visualizar libro borrado
                        System.out.println("HAS ELIMINADO EL LIBRO:");
                        System.out.println(libro.toString());
                    }
                    //Leer siguiente libro
                    libro = ficheroLeido.lectura();
                }
                //Si no se existe ese libro avisa al usuario
                if (!libroaborrar) {
                    System.out.println("EL LIBRO A BORRAR NO EXISTE");
                }
                //Escribir el centinela
                ficheroNuevo.escritura(Libro.getCentinela());
            } catch (Exception error) {
                System.out.println("ERROR: " + error.toString());
            } finally {
                //cierre del enlace fichero
                try {
                    ficheroLeido.cierre();
                    ficheroNuevo.cierre();
                    //Borrar fichero antiguo
                    File fich = new File(archivo);
                    fich.delete();
                    //Cambiar nombre fichero temporal al nombre del fichero original
                    File fich2 = new File(archivotemporal);
                    File fich3 = new File(archivo);
                    fich2.renameTo(fich3);
                } catch (Exception error) {
                    System.out.println("ERROR CIERRE FICHERO" + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
