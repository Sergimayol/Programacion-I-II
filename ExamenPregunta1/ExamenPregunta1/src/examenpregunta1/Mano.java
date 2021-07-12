/*
 * Classe ma col·lecció de cartes de cada jugador
 */
package examenpregunta1;

/**
 *
 * @author miquelmascarooliver
 */
public class Mano {
    
    private final int MAXIMOCARTAS = 24;
    
    private Carta[] cartas;
    private int numeroCartas;
    
    public Mano() {
        cartas = new Carta[MAXIMOCARTAS];
        numeroCartas = 0;
    }

    public void setCarta(Carta c) {
        cartas[numeroCartas] = c;
        numeroCartas++;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numeroCartas; i++) {
            s += cartas[i].toString() + " ";
        }
        return s;
    }

    // Sempre retorna una carta per col·locar, si no enté cap torna una carta especial amb el num = 0
    Carta buscarCartaAPoner(Taula taula) {
        int i = 0;
        boolean trobat = false;
        while (!trobat && i < numeroCartas) {
            trobat = taula.puedeColocarse(cartas[i]);
            i++;
        }
        if (trobat)
            return cartas[i-1];
        else
            return new Carta(Pal.BA, 0);
    }

    public void eliminarCarta(Carta carta) {
        int i = 0;
        while(!cartas[i].equals(carta))
            i++;
        for (int j = i; j < numeroCartas; j++) {
            cartas[j] = cartas[j+1];
        }
        numeroCartas--;
    }
    
    public int getNumeroCartas() {
        return numeroCartas;
    }
    
}
