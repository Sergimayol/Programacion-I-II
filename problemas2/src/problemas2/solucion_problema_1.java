/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

/**
 *
 * @author Sergi
 */
public class solucion_problema_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new solucion_problema_1().inicio();
    }

    private void inicio() {
        //Instanciar las clases necesarias
        FileStreamEn FSEn = new FileStreamEn("caracteres.dat");
        FileStreamSal FSESal_1 = new FileStreamSal("vocales.dat");
        FileStreamSal FSESal_2 = new FileStreamSal("consonantes.dat");
        //Declarar varibles ncesarias e incializarlas
        int codigo;
        char contenido_codigo;
        //Leer primer byte
        codigo = FSEn.leer();
        //Mientras no sea final de fichero quiero que siga leyendo
        while (codigo != -1) {
            //Convertir el byte en char para poder analizarlo
            contenido_codigo = (char) codigo;
            //si el byte leido contiene una vocal se escribe en vocales.dat
            if (contieneVocal(contenido_codigo)) {
                FSESal_1.escribir(codigo);
                //Si el byte leido contiene una consonante se escribe en consonantes.dat
            } else if (contieneConsonante(contenido_codigo)) {
                FSESal_2.escribir(codigo);
            }
            //Leer siguiente byte
            codigo = FSEn.leer();
        }
        //Cerrar FileInputStream y FileOutputStream
        FSEn.close();
        FSESal_1.close();
        FSESal_2.close();
    }

    //Comprueba si contiene alguna vocal
    private boolean contieneVocal(char car) {
        return ((car == 'a') || (car == 'e') || (car == 'i')
                || (car == 'o') || (car == 'u'));
    }

    //Comprueba si contiene alguna consonante
    private boolean contieneConsonante(Character car) {
        return ((car > 97 && car <= 122));
    }
}
