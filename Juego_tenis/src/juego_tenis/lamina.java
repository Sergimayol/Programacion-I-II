/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_tenis;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergi
 */
public class lamina extends JPanel {

    public int velocidad_movimiento = 1;
    Raqueta raqueta = new Raqueta(this);
    Pelota pelota = new Pelota(this);

    public lamina() {
        //Evento de teclado para conseguir que 
        //la raqueta se pueda desplazar con las flechas
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                raqueta.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                raqueta.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    //Devuelve la puntuación obtenida
    private int getScore() {
        return velocidad_movimiento - 1;
    }

    //Con este método conseguimos que la pelota y la raqueta 
    //se puedan desplazar en la lamina
    public void move() {
        raqueta.move();
        pelota.move();
    }

    @Override
    public void paintComponent(Graphics g) { 
        //LLamar al método de la clase padre
        super.paintComponent(g); 
        //Refundición
        Graphics2D g2D = (Graphics2D) g; 
        //Con estos métodos se consigue una mayor precisión 
        //de golpeo y calidad de dibujo
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //Pintar la pelota y la raqueta en la lamina
        pelota.paint(g2D);
        raqueta.paint(g2D);

        //PUNTUCIACIÓN
        g2D.setColor(Color.GRAY);
        g2D.setFont(new Font("Verdana", Font.BOLD, 30));
        g2D.drawString(String.valueOf(getScore()), 10, 30);
    }
    
    //Mensaje al perder el juego
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Has conseguido una puntuación total de: "
                + getScore(),"Game Over", JOptionPane.YES_NO_OPTION);
        //Cerrar el juego al perder, ya que sino se quedaría en bucle
        System.exit(0);      
    }

}
