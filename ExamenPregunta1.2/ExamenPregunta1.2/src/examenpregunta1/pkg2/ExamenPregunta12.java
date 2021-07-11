/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta1.pkg2;

import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class ExamenPregunta12 {

    private static int numJugadors; //Atributo numero de jugadores
    private boolean fin = false;
    private Jugador[] jug;
    private int BANCA;

    public static void main(String[] args) {
        new ExamenPregunta12().inicio();
    }

    private void inicio() {
        jugadores();
        while (!fin) {
            crearMesa();
            juego();
            eliminarCartas();
            continuar();
        }
        estadisticas();
    }

    private void continuar() {
        System.out.print("\n\n< ¿Otra partida? > \ns/n:");
        try {
            char continuar = (char) System.in.read();
//            System.out.println(continuar);
            if (continuar == 'n') {
                fin = true;
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //Método principal del programa
    private void crearMesa() {
        try {
            Baralla baralla = new Baralla(); //Se crea la baraja
            System.out.println("Aquesta és la baralla: \n" + baralla); //Se imprime por pantalla la baraja
            baralla.mescla(); //Llamamos al método de mezclar la baraja
            System.out.println("Després de mesclar: \n" + baralla); //Se imprime por pantalla la baraja despues de mezclar
            reparteixCartes(jug, baralla); //Se llama al método reparteixCartas
            System.out.println("Cartes de cada jugador"); //Se imprime por pantalla las cartas de cada jugador
            for (int i = 0; i < jug.length; i++) {
                System.out.println(jug[i].getNombre() + ":");
                System.out.println(jug[i].toString() + " " + jug[i].getPuntuacion());
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private void eliminarCartas() {
        try {
            for (Jugador jug1 : jug) {
                jug1.quitarcarta();
                jug1.quitarcarta();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }

    }

    private void jugadores() {
        try {
            boolean ok = false; //Variable booleana para decidir si el número de jugadores es correcto
            while (!ok) { //Bucle while, mientras no sea cierto que el numero que haya entrado por teclado esté entre 2 y 6 seguirá
                numJugadors = leerEntero("Introduce el número de jugadores (entre 2 i 6): "); //Lee el entero pasado por teclado y lo guarda en la variable numJugadors
                ok = numJugadors > 1 && numJugadors < 7; //Cierra bucle si el numero escrito está entre 2 y 6
            }
            numJugadors++;
            jug = new Jugador[numJugadors];
            BANCA = numJugadors - 1;
            for (int i = 0; i < numJugadors; i++) { //Bucle for que depende del numero de jugadores que hayamos entrado
                if (i < BANCA) {
                    String nom = leerString("Introduce el nombre del jugador " + (i + 1) + ": "); //Insertamos el nombre de los jugadores y lo guardamos en la variable nom
                    jug[i] = new Jugador(nom); //Por cada numero de jugadores un nombre
                } else {
                    jug[i] = new Jugador("BANCA");
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    private void juego() {
        try {
            final double max = 7.5;
            int j = 0;
            int cont = 0;
            Jugador[] jug2 = new Jugador[numJugadors];
//        System.out.println(jug[numJugadors - 1]);
            if (jug[BANCA].getPuntuacion() < max) {
                if (jug[BANCA].getPuntuacion() != max) {
                    for (int i = 0; i < numJugadors; i++) {
                        if (jug[i].getPuntuacion() <= max) {
                            jug2[j] = jug[i];
                            j++;
                        } else {
                            System.out.println(jug[i].getNombre() + " se ha pasado y pierde");
                            jug[i].derrota();
                            cont++;
                        }
                    }
//                    System.out.println(j);
//                    System.out.println(Arrays.toString(jug2));
                    for (int k = 0; k < j - 1; k++) {
                        if (jug2[k].getPuntuacion() > jug2[j - 1].getPuntuacion()) {
                            System.out.println(jug2[k].getNombre() + " ha ganado a la banca");
                            jug2[k].victoria();
                        } else {
                            System.out.println(jug2[k].getNombre() + " pierde contra la banca");
                            jug2[k].derrota();
                        }
                    }
                } else {
                    System.out.println(jug[BANCA].getPuntuacion() + "ha hecho set, gana la banca");
                    jug[BANCA].victoria();
                    asignarDerrotaJugadores(jug);
                }
            } else {
                System.out.println(jug[BANCA].getNombre() + " se ha pasado y todos los jugadores ganan");
                jug[BANCA].derrota();
                asignarVictoriaJugadores(jug);
            }
            if (cont == numJugadors - 1) {
                System.out.println("Gana la banca");
                jug[BANCA].victoria();
            }
        } catch (Exception e) {
            System.out.println("ERROR(juego()): " + e.toString());
        }
    }

    private void asignarVictoriaJugadores(Jugador[] jug) {
        for (int i = 0; i < jug.length - 1; i++) {
            jug[i].victoria();
        }
    }

    private void asignarDerrotaJugadores(Jugador[] jug) {
        for (int i = 0; i < jug.length - 1; i++) {
            jug[i].derrota();
        }
    }

    private void estadisticas() {
        try {
            for (int i = 0; i < numJugadors; i++) {
                System.out.println(jug[i].getEstaditicas());
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    //Método para leer una cadena que se haya pasado por teclado
    private static String leerString(String msg) {
        String s = null;
        try {
            System.out.print(msg);
            s = LT.readLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return s;
    }

    //Método para leer un entero que se haya pasado por teclado
    private static int leerEntero(String msg) {
        int x = 0;
        String s = "";
        try {
            System.out.print(msg);
            s = LT.readLine();
            x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return x;
    }

    private static void reparteixCartes(Jugador[] jug, Baralla baralla) {
        int a = 1;
        while (a <= 2) {
            for (int i = 0; i < numJugadors; i++) {
                try {
                    Carta c = baralla.agafaCarta();
                    jug[i].asignacionCarta(c);
                } catch (Baralla.NohihaCartes ex) {
                    System.out.println(jug[i].getNombre() + ": " + ex.getMessage());
                }
            }
            a++;
        }
    }
}
