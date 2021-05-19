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
public class PrimerTallerEvaluable {

    private void inicio() {
        //PRIMERA PARTE
        fusionFicheros();
        visualizacionContenidoObjectStream("Musica.dat");
        //SEGUNDA PARTE
        generarFicheroDisc();
        visualizacionContenidoRandomAccessFile("Discs.dat");
    }

    public static void main(String[] args) {
        new PrimerTallerEvaluable().inicio();
    }

    //PARTE UNO DEL PROGRAMA. FUSION DE FCIHEROS EN "MUSICA.DAT"
    private void fusionFicheros() {
        //Declarar variables necesarias
        Canso cancion1, cancion2, cancion3;
        //Declarar clases de lectura y escritura de ficheros
        FitxerTxtCansonsIn ficheroEntradaTxt1, ficheroEntradaTxt2, ficheroEntradaTxt3;
        FitxerCansonsOut ficheroObjectoCancionOut;
        try {
            //Instanciar clases de lectura y escritura 
            ficheroEntradaTxt1 = new FitxerTxtCansonsIn("Nacional.txt");
            ficheroEntradaTxt2 = new FitxerTxtCansonsIn("Darrers.txt");
            ficheroEntradaTxt3 = new FitxerTxtCansonsIn("Americana.txt");
            ficheroObjectoCancionOut = new FitxerCansonsOut("Musica.dat");
            try {
                //lectura primer objeto cancion de cada fichero de entrada
                cancion1 = ficheroEntradaTxt1.leerObjetoCancion();
                cancion2 = ficheroEntradaTxt2.leerObjetoCancion();
                cancion3 = ficheroEntradaTxt3.leerObjetoCancion();
                //BUCLE PRINCIPAL DE FUSIÓN SIMÉTRICA EN FUNCIÓN DEL ATRIBUTO
                //codigo EN ORDEN DECRECIENTE
                while (!cancion1.esCentinela()) {
                    if ((cancion1.comparacion(cancion2)) && (cancion1.comparacion(cancion3))) {
                        ficheroObjectoCancionOut.escritura(cancion1);
                        cancion1 = ficheroEntradaTxt1.leerObjetoCancion();
                    } else if ((cancion2.comparacion(cancion3))) {
                        ficheroObjectoCancionOut.escritura(cancion2);
                        cancion2 = ficheroEntradaTxt2.leerObjetoCancion();
                    } else {
                        ficheroObjectoCancionOut.escritura(cancion3);
                        cancion3 = ficheroEntradaTxt3.leerObjetoCancion();
                    }
                }
                while (!cancion2.esCentinela()) {
                    if ((cancion2.comparacion(cancion3))) {
                        ficheroObjectoCancionOut.escritura(cancion2);
                        cancion2 = ficheroEntradaTxt2.leerObjetoCancion();
                    } else {
                        ficheroObjectoCancionOut.escritura(cancion3);
                        cancion3 = ficheroEntradaTxt3.leerObjetoCancion();
                    }
                }
                while (!cancion3.esCentinela()) {
                    ficheroObjectoCancionOut.escritura(cancion3);
                    cancion3 = ficheroEntradaTxt3.leerObjetoCancion();
                }
            } catch (Exception error) {
//                System.out.println("(funsionFicheros)ERROR 1: " + error.toString());
                ficheroObjectoCancionOut.escritura(Canso.getCentinela());
            } finally {
                try {
                    //grabación del objeto Libro CENTINELA en el fichero de salida
                    //ficheroObjectoCancionOut.escritura(Canso.getCentinela());
                    //cierre del enlaces ficheros
                    ficheroEntradaTxt1.close();
                    ficheroEntradaTxt2.close();
                    ficheroEntradaTxt3.close();
                    ficheroObjectoCancionOut.cierre();
                } catch (Exception error) {
                    System.out.println("(funsionFicheros)ERROR CIERRE FICHERO" + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("(funsionFicheros)ERROR 2:" + error.toString());
        }

    }

    //PARTE DOS DEL PROGRAMA. GENERA UN FICHERO QUE CONTIENE LOS DISCOS
    //A LOS QUE PERTENECEN LAS CANCIONES EN "DISCS.DAT"
    private void generarFicheroDisc() {
        //Declarar clases de lectura y escritura de ficheros
        FitxerCansonsIn lecturaCanciones;
        FitxerDiscs escrituraDiscos;
        //Declaración de variables
        Canso cancion;
        Disc disco;
        try {
            //Instanciar clases de lectura y escritura, 
            //con su correspondiente enlace de fichero
            lecturaCanciones = new FitxerCansonsIn("Musica.dat");
            escrituraDiscos = new FitxerDiscs("Discs.dat");
            String siguiente = "";
            try {
                //Leer primer objecto canción del fichero "Musica.dat"
                cancion = lecturaCanciones.lectura();
                //Mientras no sea final de texto(Centinela), entrar en el bucle
                while (!cancion.esCentinela()) {
                    String albumActual = cancion.getAlbumPertenece();
                    //Si el album actual no esta se añade
                    if (albumActual.equals(siguiente)) {
                        //No hacemos nada
                    } else {
                        //Pasar atributos Canción a Disco
                        disco = new Disc();
                        //Album Cancion ==> Album Disco
                        disco.setTituloAlbum(cancion.getAlbumPertenece());
                        //Artista Cancion ==> Artista Disco
                        disco.setArtista(cancion.getArtista());
                        //Año edición Cancion ==> Año edición Disco
                        disco.setAnyoEdicion(cancion.getAnyotoInt());
                        //Escribir objecto disco en el fichero
                        escrituraDiscos.escritura(disco);
                        siguiente = albumActual;
                    }
                    //Leer siguiente Objecto cancion
                    cancion = lecturaCanciones.lectura();
                }
            } catch (Exception e) {
//                System.out.println("(generarFicheroDisc)ERROR 1: " + e.toString());
                System.out.println("\n");
            } finally {
                try {
                    //cierre del enlace fichero
                    lecturaCanciones.cierre();
                    escrituraDiscos.cierre();
                } catch (Exception error) {
                    System.out.println("(generarFicheroDisc)ERROR CIERRE ENLACE FICHERO: " + error.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("(generarFicheroDisc)ERROR 2: " + e.toString());
        }
    }

    //ESTE MÉTODO PERMITE LA VISUALIZACIÓN DEL FICHERO(ObjectStream)PASADO POR PARÁMETRO
    private void visualizacionContenidoObjectStream(String fichero) {
        //Declaración clase FitxerCansonsIn
        FitxerCansonsIn lecturaFichero;
        //Declaración objeto Canso
        Canso cancion;
        try {
            //Instanciar clases declaradas
            lecturaFichero = new FitxerCansonsIn(fichero);
            try {
                //lectura del primer objeto Canso desde el fichero
                cancion = lecturaFichero.lectura();
                //Mientras no sea final de texto(Centinela)
                while ((!cancion.esCentinela())) {
                    //visualización objeto Canso leido
                    System.out.println(cancion.toString());
                    //lectura siguiente objeto Canso desde el fichero
                    cancion = lecturaFichero.lectura();
                }
            } catch (Exception error) {
                System.out.println("Fin del fichero Musica.dat");
            } finally {
                try {
                    //Cierre enlaces ficheros
                    lecturaFichero.cierre();
                } catch (Exception error) {
                    System.out.println("(visualizacionContenidoObjectStream)ERROR CERRANDO ENLACE FICHERO:" + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("(visualizacionContenidoObjectStream)ERROR 2: " + error.toString());
        }
    }

    //ESTE MÉTODO PERMITE LA VISUALIZACIÓN DEL FICHERO(RandomAccessFile)PASADO POR PARÁMETRO
    private void visualizacionContenidoRandomAccessFile(String fichero) {
        //Declaración clase FitxerDiscs
        FitxerDiscs lecturaFichero;
        //Declaración objeto Disc
        Disc disco;
        try {
            //Instanciar clases declaradas
            lecturaFichero = new FitxerDiscs(fichero);
            try {
                //lectura del primer objeto Disc desde el fichero
                disco = lecturaFichero.lectura();
                //Mientras no sea final de texto
                while (disco != null) {
                    //visualización objeto Disc leido
                    System.out.println(disco.toString());
                    //lectura siguiente objeto Disc desde el fichero  
                    disco = lecturaFichero.lectura();
                }
            } catch (Exception error) {
                System.out.println("(visualizacionContenidoRandomAccessFile)ERROR 1: " + error.toString());
                //Fichero ha terminado
            } finally {
                try {
                    //cierre del enlace fichero
                    lecturaFichero.cierre();
                } catch (Exception error) {
                    System.out.println("(visualizacionContenidoRandomAccessFile)ERROR CIERRE ENLACE FICHERO: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("(visualizacionContenidoRandomAccessFile)ERROR 2:" + error.toString());
        }
    }
}
