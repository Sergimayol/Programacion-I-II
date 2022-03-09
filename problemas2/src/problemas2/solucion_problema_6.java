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
public class solucion_problema_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_6().inicio();
    }

    private void inicio() {
        ObjectStreamEn OSEn = new ObjectStreamEn("numerosRacionales.dat");
        int numero = OSEn.leer();
        while (numero != -1) {
            System.out.println(numero);
            numero = OSEn.leer();
        }
        OSEn.close();
    }

}
