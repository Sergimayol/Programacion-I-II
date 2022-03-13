/*
CLASE Libro
 */
package problema4_2;

//clase serializada para poder llevar a cabo la gestión de objetos Libro en
//ficheros a través del flujo de datos (clases ObjectInputStream y ObjectOutputStream
public class Libro implements java.io.Serializable {

    // ATRIBUTOS
    private int codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private int anyoPublicacion;
    private boolean eliminado;

    // MÉTODO CONSTRUCTOR
    public Libro() {
        codigo = 0;
        eliminado = false;
    }

    //MÉTODOS FUNCIONALES
    //método que devuelve el objeto Libro centinela
    public static Libro getCentinela() {
        Libro libro = new Libro();
        libro.codigo = -1;
        return libro;
    }

    //método que verifica si un objeto Libro es centinela o no
    public boolean esCentinela() {
        return codigo == -1;
    }

    //lectura de objeto Libro desde el teclado. El campo código es pasado por
    //parámetro una vez que la aplicación correspondiente haya obtenido el
    //código que le corresponde a un nuevo objecto LIbro para grabar en un fichero 
    //de libros
    public void lectura(int cod) throws Exception {
        System.out.print("TÍTULO LIBRO: ");
        titulo = LT.readLine();
        System.out.print("AUTOR: ");
        autor = LT.readLine();
        System.out.print("EDITORIAL: ");
        editorial = LT.readLine();
        System.out.print("AÑO DE PUBLICACIÓN: ");
        anyoPublicacion = LT.readInt();
    }

    //lectura de objeto Libro desde el teclado. 
    public void lectura() throws Exception {
        System.out.print("CÓDIGO LIBRO: ");
        codigo = LT.readInt();
        System.out.print("TÍTULO LIBRO: ");
        titulo = LT.readLine();
        System.out.print("AUTOR: ");
        autor = LT.readLine();
        System.out.print("EDITORIAL: ");
        editorial = LT.readLine();
        System.out.print("AÑO DE PUBLICACIÓN: ");
        anyoPublicacion = LT.readInt();
    }

    //conversión a String de un objeto Libro con fines de visualización
    @Override
    public String toString() {
        return "CODIGO: " + codigo
                + "\nTÍTULO: " + titulo
                + "\nAUTOR: " + autor
                + "\nEDITORIAL: " + editorial
                + "\nAÑO PUBLICACIÓN: " + anyoPublicacion
                + "\nLIBRO ELIMINADO: " + eliminado;
    }

    //métodos gets
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public boolean getEstadoLibro() {
        return eliminado;
    }

    //métodos sets
    public void setCodigo(int cod) {
        codigo = cod;
    }

    public void setTitulo(String dato) {
        titulo = dato;
    }

    public void setAutor(String dato) {
        autor = dato;
    }

    public void setEditorial(String dato) {
        editorial = dato;
    }

    public void setAnyoPublicacion(int dato) {
        anyoPublicacion = dato;
    }

    public void setEstadoLibro(boolean dato) {
        eliminado = dato;
    }

}
