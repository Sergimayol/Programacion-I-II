/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4_3;

import java.io.File;

/**
 *
 * @author Sergi
 */
public class Problema4_3 {

    public static void main(String[] args) {
        new Problema4_3().inicio();
    }

    private void inicio() {
        //Declarar clases necesarias para la lectura y escritura de ficheros
        FicheroObjetosLibroIn ficheroLectura;
        FicheroObjetosLibroOut ficheroNuevo;
        //Declarar variables necesarias
        int codigo;
        int opcion;
        Libro libro;
        String archivo = "libros.dat";
        String archivotemporal = "ficherotemporal.dat";
        boolean libro_encontrado = false;
        try {
            //Pedir al usuario que selecione el codigo del libro 
            //con el que desea operar
            System.out.print("ESCRIBA EL CODIGO DEL LIBRO QUE DESEA MODIFICAR: ");
            codigo = LT.readInt();
            //Instanciar clases a utilizar
            ficheroLectura = new FicheroObjetosLibroIn(archivo);
            ficheroNuevo = new FicheroObjetosLibroOut(archivotemporal);
            try {
                //Leer primer objecto(Libro) de fichero
                libro = ficheroLectura.lectura();
                //Mientras no sea final de fichero(Centinela), entrar en el bucle
                while ((!libro.esCentinela())) {
                    //Si el codigo del libro leido coincide con el del usuario,
                    //dar la posibilidad de que el usuario modifique el año 
                    //de publicacion del libro
                    if (codigo == libro.getCodigo()) {
                        //Menu paara que el usuario elija que atributo del libro desea modificar
                        //Metodo para elegir opcion
                        menu();
                        opcion = opcion();
                        switch (opcion) {
                            case 1:
                                System.out.print("ESCRIBA EL NUEVO TITULO: ");
                                String titulo = LT.readLine();
                                libro.setTitulo(titulo);
                                break;
                            case 2:
                                System.out.print("ESCRIBA EL NUEVO AUTOR: ");
                                String autor = LT.readLine();
                                libro.setAutor(autor);
                                break;
                            case 3:
                                System.out.print("ESCRIBA LA NUEVA EDITORIAL: ");
                                String editorial = LT.readLine();
                                libro.setEditorial(editorial);
                                break;
                            case 4:
                                System.out.print("ESCRIBA EL NUEVO AUTOR: ");
                                int anyo = LT.readInt();
                                libro.setAnyoPublicacion(anyo);
                                break;
                        }
                    }
                    //Escribir libro en fichero
                    ficheroNuevo.escritura(libro);
                    //leer el siguiente libro
                    libro = ficheroLectura.lectura();
                }
                //Si no existe el libro que desea modificar Informar al usuario
                if (!libro_encontrado) {
                    System.out.println("EL LIBRO QUE HA SELCCIONADO NO EXISTE");
                }
                //Escribir el centinela
                ficheroNuevo.escritura(Libro.getCentinela());                
            } catch (Exception error) {
                System.out.println("ERROR: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    ficheroLectura.cierre();
                    ficheroNuevo.cierre();
                    //Borrar fichero antiguo
                    File fich = new File(archivo);
                    fich.delete();
                    //Cambiar nombre fichero temporal al nombre del fichero original
                    File fich2 = new File(archivotemporal);
                    File fich3 = new File(archivo);
                    fich2.renameTo(fich3);
                } catch (Exception error) {
                    System.out.println("ERROR: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private void menu() {
        System.out.println("\n\n¿QUE ATRIBUTO DESEA MODIFICAR?");
        System.out.println("\n\t1. Titulo");
        System.out.println("\t2. Autor");
        System.out.println("\t3. Editorial");
        System.out.println("\t4. Año Publicacion");
    }

    private int opcion() {
        int x = 0;
        try {
            String s;
            s = LT.readLine();
            x = Integer.parseInt(s);
        } catch (NumberFormatException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
        return x;
    }
}
