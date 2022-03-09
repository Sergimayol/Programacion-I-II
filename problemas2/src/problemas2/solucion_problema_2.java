/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

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
        //Instanciar la clase necesaria
        DataStreamSal DSSal = new DataStreamSal("primerosEnterosPosistivos.dat");
        //Declarar varible que indique el numero de elementos que deseamos escribir
        final int NUMERO_ELEMENTOS = 1000;
        //Generar los primeros 1000 enteros positivos
        for (int i = 0; i < NUMERO_ELEMENTOS; i++) {
            //Escribirlos en el fichero primerosEnterosPosistivos.dat
            DSSal.escribirEnteros(i);
        }
        //Cerrar DataOutputStream
        DSSal.close();
    }

}
