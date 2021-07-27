/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas1;

/**
 *
 * @author Sergi
 */
public class Grupos {

    private int sanos;
    private int infectados;
    private int curados;
    private int difuntos;
    private static final int DIMENSION = 12;

    public Grupos() {
        sanos = 0;
        infectados = 0;
        curados = 0;
        difuntos = 0;
    }

    public void setSanos(int i) {
        sanos = i;
    }

    public void setInfectados(int i) {
        infectados = i;
    }

    public void setCurados(int i) {
        curados = i;
    }

    public void setDifuntos(int i) {
        difuntos = i;
    }

    public int getSanos() {
        return sanos;
    }

    public int getInfectados() {
        return infectados;
    }

    public int getCurados() {
        return curados;
    }

    public int getDifuntos() {
        return difuntos;
    }
    
    public static int getDimension() {
        return DIMENSION;
    }

    @Override
    public String toString() {
        return "Registro{sanos = " + sanos
                + ", infectados = " + infectados + ", curados = "
                + curados + ", difuntos = " + difuntos + "}";
    }
}
