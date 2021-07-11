/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta1.pkg2;

/**
 *
 * @author Sergi
 */
public class Jugador {

    //Numero del jgador
    private int codigo;
    //
    private int numeroCartas;
    //
    private Carta[] cartas;
    //Nombre del jugador
    private String nombre;
    private final int MAXIMOCARTAS = 2;
    private int victorias, derrotas;

    public Jugador(String s) {
        nombre = s;
        victorias = 0;
        derrotas = 0;
        //codigo = i;
        numeroCartas = 0;
        cartas = new Carta[MAXIMOCARTAS];
    }

    public void setNombre(String s) {
        nombre = s;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void asignacionCarta(Carta c) {
        cartas[numeroCartas] = c;
        numeroCartas++;
    }
    
    public void quitarcarta(){
        numeroCartas--;
    }

    @Override
    public String toString() {
        String msg = "";
        for (int idx = 0; idx < numeroCartas; idx++) {
            msg += cartas[idx];
        }
        return msg;
    }

    public void victoria() {
        victorias++;
    }

    public void derrota() {
        derrotas++;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public String getEstaditicas() {
        return nombre + "\t" + "Partidas ganadas: " + victorias + " ||  Partidas perdidas: " + derrotas;
    }

    public double getPuntuacion() {
        double puntuacion = 0;
        Carta carta;
        for (int i = 0; i < numeroCartas; i++) {
            carta = cartas[i];
            if (carta.getNum() <= 7) {
                puntuacion = puntuacion + carta.getNum();
            } else {
                puntuacion = puntuacion + 0.5;
            }
        }
        return puntuacion;
    }
}
