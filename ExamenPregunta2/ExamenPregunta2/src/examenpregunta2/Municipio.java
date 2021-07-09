/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta2;

/**
 *
 * @author Sergi
 */
public class Municipio {

    //32 bytes
    private String nombreMunicipio;
    //32 bytes
    private String isla;
    //4 bytes
    private double superficie;
    //4 bytes
    private int poblacion;
    //4 bytes
    private int anyo;
    private static final Municipio centinela = new Municipio();
    private static final int DIMENSION = 76;
    
    public Municipio() {
        nombreMunicipio = "";
        isla = "";
        superficie = 0;
        poblacion = 0;
        anyo = 0;
    }
    
    public boolean esCentinela() {
        return anyo == 0;
    }

    //método que devuelve el objeto Municipio centinela
    public static Municipio getCentinela() {
        return centinela;
    }
    
    public static int getDimension() {
        return DIMENSION;
    }
    
    public static void copiar(Municipio m1, Municipio m2) {
        m2.nombreMunicipio = m1.nombreMunicipio;
        m2.isla = m1.isla;
        m2.superficie = m1.superficie;
        m2.poblacion = m1.poblacion;
        m2.anyo = m1.anyo;
    }
    
    public boolean menor(Municipio m, int i) {
        boolean menor = false;
        switch (i) {
            case 0:
                if (superficie < m.getSuperficie()) {
                   menor = true;
                }
                break;
            case 1:
                if (poblacion < m.getPoblacion()) {
                   menor = true;
                }
                break;
            case 2:
                if (anyo < m.getAnyo()) {
                   menor = true;
                }
                break;
        }
        return menor;
    }
    
    public String getMunicipio() {
        return nombreMunicipio;
    }
    
    public String getIsla() {
        return isla;
    }
    
    public double getSuperficie() {
        return superficie;
    }
    
    public int getPoblacion() {
        return poblacion;
    }
    
    public int getAnyo() {
        return anyo;
    }
    
    public void setMunicipio(String s) {
        nombreMunicipio = s;
    }
    
    public void setIsla(String s) {
        isla = s;
    }
    
    public void setSuperficie(double d) {
        superficie = d;
    }
    
    public void setPoblacion(int i) {
        poblacion = i;
    }
    
    public void setAnyo(int i) {
        anyo = i;
    }
    
    @Override
    public String toString() {
        return "{municipio=" + nombreMunicipio + ", " + isla + ", superficie=" + superficie
                + ", poblacion=" + poblacion + ", año " + anyo + "}";
    }
}
