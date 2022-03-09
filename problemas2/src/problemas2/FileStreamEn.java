/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class FileStreamEn {

    //DECLARACIONES
    //declaración constante entera que representa el código de final de fichero
    private final int FINAL_FICHERO = -1;
    //declaración objeto FileInputStream y BufferedInputStream para posibilitar    
    //la lectura de un fichero a nivel de bytes
    private FileInputStream FInS;
    private BufferedInputStream BInS;
    //declaración variable entera para almacenar los bytes, uno a uno, que
    //van siendo leidos desde el fichero
    private int codigo;

    public FileStreamEn(String s) {
        try {
            FInS = new FileInputStream(s);
            BInS = new BufferedInputStream(FInS);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public int leer() {
        try {
            //lectura primer byte del fichero
            codigo = BInS.read();
            //bucle de lectura y visualización
            if (codigo != FINAL_FICHERO) {
                //visualización byte leido
                System.out.print(codigo + " ");
            } else {
                return FINAL_FICHERO;
            }
        } catch (IOException error) {
            System.out.println(error.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
        return codigo;
    }

    public void close() {
        try {
            FInS.close();
            BInS.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        } finally {
            try {
                FInS.close();
                BInS.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception error) {
                System.out.println(error.toString());
            }
        }
    }
}
