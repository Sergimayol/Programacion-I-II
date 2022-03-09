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
public class solucion_problema_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_3().inicio();
    }

    private void inicio() {
        //Instanciar clase de lectura y escritura
        DataStreamEn DSEn = new DataStreamEn("primerosEnterosPosistivos.dat");
        DataStreamSal DSSal = new DataStreamSal("primos.dat");
        //Declarar e iniciar variable necesarias
        int numero_leido;
        //Leer primer numero
        numero_leido = DSEn.leerEntero();
        //Mientras no sea final de fichero
        while (numero_leido != DSEn.getFinal_texto()) {
            //Si el numero es primo escribirlo en el fichero primos.dat
            if (esNumeroPrimo(numero_leido)) {
                System.out.println(numero_leido);
                DSSal.escribirEnteros(numero_leido);
            }
            //Leer siguiente numero
            numero_leido = DSEn.leerEntero();
        }
        //Cerrar DataInputStream y DataOutputStream  
        DSEn.close();
        DSSal.close();
    }

    //ARREGLARLO MAÑANA
    private boolean esNumeroPrimo(int o) {
        boolean primo = false;
        int MAX = 1000;
        for (int i = o; (i < MAX); i++) {
            primo = true;
            for (int j = 2; (j < i) && primo; j++) {
                if (i % j == 0) {
                    primo = false;
                }
            }
        }
        return primo;
    }
}
