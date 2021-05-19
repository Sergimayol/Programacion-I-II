/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

/**
 *
 * @author Sergi
 */
/*
 * Esta clase contiene el titulo del album, nombre del grupo/artista y el año de edición
 */
public class Disc {

    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa la dimensión
    //en bytes de un objeto Disc
    // Album -> 32 caracteres * 2 bytes = 64 bytes
    // Artista -> 32 caracteres * 2 bytes = 64 bytes
    // año edicion --> 4 bytes
    private static final int DIMENSION = 132;
    private String tituloAlbum;
    private String artista;
    private int anyoEdicion;

    public Disc() {
        tituloAlbum = null;
        artista = null;
        anyoEdicion = 0;
    }

    public void setTituloAlbum(String Album) {
        tituloAlbum = Album;
    }

    public void setArtista(String Artista) {
        artista = Artista;
    }

    public void setAnyoEdicion(int AnyoEdicion) {
        anyoEdicion = AnyoEdicion;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public String getArtista() {
        return artista;
    }

    public int getAnyoEdicion() {
        return anyoEdicion;
    }

    //método que devuelve la dimensión en bytes de un objeto Contacto  
    public static int getDimension() {
        return DIMENSION;
    }

    @Override
    public String toString() {
        return "ALBUM: " + tituloAlbum +
                " ARTISTA/GRUPO: " + artista +
                " AÑO EDICIÓN: " + anyoEdicion;
    }
}
