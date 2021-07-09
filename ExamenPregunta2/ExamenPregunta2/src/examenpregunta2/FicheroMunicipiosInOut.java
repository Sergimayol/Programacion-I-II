/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Sergi
 */
//CLASE QUE ESCRIBE OBJECTOS DISCO CON LA CLASE RANDOMACCESS FILE
public class FicheroMunicipiosInOut {

    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Contacto desde/en fichero
    private RandomAccessFile fichero = null;
    private int numMunicipios;
    private String nombreFichero;

    public FicheroMunicipiosInOut(String nombreFichero) throws Exception {
        try {
            this.nombreFichero = nombreFichero;
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(this.nombreFichero, "rw");
            numMunicipios = (int) (fichero.length() / Municipio.getDimension());
        } catch (FileNotFoundException error) {
            System.out.println("ERROR abriendo fichero: " + error.toString());
        }
    }

    public Municipio lectura() {
        Municipio municipio = new Municipio();
        //ACCIONES
        try {
            municipio.setMunicipio(lecturaString(32));
            municipio.setIsla(lecturaString(32));
            municipio.setSuperficie(fichero.readDouble());
            municipio.setPoblacion(fichero.readInt());
            municipio.setAnyo(fichero.readInt());
        } catch (EOFException error) {
//            System.out.println("ERROR lectura 1: " + error.toString());
            return null;
        } catch (IOException error) {
            System.out.println("ERROR lectura 2: " + error.toString());
        }
        return municipio;
    }

    public int getNumMunicipios() {
        return numMunicipios;
    }

    public Municipio lectura(int orden) {
        Municipio municipio = new Municipio();
        try {
            if (orden * Municipio.getDimension() < (fichero.length())) {
                fichero.seek(orden * Municipio.getDimension());
                municipio.setMunicipio(lecturaString(32));
                municipio.setIsla(lecturaString(32));
                municipio.setSuperficie(fichero.readDouble());
                municipio.setPoblacion(fichero.readInt());
                municipio.setAnyo(fichero.readInt());

            } else {
                municipio = null;
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return municipio;
    }

    public void escritura(Municipio pal, int orden) {
        try {
            if ((orden * Municipio.getDimension()) < (fichero.length())) {
                //posicionamiento apuntador del fichero 
                fichero.seek(orden * Municipio.getDimension());
                escrituraString(pal.toString(), 32);
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private String lecturaString(int dimension) {
        String string = "";
        try {
            //ACCIONES
            //bucle de lectura y concatenaciÃ³n de los caracteres desde el fichero
            for (int i = 0; i < dimension; i++) {
                //concatenaciÃ³n en el Stringcampo del caracter leido desde el
                //fichero
                string = string + fichero.readChar();
            }
        } catch (IOException error) {
//            System.out.println("ERROR lectura String: " + error.toString());
            return string;
        }
        //devoluciÃ³n del String resultante
        return string;
    }

    public void escritura(Municipio municipio) {
        try {
            escrituraString(municipio.getMunicipio(), 32);
            escrituraString(municipio.getIsla(), 32);
            fichero.writeDouble(municipio.getSuperficie());
            fichero.writeInt(municipio.getPoblacion());
            fichero.writeInt(municipio.getAnyo());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private void escrituraString(String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en funciÃ³n de la dimensiÃ³n dada
            for (int i = 0; ((i < dimension) && (i < campo.length())); i++) {
                //escritura en el fichero del caracter i-Ã©simo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensiÃ³n del String dado es menor que la dimensiÃ³n
            //del atributo que debe representar del objeto Contacto
            if (campo.length() < dimension) {
                //al ser la dimnensiÃ³n del String menor que la dimensiÃ³n del atributo
                //que representa del objeto Contacto se escribirÃ¡n caracteres
                //espacio hasta llegar a la dimensiÃ³n del atributo
                for (int i = 0; i < (dimension - campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    public void ordena(int criteri) {
        try {
            fichero = new RandomAccessFile(this.nombreFichero, "rw");
            numMunicipios = (int) (fichero.length() / Municipio.getDimension());
            int i, j, jmin;
            Municipio min, m;
            for (i = 0; i < numMunicipios - 1; i++) {
                fichero.seek(i * Municipio.getDimension());
                min = lectura();
                jmin = i;
                for (j = i + 1; j < numMunicipios; j++) {
                    fichero.seek(j * Municipio.getDimension());
                    m = lectura();
                    switch (criteri) {
                        case 1: // Ordena per illa i per superfície
                            if (m.getIsla().compareTo(min.getIsla()) < 0
                                    || (m.getIsla().compareTo(min.getIsla()) == 0
                                    && m.getSuperficie() < min.getSuperficie())) {
                                min = m;
                                jmin = j;
                            }
                            break;
                        case 2: // Ordena per illa i per població
                            if (m.getIsla().compareTo(min.getIsla()) < 0
                                    || (m.getIsla().compareTo(min.getIsla()) == 0
                                    && m.getPoblacion() < min.getPoblacion())) {
                                min = m;
                                jmin = j;
                            }
                            break;
                        case 3: // Ordena per any de constitució
                            if (m.getAnyo() < min.getAnyo()
                                    || (m.getAnyo() == min.getAnyo()
                                    && m.getMunicipio().compareTo(min.getMunicipio()) < 0)) {
                                min = m;
                                jmin = j;
                            }
                            break;
                    }
                }
                fichero.seek(i * Municipio.getDimension());
                m = lectura();
                fichero.seek(i * Municipio.getDimension());
                escritura(min);
                fichero.seek(jmin * Municipio.getDimension());
                escritura(m);
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("ERROR(Ordenando): " + e.getMessage());
        }
    }

    //cierre del enlace con el fichero
    public void cierre() {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
