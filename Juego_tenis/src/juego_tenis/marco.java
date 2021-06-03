/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_tenis;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Sergi
 */
public class marco extends JFrame {

    public marco() {
        setTitle("Retro Mini Tenis");//Nombre del título de la ventana.
        Toolkit pantalla = Toolkit.getDefaultToolkit();//Alamacena en la variable nuestro sistema nativo de ventanas
        Dimension tampant = pantalla.getScreenSize(); //Tamañano de la pantalla del usuario
        int altpant = tampant.height;//Obtener el alto de resolución de pantalla
        int anchopant = tampant.width; // Obtener el ancho de resolución de pantalla
        setBounds(anchopant / 4, altpant / 4, 300, 400);
        Image Icono = pantalla.getImage("descarga.png");//Selecionar icono de la ventana que deseamos poner(indicando ruta)
        setIconImage(Icono);//Cambiar el icono de la ventana por el selecionado anteriormente
        lamina lam = new lamina();//Instanciar la lamina donde vamos a escribir,dibujar, etc...       
        add(lam);//Añadimos la laminia a la ventana        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //No cerrar directamente el programa al cerrar ventana
        setVisible(true);//Hacer visible la ventana
        while (true) {
            lam.move();
            lam.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(marco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
