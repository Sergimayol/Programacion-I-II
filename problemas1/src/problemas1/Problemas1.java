/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas1;

/**
 *
 * @author Sergi
 */
public class Problemas1 {

    private void inicio() {
        char opc = ' ';
        while (opc != 's') {
            opc = menu();
        }
    }

    public static void main(String[] args) {
        (new Problemas1()).inicio();
    }

    private char opcion_menu() {
        LT tec = new LT();
        Character res = ' ';
        System.out.println("Dispone de estas opciones: ");
        System.out.println(" a ==> Resolución Problema 1");
        System.out.println(" b ==> Resolución Problema 2");
        System.out.println(" c ==> Resolución Problema 3");
        System.out.println(" d ==> Resolución Problema 4");
        System.out.println(" e ==> Resolución Problema 5");
        System.out.println(" s ==> Salir del programa.");
        System.out.println("¿Cual desea selecionar?");
        res = tec.llegirCaracter();
        if (res == null) {
            res = 'J';
        }
        while ((res != 'a') && (res != 'b') && (res != 'c') && (res != 'd')
                && (res != 's') && (res != 'e')) {
            System.out.println("Opción incorrecta. Selecione una de las opciones.");
            res = tec.llegirCaracter();
            if (res == null) {
                res = 0;
            }
        }
        return res;
    }

    private char menu() {
        Tratar_probl Tratar = new Tratar_probl();
        char opc = opcion_menu();
        switch (opc) {
            case 'a':
                System.out.println(" ");
                Tratar.op1();
                System.out.println("Problema 1 resuelto.");
                System.out.println(" ");
                break;

            case 'b':
                System.out.println(" ");
                Tratar.op2();
                System.out.println("Problema 2 resuelto.");
                System.out.println(" ");
                break;

            case 'c':
                System.out.println(" ");
                Tratar.op3();
                System.out.println("Problema 3 resuelto.");
                System.out.println(" ");
                break;

            case 'd':
                System.out.println(" ");
                Tratar.op4();
                System.out.println("Problema 4 resuelto.");
                System.out.println(" ");
                break;

            case 'e':
                System.out.println(" ");
                Tratar.op5();
                System.out.println("Problema 5 resuelto.");
                System.out.println(" ");
                break;

            case 's':
                System.out.println("Cerrando programa, Adiós.");
                break;
        }
        return opc;
    }
}
