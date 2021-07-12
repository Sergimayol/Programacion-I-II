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
public class Carta {

    private int num;
    private Pal pal;

    // Constructor
    Carta(Pal pal, int i) {
        this.num = i;
        this.pal = pal;
    }

    // Consultors
    @Override
    public String toString() {
        if (num < 10) {
            return "[0" + num + " " + pal + "]";
        } else {
            return "[" + num + " " + pal + "]";
        }
    }

    public int getNum() {
        return num;
    }

    public Pal getPal() {
        return pal;
    }
}
