/*
EXEPCIÓN NO PREDEFINIDA
 */


package problemas5;


public class EntradaIncorrecta extends Exception {
    public EntradaIncorrecta (String mensaje) {
        super("¡¡¡¡ "+mensaje+" !!!!");
    }
}
