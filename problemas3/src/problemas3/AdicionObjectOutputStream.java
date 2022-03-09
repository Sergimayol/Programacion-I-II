package problemas3;

/**
 * Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
 * al principio del Stream y posibilite la adición de objetos en ficheros
 */

import java.io.*;

public class AdicionObjectOutputStream extends ObjectOutputStream { 
    /** Constructor que recibe OutputStream
     * @param out
     * @throws java.io.IOException */
    public AdicionObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    /** Constructor
     * @throws java.io.IOException */
    protected AdicionObjectOutputStream() throws IOException, SecurityException {
        super(); //ejecuta el constructor de la clase madre ObjectOutputStream
    }

    /** Redefinición del método de escribir la cabecera para que no haga nada.
     * @throws java.io.IOException */
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
