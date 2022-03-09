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
public class Tratar_probl {

    //Declaración atributo de clase constante caracter que reprenseta 
    //el final de una secuencia introducida por teclado
    private final char finalsec = '.';
    //Declaración atributo de clase constante caracter que reprenseta 
    //el espacio en blnaco
    private final char blanco = ' ';
    //Contiene una letra de la frase introducida por teclado
    private char letra;
    //Contiene la frase introducida por teclado
    private char[] frase;
    //Contiene la posición del carácter en la frase
    private int ind = 0;

    //Este método resuelve el problema 1
    public void op1() {
        //Instaciar las clases que se van a utilizar
        LT tec = new LT();
        FicheroSal FsalP = new FicheroSal(new Palabra("palabrasPares1.txt".toCharArray()));
        FicheroSal FsalI = new FicheroSal(new Palabra("palabrasImpares1.txt".toCharArray()));
        //Escribir por consola un mensaje para que el usuario sepa que debe hacer
        System.out.println("Introduzca una frase acabada en '" + finalsec + "'");
        System.out.print("Frase: ");
        //Guardar frase introducida
        frase = tec.llegirLiniaA();
        //Asignar a letra el primer caracter de la frase
        letra = frase[ind++];
        //Saltarse todos los espacios en blanco
        saltarEsp();
        //Mientras que letra no sea final de secuencia
        while (letra != finalsec) {
            //Leer palabra
            Palabra Pal = leerPal();
            //Si la palabra leida tiene un número par de caracteres, 
            //se escribe en el fichero de caracteres par
            if (Pal.numeroParDeCaracteres()) {
                FsalP.escribirPal(Pal);
                FsalP.escribir_espacio();
                //Sino se escribe en el fichero de caracteres impar
            } else {
                FsalI.escribirPal(Pal);
                FsalI.escribir_espacio();
            }
            //Volver a saltarse espacios en blanco
            saltarEsp();
        }
        //Cerrar archivos
        FsalI.close();
        FsalP.close();
    }

    //Este método resuelve el problema 2
    public void op2() {
        //Instaciar las clases que se van a utilizar
        FicheroEn Fen = new FicheroEn(new Palabra("palabras2.txt".toCharArray()));
        FicheroSal FsalP = new FicheroSal(new Palabra("palabrasPares2.txt".toCharArray()));
        FicheroSal FsalI = new FicheroSal(new Palabra("palabrasImpares2.txt".toCharArray()));
        //Leer primera palabra del fichero
        Palabra pal = Fen.leerP();
        //Mientras la palabra leida no sea final de fichero, entra en el bucle
        while (!pal.vacia()) {
            //Si la palabra leida tiene un número par de caracteres, 
            //se escribe en el fichero de caracteres par    
            if (pal.numeroParDeCaracteres()) {
                FsalP.escribirPal(pal);
                FsalP.escribir_saltolinea();
                //Sino se escribe en el fichero de caracteres impar
            } else {
                FsalI.escribirPal(pal);
                FsalI.escribir_saltolinea();
            }
            //Se lee la siguiente palabra del fichero
            pal = Fen.leerP();
        }
        //Cerrar archivos
        Fen.close();
        FsalI.close();
        FsalP.close();
    }

    //Este método resuelve el problema 3
    public void op3() {
        //Instaciar la clase que se va a utilizar
        FicheroEn Fen = new FicheroEn(new Palabra("palabras3.txt".toCharArray()));
        //Leer primera palabra del fichero
        Palabra pal = Fen.leerP();
        //Mientras la palabra leida no sea final de fichero, entra en el bucle
        while (!pal.vacia()) {
            //Si contiene las 5 vocales y no se repiten,
            //se imprime por consola la palabra que cumple la condicion
            if (pal.tieneLasCincoVocales()) {
                System.out.println(pal);
            }
            //Se lee la siguiente palabra del fichero
            pal = Fen.leerP();
        }
        //Cerrar archivos
        Fen.close();
    }

