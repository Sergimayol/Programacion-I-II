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
public class Jugador {
    
    private Mano mano;
    //Nombre del jugador
    private String nombre;
    
    public Jugador(String s) {
        nombre = s;
        this.mano = new Mano();
    }
    
    public void setNombre(String s) {
        nombre = s;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void asignacionCarta(Carta c) {
        mano.setCarta(c);
    }
    
    @Override
    public String toString() {
        String s = "";
        s += nombre + ": \n" + mano.toString();
        return s;
    }
        public Carta juga(Taula taula) {
        Carta carta = mano.buscarCartaAPoner(taula);
        if (carta.getNum() != 0) { // Si és zero vol dir que no té carta per posar i ha de passar
            taula.ponerCarta(carta);
            mano.eliminarCarta(carta);
        }
        return carta;
    }
    
    public int getNumeroCartas() {
        return mano.getNumeroCartas();
    }
    
    public Mano getMano() {
        return mano;
    }
}
