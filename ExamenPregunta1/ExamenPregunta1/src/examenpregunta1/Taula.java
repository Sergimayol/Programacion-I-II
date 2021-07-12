/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta1;

/**
 *
 * @author Sergi
 */
public class Taula {

    private final int FILAS = 4, COLUMNAS = 12;
    private Carta[][] tabla;
    private int[] inf;
    private int[] sup;

    public Taula() {
        tabla = new Carta[FILAS][COLUMNAS];
        inf = new int[4];
        sup = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                tabla[i][j] = new Carta(Pal.values()[i], 0);
            }
            inf[i] = 6;
            sup[i] = 6;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += Pal.values()[i];
            for (int j = 0; j < 12; j++) {
                if (tabla[i][j].getNum() == 0) // Si la carta és buida no la mostram
                {
                    s += "[     ] ";
                } else {
                    s += tabla[i][j].toString() + " ";
                }
            }
            s += "\n";
        }
        return s;
    }

    public void ponerCarta(Carta carta) {
        tabla[carta.getPal().ordinal()][carta.getNum() - 1] = carta;
        if (carta.getNum() == 6) {
            inf[carta.getPal().ordinal()]--;
            sup[carta.getPal().ordinal()]++;
        } else if (carta.getNum() > 6) {
            sup[carta.getPal().ordinal()]++;
        } else {
            inf[carta.getPal().ordinal()]--;
        }
    }

    public boolean puedeColocarse(Carta carta) {
        return (carta.getNum() == inf[carta.getPal().ordinal()] || carta.getNum() == sup[carta.getPal().ordinal()]);
    }
}
