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
public class Racional {

    private double numero_Racional;
    private double numero_Racional2;

    public Racional() {
        numero_Racional = 0;
        numero_Racional2 = 0;
    }

    public double lecturaRacional() {
        System.out.println("Introduce un número racional");
        System.out.print("Número: ");
        numero_Racional = LT.readDouble();
        return numero_Racional;
    }

    @Override
    public String toString() {
        String temporal = "";
        for (int indice = 0; indice < numero_Racional; indice++) {
//            temporal = temporal + caracteres[indice];
        }
        return temporal;
    }

    public double sumaRacional(double i, double j) {
        numero_Racional = i;
        numero_Racional2 = j;
        if(j<=0){
            System.out.println("Número");
        }
        return numero_Racional+numero_Racional2;
    }

    public double cambioSigno(double i) {
        return -i;
    }

    public double restaRacional(double i, double j) {
        return i-j;

    }

    public double productoRacional(double i, double j) {
        return i*j;

    }

    public double divisionRacional(double i, double j) {
        return i/j;

    }
}
