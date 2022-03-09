/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Sergi
 */
public class DataStreamSal {

    //Declaración objeto DataOutputStream para posibilitar la escritura de un
    //fichero a nivel de enteros
    private DataOutputStream DOutS;

    public DataStreamSal(String s) {
        try {
            DOutS = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(s)));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void escribirEnteros(int i) {
        try {
            DOutS.writeInt(i);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void escribirReales(double i) {
        try {
            DOutS.writeDouble(i);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void escribirChar(int i) {
        try {
            DOutS.writeChar('a' + i);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }

    public void close() {
        try {
            DOutS.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (Exception error) {
            System.out.println(error.toString());
        } finally {
            try {
                DOutS.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            } catch (Exception error) {
                System.out.println(error.toString());
            }
        }
    }
}
