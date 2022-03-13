/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas5;

/**
 *
 * @author Sergi
 */
public class EscrituraEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EscrituraEstudiantes().inicio();
    }

    private void inicio() {
        //DECLARACIONES
        //declaración objeto FicheroElementoInOut
        FicheroEstudianteInOut fichero;
        //declaración objeto Elemento
        Estudiante elemento = new Estudiante();
        //declaracion variable booleana para controlar el fin de lecturas
        boolean finEscritura = false;

        try {
            //delaración objeto FicheroElementoInOut para posibilitar la escritura
            //de un objeto Contacto en el fichero
            fichero = new FicheroEstudianteInOut("estudiantes.dat");
            //bucle escritura
            while (!finEscritura) {
                //lectura del objeto Contacto desde el teclado
                elemento.lectura();
                //escritura del objeto Contacto leido en el fichero
                fichero.escritura(elemento);
                //solicitud confirmación de continuar
                finEscritura = !continuar();
            }
            //cierre del enlace con el fichero
            fichero.cierre();
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
    
    //MÉTODO QUE SOLICITA RESPUESTA PARA CONTINUAR O NO 
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