    //Este método resuelve el problema 4
    public void op4() {
        //Instaciar las clases que se van a utilizar
        FicheroEn Fen = new FicheroEn(new Palabra("palabras4.txt".toCharArray()));
        FicheroSal Fsal_1_10 = new FicheroSal(new Palabra("palabras4_1_10.txt".toCharArray()));
        FicheroSal Fsal_11_20 = new FicheroSal(new Palabra("palabras4_11_20.txt".toCharArray()));
        //Leer primera palabra del fichero
        Palabra pal = Fen.leerP();
        //Mientras la palabra leida no sea final de fichero, entra en el bucle
        while (!pal.vacia()) {
            //Si la palabra leida tiene de 1 a 10 caracteres se guarda en el fichero
            if ((pal.longitud() >= 1) && (pal.longitud() <= 10)) {
                Fsal_1_10.escribirPal(pal);
                Fsal_1_10.escribir_saltolinea();
                //Si la palabra leida tiene de 11 a 20 caracteres se guarda en el fichero
            } else if ((pal.longitud() >= 11) && (pal.longitud() <= 20)) {
                Fsal_11_20.escribirPal(pal);
                Fsal_11_20.escribir_saltolinea();
            }
            //Se lee la siguiente palabra del fichero
            pal = Fen.leerP();
        }
        //Cerrar archivos
        Fen.close();
        Fsal_1_10.close();
        Fsal_11_20.close();
    }

    private void bucle_op5(Palabra fichero) {
        //Instaciar las clases que se van a utilizar
        //A través del parametro fichero, se decide que fichero leer
        FicheroEn Fen = new FicheroEn(fichero);
        FicheroSal Fsal_vocales = new FicheroSal(new Palabra("palabras5_MasVocales.txt".toCharArray()));
        FicheroSal Fsal_consonantes = new FicheroSal(new Palabra("palabras5_MasConsonantes.txt".toCharArray()));
        FicheroSal Fsal_iguales = new FicheroSal(new Palabra("palabras5_Iguales.txt".toCharArray()));
        //Leer primera palabra del fichero
        Palabra pal1 = Fen.leerP();
        //Mientras la palabra leida no sea final de fichero, entra en el bucle
        while (!pal1.vacia()) {
            //Si hay más vocales que consonantes se guarda en el fichero correspondiente
            if (pal1.numeroVocales() > pal1.numeroConsonantes()) {
                Fsal_vocales.escribirPal(pal1);
                Fsal_vocales.escribir_espacio();
                //Si hay las mimas vocales que consonantes se guarda en el fichero correspondiente
            } else if (pal1.numeroVocales() == pal1.numeroConsonantes()) {
                Fsal_iguales.escribirPal(pal1);
                Fsal_iguales.escribir_espacio();
                //Si hay más consonantes que vocales se guarda en el fichero correspondiente
            } else if (pal1.numeroVocales() < pal1.numeroConsonantes()) {
                Fsal_consonantes.escribirPal(pal1);
                Fsal_consonantes.escribir_espacio();
            }
            //Se lee la siguiente palabra del fichero
            pal1 = Fen.leerP();
        }
        //Cerrar archivos
        Fen.close();
        Fsal_vocales.close();
        Fsal_consonantes.close();
        Fsal_iguales.close();
    }

    //Este método resuelve el problema 5
    public void op5() {
        //Instaciar las clases que se van a utilizar
        Palabra pal = new Palabra("palabras5_1.txt".toCharArray());
        Palabra pal2 = new Palabra("palabras5_2.txt".toCharArray());
        bucle_op5(pal);
        bucle_op5(pal2);
    }

    //Este método tiene la ultilidad de saltarse espacios en blancos
    private void saltarEsp() {
        while (letra == blanco) {
            letra = frase[ind++];
        }
    }

    //Este método tiene la utilidad de leer una palabra y devolver  
    //la palabra leida
    private Palabra leerPal() {
        Palabra aux = new Palabra();
        while ((letra != blanco) && (letra != finalsec)) {
            aux.añadir(letra);
            letra = frase[ind++];
        }
        return aux;
    }
}
