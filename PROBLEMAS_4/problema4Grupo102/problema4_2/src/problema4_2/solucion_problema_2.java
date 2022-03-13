/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4_2;

import java.io.File;

/**
 *
 * @author Sergi
 */
public class solucion_problema_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_2().inicio();
    }

    private void inicio() {
        //Declarar clases necesarias para la lectura y escritura de ficheros
        FicheroObjetosLibroIn ficheroLectura;
        FicheroObjetosLibroOut ficheroNuevo;
        //Declarar variables necesarias
        int codigo;
        int cambio_anyo;
        Libro libro;
        String archivo = "libros.dat";
        String archivotemporal = "ficherotemporal.dat";
        boolean libro_encontrado = false;
        try {
            //Pedir al usuario que selecione el codigo del libro 
            //con el que desea operar
            System.out.print("ESCRIBA EL CODIGO DEL LIBRO QUE DESEA MODIFICAR: ");
            codigo = LT.readInt();
            //Instanciar clases a utilizar
            ficheroLectura = new FicheroObjetosLibroIn(archivo);
            ficheroNuevo = new FicheroObjetosLibroOut(archivotemporal);
            try {
                //Leer primer objecto(Libro) de fichero
                libro = ficheroLectura.lectura();
                //Mientras no sea final de fichero(Centinela), entrar en el bucle
                while ((!libro.esCentinela())) {
                    //Si el codigo del libro leido coincide con el del usuario,
                    //dar la posibilidad de que el usuario modifique el año 
                    //de publicacion del libro
                    if (codigo == libro.getCodigo()) {
                        //Pedir usuario que año desea poner
                        System.out.print("ESCRIBA EL NUEVO AÑO DE PUBLICACION: ");
                        cambio_anyo = LT.readInt();
                        //Modificar año publicacion
                        libro.setAnyoPublicacion(cambio_anyo);
                        //Libro encontrado = true
                        libro_encontrado = true;
                        //Visualizar el libro con el atributo modificado
                        System.out.println("EL LIBRO QUEDARÍA ASI:");
                        System.out.println(libro.toString());
                    }
                    //Escribir libro en fichero
                    ficheroNuevo.escritura(libro);
                    //leer el siguiente libro
                    libro = ficheroLectura.lectura();
                }
                //Si no existe el libro que desea modificar Informar al usuario
                if (!libro_encontrado) {
                    System.out.println("EL LIBRO QUE HA SELCCIONADO NO EXISTE");
                }
                //Escribir el centinela
                ficheroNuevo.escritura(Libro.getCentinela());               
            } catch (Exception error) {
                System.out.println("ERROR: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    ficheroLectura.cierre();
                    ficheroNuevo.cierre();
                    //Borrar fichero antiguo
                    File fich = new File(archivo);
                    fich.delete();
                    //Cambiar nombre fichero temporal al nombre del fichero original
                    File fich2 = new File(archivotemporal);
                    File fich3 = new File(archivo);
                    fich2.renameTo(fich3);
                } catch (Exception error) {
                    System.out.println("ERROR: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
