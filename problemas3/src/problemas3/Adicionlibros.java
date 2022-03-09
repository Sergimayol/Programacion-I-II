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
public class Adicionlibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Adicionlibros().inicio();
    }

    //declaración metodoPrincipal
    public void inicio() {
        //DECLARACIONES
        //declaración objeto Libro
        Libro libro;
        //declaración objeto FicheroObjetosLibroOut
        FicheroObjetosLibroOutAdd fichero;
        //declaración variable booleana para controlar el final del programa
        boolean fin = false;

        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosLibroOut
            fichero = new FicheroObjetosLibroOutAdd("libros.dat");
            try {
                while (!fin) {
                    //mensaje usuario solicitando introducir texto por teclado
                    System.out.println("INTRODUCIR DATOS LIBRO CODIGO ");
                    //instanciación objeto Libro
                    libro = new Libro();
                    //lectura libro
                    libro.lectura();
                    //grabar objeto Libro leido en el fichero
                    fichero.escritura(libro);
                    fin = !continuar();
                }
                //grabar objeto Libro centinela
                fichero.escritura(Libro.getCentinela());
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

        //ACCIONES
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
