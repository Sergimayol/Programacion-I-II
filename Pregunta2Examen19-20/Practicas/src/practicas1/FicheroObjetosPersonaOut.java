package practicas1;

/*
CLASE FicheroObjetosPersonaOut
AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA LLEVAR A CABO LA GESTIÓN 
DE FICHEROS DE OBJETOS Persona A NIVEL DE ESCRITURA
autor: Juan Montes de Oca
*/

import java.io.*;

public class FicheroObjetosPersonaOut {
    //ATRIBUTOS
    //declaración objeto ObjectOutputStream para posibilitar la escritura en ficheros
    //a nivel de objetos Persona
    private ObjectOutputStream fichero=null;
    
    //MÉTODO CONSTRUCTOR
    public FicheroObjetosPersonaOut(String nombreFichero) { 
       try {
            //instanciación objeto ObjectOutputStream con el fichero dado
            //para posibilitar la escritura de objetos Persona
            fichero= new ObjectOutputStream(new BufferedOutputStream(
                                new FileOutputStream(nombreFichero)));      
       }
       catch (IOException error) {
           System.out.println("ERROR: "+error.toString());
       } 
   }     

    //MÉTODOS FUNCIONALES
    
    //MÉTODO escritura LLEVA A CABO LA ESCRITURA DE UN OBJETO Persona EN EL FICHERO
    //ENLAZADO CON EL OBJETO FicheroObjetosPersonaOut
    public void escritura(Persona persona) {
        try {
            //escritura objeto Persona dado
            fichero.writeObject(persona);
        }
        catch (IOException error) {
            System.out.println("ERROR: "+error.toString());
        }   
    
    }
     
    //MÉTODO cierre LLEVA A CABO EL CIERRE DEL ENLACE CON EL FICHERO
    public void cierre() {
        try {
            //verificar si el enlace con el fichero no es null
            if (fichero!=null) {
                    fichero.close();        
            }
        }catch (IOException error) {
           System.out.println("ERROR: "+error.toString()); 
        } 
    }
}
   

