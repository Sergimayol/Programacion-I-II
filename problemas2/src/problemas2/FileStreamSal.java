/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class FileStreamSal {

    //DECLARACIONES
    //declaración objeto FileOutputStream y BufferedOutputStream para posibilitar    
    //la escritura de objetos a nivel de bytes
    private FileOutputStream FOutS;
    private BufferedOutputStream BOutS;

    public FileStreamSal(String s) {        
        try {
            FOutS = new FileOutputStream(s);
            BOutS = new BufferedOutputStream(FOutS);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void escribir(int i) {
        try {
            BOutS.write(i);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void close() {
        try {
            FOutS.close();
            BOutS.close();
            BOutS.flush();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        } finally {
            try {
                FOutS.close();
                BOutS.close();
                BOutS.flush();
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception error) {
                System.out.println(error.toString());
            }
        }
    }
}
