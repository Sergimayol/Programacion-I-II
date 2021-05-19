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
public class Canso implements java.io.Serializable {

    private String tituloCancion;
    private String artista;
    private String AlbumPertenece;
    private String genero;
    private String anyoEdicion;
    private Data fecha;

    public Canso() {
        tituloCancion = null;
        artista = null;
        AlbumPertenece = null;
        genero = null;
        anyoEdicion = null;
    }

    //MÉTODOS FUNCIONALES
    //método que devuelve el objeto Libro centinela
    public static Canso getCentinela() {
        Canso centinela = new Canso();
        centinela.tituloCancion = "ZZZ";
        return centinela;
    }

    //método que verifica si un objeto Libro es centinela o no
    public boolean esCentinela() {
        return "ZZZ".equals(tituloCancion);
    }

    public void setTituloCancion(String dato) {
        tituloCancion = dato;
    }

    public void setArtista(String dato) {
        artista = dato;
    }

    public void setAlbumPertenece(String dato) {
        AlbumPertenece = dato;
    }

    public void setGenero(String dato) {
        genero = dato;
    }

    public void setAnyoEdicion(String dato) {
        anyoEdicion = dato;
    }

    public void setData(String dato) {
        String fechaStr = dato;
        fecha = new Data(fechaStr);
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbumPertenece() {
        return AlbumPertenece;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnyoEdicion() {
        return anyoEdicion;
    }

    public Data getData() {
        return fecha;
    }

    @Override
    public String toString() {
        return "CANCIÓN: " + tituloCancion
                + ", ARTISTA: " + artista
                + ", ALBUM: " + AlbumPertenece
                + ", GÉNERO: " + genero
                + ", AÑO: " + anyoEdicion
                + ", FECHA: " + fecha.toString();
    }

    public int getDataInt() {
        int dataint;
        dataint = fecha.toValor();
        return dataint;
    }

    public boolean comparacion(Canso cancion) {
        return fecha.toValor() > cancion.getDataInt();
    }

    public int getAnyotoInt() {
        String a = anyoEdicion;
        int valor = 0;
        try {
            valor = Integer.parseInt(a);
        } catch (NumberFormatException e) {
            System.out.println("Error en la conversión");
        } catch (Exception e2) {
            System.out.println(e2);
        }
        return valor;
    }
}
