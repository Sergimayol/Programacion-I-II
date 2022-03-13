/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas5;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Sergi
 */
public class FicheroEstudianteInOut {

    //DECLARACIÓN ATRIBUTOS
    //declaración objeto RandomAccessFile para posibilitar la lectura/escritura
    //de objetos Estudiante desde/en fichero
    RandomAccessFile fichero = null;
    //declaración objeto Estudiante
    Estudiante contacto = new Estudiante();
    //MÉTODOS

    //MÉTODO CONSTRUCTOR
    public FicheroEstudianteInOut(String nombreFichero) throws Exception {
        try {
            //instanciación objeto RandomAccessFile para establecer el enlace con
            //el fichero a nivel de lectura/escritura
            fichero = new RandomAccessFile(nombreFichero, "rw");
        } catch (FileNotFoundException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //MÉTODOS FUNCIONALES
    //método lectura que posibilita la lectura de un objeto Estudiante desde el
    //fichero
    public Estudiante lectura() {
        //DECLARACIONES
        //declaración objeto Estudiante
        Estudiante contacto = new Estudiante();

        //ACCIONES
        try {
            //lectura campo atributo codigo del objeto Estudiante
            contacto.setCodigo(fichero.readInt());
            //lectura campo atributo nombre del objeto Estudiante a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            contacto.setNombre(lecturaString(32));
            //lectura campo atributo telefono del objeto Estudiante a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            contacto.setTelefono(lecturaString(16));
            //lectura campo atributo email del objeto Estudiante a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            contacto.setEmail(lecturaString(32));
            //lectura campo atributo direccion del objeto Estudiante a través del
            //método lecturaString proporcionándole la dimensión en caracteres
            //del atributo
            contacto.setDireccion(lecturaString(64));
            //lectura campo atributo edad del objeto Estudiante
            contacto.setCurso(lecturaString(32));
            contacto.setEstudios(lecturaString(64));
            //lectura campo atributo eliminado del objeto Estudiante      
            contacto.setEliminado(fichero.readBoolean());
        } catch (EOFException error) {
            return null;
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return contacto;
    }

    //método lectura que posibilita la lectura de un objeto Estudiante desde el
    //fichero dado el número del elemento de fichero Estudiante
    public Estudiante lectura(int numero) {
        //DECLARACIONES
        //declaración objeto Estudiante
        Estudiante contacto = new Estudiante();

        //ACCIONES
        try {
            //verificación si la posición del elemento a leer existe en el fichero
            if ((numero > 0) && (numero <= (fichero.length() / Estudiante.getDimension()))) {
                //posicionamiento puntero del fichero en el elemento de fichero
                //Estudiante dado
                fichero.seek(((numero - 1) * Estudiante.getDimension()));
                //lectura campo atributo codigo del objeto Estudiante
                contacto.setCodigo(fichero.readInt());
                //lectura campo atributo nombre del objeto Estudiante a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                contacto.setNombre(lecturaString(32));
                //lectura campo atributo telefono del objeto Estudiante a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                contacto.setTelefono(lecturaString(16));
                //lectura campo atributo email del objeto Estudiante a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                contacto.setEmail(lecturaString(32));
                //lectura campo atributo direccion del objeto Estudiante a través del
                //método lecturaString proporcionándole la dimensión en caracteres
                //del atributo
                contacto.setDireccion(lecturaString(64));
                //lectura campo atributo edad del objeto Estudiante
                contacto.setCurso(lecturaString(32));
                contacto.setEstudios(lecturaString(64));
                //lectura campo atributo eliminado del objeto Estudiante
                contacto.setEliminado(fichero.readBoolean());
            } else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("CONTACTO NO EXISTENTE");
            }
        } catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
            return contacto;
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return contacto;
    }

    //método que lleva a cabo la lectura de un String desde el fichero a través 
    //de la lectura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private String lecturaString(int dimension) {
        //DECLARACIONES
        //declaración String para ir concatenando los caracteres que van a ser
        //leidos desde el fichero
        String campo = "";

        try {
            //ACCIONES
            //bucle de lectura y concatenación de los caracteres desde el fichero
            for (int i = 0; i < dimension; i++) {
                //concatenación en el Stringcampo del caracter leido desde el
                //fichero
                campo = campo + fichero.readChar();
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
            return campo;
        }
        //devolución del String resultante
        return campo;
    }

    //método escritura que posibilita la escritura de un objeto Estudiante en el
    //fichero
    public void escritura(Estudiante contacto) {
        try {
            //obtención y asignación del atributo codigo que le corresponde al
            //nuevo objeto Estudiante a grabar en el fichero
            contacto.setCodigo(getNuevoCodigo());
            //escritura en el fichero del atributo código correspondiente al
            //objeto contacto 
            fichero.writeInt(contacto.getCodigo());
            //escritura en el fichero del atributo nombre. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre
            escrituraString(contacto.getNombre(), 32);
            //escritura en el fichero del atributo telefono. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre
            escrituraString(contacto.getTelefono(), 16);
            //escritura en el fichero del atributo email. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre            
            escrituraString(contacto.getEmail(), 32);
            //escritura en el fichero del atributo direccion. Se utiliza el método 
            //escritura String para poder grabar en el fichero los caracteres
            //que conforman el atributo nombre            
            escrituraString(contacto.getDireccion(), 64);
            //escritura en el fichero del atributo edad correspondiente al
            //objeto contacto 
            escrituraString(contacto.getEstudios(), 64);
            escrituraString(contacto.getCurso(), 32);
            //escritura en el fichero del atributo elimiando correspondiente al
            //objeto contacto 
            fichero.writeBoolean(contacto.getEliminado());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método que posibilita la reescritura en el fichero de un objeto Estudiante
    //en función del número que ocupa en el fichero
    public void escritura(Estudiante contacto, int numero) {
        try {
            //verificación si la posición del contacto a leer existe en el fichero
            if ((numero > 0) && (numero <= (fichero.length() / Estudiante.getDimension()))) {
                //posicionamiento del puntero en el elemento de fichero objeto Estudiante
                //correspondiente al número dado por parámetro
                fichero.seek((numero - 1) * Estudiante.getDimension());
                //escritura en el fichero del atributo código correspondiente al
                //objeto contacto 
                fichero.writeInt(contacto.getCodigo());
                //escritura en el fichero del atributo nombre. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre
                escrituraString(contacto.getNombre(), 32);
                //escritura en el fichero del atributo telefono. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre
                escrituraString(contacto.getTelefono(), 16);
                //escritura en el fichero del atributo email. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre            
                escrituraString(contacto.getEmail(), 32);
                //escritura en el fichero del atributo direccion. Se utiliza el método 
                //escritura String para poder grabar en el fichero los caracteres
                //que conforman el atributo nombre            
                escrituraString(contacto.getDireccion(), 64);
                //escritura en el fichero del atributo edad correspondiente al
                //objeto contacto 
                escrituraString(contacto.getEstudios(), 64);
                escrituraString(contacto.getCurso(), 32);
                //escritura en el fichero del atributo elimiando correspondiente al
                //objeto contacto 
                fichero.writeBoolean(contacto.getEliminado());
            } else {
                //invocación excepcion no predefinida entradaIncorrecta
                throw new EntradaIncorrecta("NO ES POSIBLE ESCRIBIR EL CONTACTO DADO");
            }
        } catch (EntradaIncorrecta error) {
            System.out.println(error.toString());
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método que lleva a cabo la escritura de un String en el fichero a través 
    //de la escritura de los caracteres que lo conforman en función del número 
    //de éstos dado por parámetro
    private void escrituraString(String campo, int dimension) throws IOException {
        try {
            //bucle de escritura en el fichero, caracter a caracter, del String
            //y en función de la dimensión dada
            for (int i = 0; ((i < dimension) && (i < campo.length())); i++) {
                //escritura en el fichero del caracter i-ésimo del String
                fichero.writeChar(campo.charAt(i));
            }
            //verificar si la dimensión del String dado es menor que la dimensión
            //del atributo que debe representar del objeto Estudiante
            if (campo.length() < dimension) {
                //al ser la dimnensión del String menor que la dimensión del atributo
                //que representa del objeto Estudiante se escribirán caracteres
                //espacio hasta llegar a la dimensión del atributo
                for (int i = 0; i < (dimension - campo.length()); i++) {
                    //escritura en el fichero del caracter espacio
                    fichero.writeChar(' ');
                }
            }
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    //método getNuevoCodigo() devuelve el código que hay que asignar al nuevo
    //objeto Estudiante a grabar en el fichero
    public int getNuevoCodigo() {
        //DECLARACIONES
        //declaración variable entera para representar nuevo código
        int codigo = 0;

        try {
            //posicionamiento puntero del fichero para escribir el nuevo objeto
            //Estudiante dado al final del fichero
            fichero.seek(fichero.length());
            //obtención y asignación del atributo codigo que le corresponde al
            //nuevo objeto Estudiante a grabar en el fichero
            codigo = ((int) (fichero.length() / Estudiante.getDimension()) + 1);
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
        return codigo;
    }

    //cierre del enlace con el fichero
    public void cierre() throws Exception {
        try {
            fichero.close();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
