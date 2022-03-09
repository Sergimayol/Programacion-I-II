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
public class Visualizacion_libros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Visualizacion_libros().metodoPrincipal();
    }
    //declaración metodoPrincipal

    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto Libro
        Libro libro;
        //declaración objeto FicheroObjetosLibroIn
        FicheroObjetosLibroIn fichero;

        //ACCIONES
        try {
            //establecimiento enlace con fichero instanciación objeto FicheroObjetosLibroIn
            fichero = new FicheroObjetosLibroIn("libros.dat");
            try {
                //lectura primeri libro
                libro = fichero.lectura();
                while (!libro.esCentinela()) {
                    //visualización libro leido
                    System.out.println(libro.toString() + "\n");
                    //lectura siguiente libro
                    libro = fichero.lectura();
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
}
