/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta1;

import java.util.Random;

/**
 *
 * @author Sergi
 */
public class Baralla {

    public static final int MAXCARTESPERPAL = 12;
    public static final int MAXCARTES = MAXCARTESPERPAL * 4; // 48 Nombre màxim de cartes 12 cartes * 4 Pals

    private Carta[] b;
    private int n; // Nombre de cartes de la baralla

    public static class NohihaCartes extends Exception {

        public NohihaCartes(String e) {
            super(e);
        }
    }

    // Constructor
    public Baralla() {
        b = new Carta[MAXCARTES];
        n = MAXCARTES;
        int index = 0;
        for (Pal pal : Pal.values()) {
            for (int i = 1; i <= 12; i++) {
                b[index] = new Carta(pal, i);
                index++;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += b[i].toString() + " ";
            if (i == 11 || i == 23 || i == 35) {
                s += "\n";
            }
        }
        return s;
    }

    public void mescla() {
        // la implementació Durstenfeld de l'algorisme Fisher-Yates
        Random rnd = new Random();
        for (int i = MAXCARTES - 1; i > 0; i--) {
            int pos = rnd.nextInt(i + 1);
            Carta c = b[pos];
            b[pos] = b[i];
            b[i] = c;
        }
    }

    public Carta agafaCarta() throws NohihaCartes {
        if (n == 0) {
            throw new NohihaCartes("No hi ha cartes a la baralla, no se'n poden donar més");
        }
        Carta c = b[n - 1];
        n--;
        return c;
    }

    public int numCartes() {
        return n;
    }
}
