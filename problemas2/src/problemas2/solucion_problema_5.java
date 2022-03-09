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
public class solucion_problema_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_5().inicio();
    }

    private void inicio() {
        //Instanciar clases necesarias
        ObjectStreamSal OSSal = new ObjectStreamSal("numerosRacionales.dat");
        Racional rc = new Racional();
        //Declarar variable necesarias
        int contador = 0;
        double numero;
        //Leer primer numero
        numero = rc.lecturaRacional();
        //Mientras no se superen los 10 numeros pedidos, entrar en el bucle
        while (contador <= 10) {
            //Escribirlo en fichero numerosRacionales.dat
            OSSal.escribir(numero);
            //Incrementar contador
            contador++;
            //Leer siguiente numero
            numero = rc.lecturaRacional();
        }
        //Cerrar enlaces
        OSSal.close();
    }
}
