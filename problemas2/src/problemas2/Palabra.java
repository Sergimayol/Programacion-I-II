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
public class Palabra {

    public static final int MAX = 20;
    private int capaci = 20;
    private char[] letra;
    private int longitud;

    public Palabra() {
        letra = new char[capaci];
        longitud = 0;
    }

    public Palabra(char[] s) {
        capaci = s.length;
        letra = new char[capaci];
        longitud = 0;
        for (int i = 0; i < s.length; i++) {
            letra[longitud++] = s[i];
        }
    }

// Devuelve longitud de la palabra
    public int longitud() {
        return longitud;
    }

//Comprueba si un objeto palabra tiene un número par de caracteres
    public boolean numeroParDeCaracteres() {
        return longitud % 2 == 0;
    }

//Añadir letra a una palabra
    public void añadir(char c) {
        if (longitud == capaci) {
            char aux[] = new char[capaci + MAX];
            for (int i = 0; i < capaci; i++) {
                aux[i] = letra[i];
            }
            capaci = capaci + MAX;
            letra = aux;
        }
        letra[longitud++] = c;
    }

//Devuelve si una palabra contiene algo o no
    public boolean vacia() {
        return longitud == 0;
    }

//Convierte palabra a string
    @Override
    public String toString() {
        String msg = "";
        for (int idx = 0; idx < longitud; idx++) {
            msg += letra[idx];
        }
        return msg;
    }

//Comprueba si un objeto palabra contiene las 5 vocales y no se repiten 
    public boolean tieneLasCincoVocales() {
        final char[] VOCALES = {'a', 'e', 'i', 'o', 'u'};
        int[] apariciones = {0, 0, 0, 0, 0};
        for (int indice = 0; indice < longitud; indice++) {
            int i;
            for (i = 0; ((i < VOCALES.length) && (letra[indice] != VOCALES[i])); i++) {
            }
            if (i < VOCALES.length) {
                apariciones[i]++;
            }
        }
        for (int indice = 0; indice < apariciones.length; indice++) {
            if (apariciones[indice] != 1) {
                return false;
            }
        }
        return true;
    }

//Devuelve el numero de vocales que contiene un objeto palabra
    public int numeroVocales() {
        int cont = 0;
        for (int indice = 0; indice < longitud; indice++) {
            if (contieneVocal(letra[indice])) {
                cont++;
            }
        }
        return cont;
    }

//Devuelve el numero de consonantes  que contiene un objeto palabra
    public int numeroConsonantes() {
        return (longitud - numeroVocales());
    }

//Comprueba si un objeto palabra contiene alguna vocal
    private boolean contieneVocal(char car) {
        return ((car == 'a') || (car == 'e') || (car == 'i')
                || (car == 'o') || (car == 'u'));
    }
}
