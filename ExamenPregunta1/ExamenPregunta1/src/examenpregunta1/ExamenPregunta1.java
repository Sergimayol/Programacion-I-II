/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta1;

import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class ExamenPregunta1 {

    private static int numJugadors;
    private boolean fin = false;

    public static void main(String[] args) {
        new ExamenPregunta1().inicio();
    }

    private void inicio() {
        Baralla baraja;
        Jugador[] players;
        Taula mesa;
        try {
            //Numero de jugadores
            numJugadores();
            //Introducir nombres jugadores
            players = asignacionNombres();
            //Crear baraja
            baraja = new Baralla();
            //Se enseña por consola la baraja
            System.out.println("Esta es la baraja: \n" + baraja.toString() + "\n");
            //Mezclar la baraja
            baraja.mescla();
            //Se enseña por consola la baraja
            System.out.println("Después de mezclar: \n" + baraja.toString());
            //Asignacion de cartas a cada jugador
            repartirCartas(players, baraja);
            System.out.println("Cartas de cada jugador:");
            //Se muestra por consola los jugadores y sus cartas
            for (Jugador player : players) {
                System.out.println(player.toString());
            }
            //Se crea una mesa
            mesa = new Taula();
            System.out.println("\nEn la mesa hay: \n" + mesa.toString());
            int turno = 0;
            while (!fin) {
                System.out.println("\nTorn de: " + players[turno].getNombre());
                Carta carta = players[turno].juga(mesa);
                if (carta.getNum() == 0) { // Vol dir que no té carta per posar
                    System.out.print("Pasa");
                } else {
                    System.out.print("Ha puesto la carta: " + carta);
                }
                System.out.println(" le quedan " + players[turno].getNumeroCartas()
                        + " cartas: " + players[turno].getMano());
                if (players[turno].getNumeroCartas() == 0) {
                    fin = true;
                    System.out.println("\n\nHA GANADO: " + players[turno].getNombre());
                } else {
                    turno = (turno + 1) % numJugadors;

                }
                System.out.println("En la mesa hay:\n" + mesa.toString());
                continuar();
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private void repartirCartas(Jugador[] jug, Baralla baralla) {
        while (baralla.numCartes() > 0) {
            for (int i = 0; i < numJugadors; i++) {
                try {
                    jug[i].asignacionCarta(baralla.agafaCarta());
                } catch (Baralla.NohihaCartes ex) {
                    System.out.println(jug[i].getNombre() + ": " + ex.getMessage());
                }
            }
        }
    }

    //Permite determinar el numero de jugadores entre 3 y 6
    private void numJugadores() {
        boolean ok = false;
        while (!ok) {
            try {
                System.out.print("Introduce el número de jugadores (entre 3 i 6): ");
                numJugadors = LT.readInt();
                ok = numJugadors > 2 && numJugadors < 7;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
            }
        }
    }

    //Método para asignar nombres a jugadores
    private Jugador[] asignacionNombres() {
        Jugador[] jugadores;
        jugadores = new Jugador[numJugadors];
        String nombre;
        try {
            //Mientras el contador no supere el num de jugadores introducidos 
            //por teclado se crean nuevos jugadores
            for (int i = 0; i < numJugadors; i++) {
                System.out.print("Introduce nombre del jugador " + (i + 1) + ": ");
                nombre = LT.readLine();
                jugadores[i] = new Jugador(nombre);
            }
        } catch (Exception error) {
            System.out.println("ERROR EN LA ASIGNACION DE NOMBRES. " + error.toString());
        }
        return jugadores;
    }

    //Método para continuar jugando
    private void continuar() {
        System.out.print("\n\n< Pulsa return para continuar> ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
