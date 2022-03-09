/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas3;

/**
 *
 * @author Sergi
 */
public class Problemas3 {

    private void inicio() {
        boolean fin = false;
        while (!fin) {
            busqueda_libro();
            fin = !continuar();
        }
    }

    public static void main(String[] args) {
        new Problemas3().inicio();
    }

    private void busqueda_libro() {
        //DECLARACIONES
        //declaración objeto FicheroObjetosLibroIn
        FicheroObjetosLibroIn fichero;
        //declaración objeto Libro;
        Libro libro;
        //declaración variable entera para representar el código del libro
        //a buscar
        int codigo;
        //declaración variable booleana para controlar si el libro buscado
        //ha sido encontrado o no
        boolean encontrado = false;

        try {
            //mensaje usuario para iontroducir código de libro a buscar
            System.out.print("INTRODUCIR CÓDIGO DE LIBRO A BUSCAR: ");
            //lectura del código del libro a buscar
            codigo = LT.readInt();
            //instanciación objeto FicheroObjetosLibroIn para establecer el
            //enlace con el fichero libros.dat
            fichero = new FicheroObjetosLibroIn("libros.dat");
            try {
                //lectura primer obejto Libro desde el fichero
                libro = fichero.lectura();
                //bucle de lectura y tratamiento
                while ((!libro.esCentinela()) && (!encontrado)) {
                    //tratamiento libro leido
                    if (codigo == libro.getCodigo()) {
                        //asignar a encontrado el valor true
                        encontrado = true;
                    } else {
                        //lectura siguiente libro
                        libro = fichero.lectura();
                    }
                }
                //verificar si libro ha sido encontrado
                if (!encontrado) {
                    System.out.println("EL LIBRO BUSCADO NO EXISTE");
                } else {
                    //el libro ha sido encontrado, por lo tanto, 
                    //vamos avisualizarlo
                    System.out.println(libro.toString());
                }
            } catch (Exception error) {
                System.out.println("ERROR: " + error.toString());
            } finally {
                //cierre del enlace fichero
                try {
                    fichero.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR CIERRE FICHERO" + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
    //MÉTODO QUE SOLICITA RESPUESTA PARA CONTINUAR O NO CON LA OPCIÓN ELEGIDA

    private boolean continuar() {
        //DECLARACIONES
        //declaración variable char para obtener la respuesta pro teclado
        char respuesta = 'n';

        try {
            //mensaje para continuar o no
            System.out.print("CONTINUAR (s/n):  ");
            //lectura respuesta
            respuesta = LT.readChar();
            //devolver respuesta           
        } catch (Exception error) {
            System.out.println("ERROR CONTINUAR: " + error.toString());
        }
        return ((respuesta == 's') || (respuesta == 'S'));
    }
}
