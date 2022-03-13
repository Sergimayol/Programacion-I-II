/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4_2;

/**
 *
 * @author Sergi
 */
public class solucion_problema_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_1().inicio();
    }

    private void inicio() {
        //Declarar clases necesarias para lectura y escritura de fichero
        FicheroObjetosLibroIn ficheroLeido;
        FicheroObjetosLibroOut fichero_sigloXX;
        FicheroObjetosLibroOut fichero_sigloXXI;
        //Declarar variables necesarias
        final int final_sigloXIX = 1900;
        final int final_sigloXX = 2000;
        final int final_sigloXXI = 2100;
        Libro libro;
        try {
            //Instanciar clases de lectura y escritura de ficheros
            ficheroLeido = new FicheroObjetosLibroIn("libros.dat");
            fichero_sigloXX = new FicheroObjetosLibroOut("libros_sigloXX.dat");
            fichero_sigloXXI = new FicheroObjetosLibroOut("libros_sigloXXI.dat");
            try {
                //Leer primer libro
                libro = ficheroLeido.lectura();
                //Mientras no sea final de texto(null) entre en el bucle
                while (libro != null) {
                    //Si el año de publicacion del libro leido es del siglo XX 
                    //se escribe en el fichero libros_sigloXX.dat
                    if ((libro.getAnyoPublicacion() > final_sigloXIX)
                            && (libro.getAnyoPublicacion() <= final_sigloXX)) {
                        fichero_sigloXX.escritura(libro);
                        //Si el año de publicacion del libro leido es del siglo XXI
                        //se escribe en el fichero libros_sigloXXI.dat
                    } else if (libro.getAnyoPublicacion() <= final_sigloXXI) {
                        fichero_sigloXXI.escritura(libro);
                    }
                    //Leer siguiente libro
                    libro = ficheroLeido.lectura();
                }
            } catch (Exception error) {
                System.out.println("ERROR: " + error.toString());
            } finally {
                //cierre del enlace fichero
                try {
                    ficheroLeido.cierre();
                    fichero_sigloXX.cierre();
                    fichero_sigloXXI.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR CIERRE FICHERO " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
