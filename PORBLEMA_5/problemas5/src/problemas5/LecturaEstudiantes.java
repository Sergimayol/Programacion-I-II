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
public class LecturaEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LecturaEstudiantes().inicio();
    }

    private void inicio() {
//DECLARACIONES
        //declaración objeto FicheroElementoInOut
        FicheroEstudianteInOut fichero;
        //declaración objeto Elemento
        Estudiante elemento;
        //ACCIONES
        try {
            //borrado de la ventana de visualización
            borrarPantalla("VISUALIZACIÓN ELEMENTOS CONTENIDOS EN EL FICHERO");
            //declaración objeto FicheroContactoInOut para posibilitar la
            //lectura desde el fichero
            fichero = new FicheroEstudianteInOut("estudiantes.dat");
            try {
                //lectura del primer objeto Elemento desde el fichero
                elemento = fichero.lectura();
                //bucle de lectura y visualización
                while (elemento != null) {
                    //visualización objeto Elemento leido
                    System.out.print(elemento.toString() + "\n");
                    //lectura siguiente objeto Elemento desde el fichero  
                    elemento = fichero.lectura();
                }
            } catch (Exception error) {
                //SE HA TERMINADO EL FICHERO
            } finally {
                try {
                    //cierre del enlace del fichero
                    fichero.cierre();
                } catch (Exception error) {
                    System.out.println("ENLACE FICHERO YA CERRADO");
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
    
    //MÉTODO QUE BORRA LA VENTANA DE VISUALIZACIÓN Y VISUALIZA EL TÍTULO DE LA
    //APLICACIÓN
    private void borrarPantalla(String mensaje) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("<<<<<<" + mensaje + ">>>>>>\n\n");
    }
}
