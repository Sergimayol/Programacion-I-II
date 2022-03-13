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
public class Persona implements java.io.Serializable{

    private String nombre;
    private String estado;
    private int codigo;
    private static final int centinela = -1;

    public Persona() {
        nombre = "";
        estado = "";
        codigo = 0;
    }

    public void setnombre(String s) {
        nombre = s;
    }

    public void setestado(String s) {
        estado = s;
    }

    public void setcodigo(int i) {
        codigo = i;
    }

    public String getnombre() {
        return nombre;
    }

    public String getestado() {
        return estado;
    }

    public int getcodigo() {
        return codigo;
    }

    public static Persona getCentinela() {
        Persona persona = new Persona();
        persona.codigo = centinela;
        return persona;
    }

    public boolean esCentinela() {
        return codigo == centinela;
    }

    @Override
    public String toString() {
        return "Población{codigo = " + codigo
                + ",nombre = " + nombre + ",estado = " + estado + "}";
    }
}
