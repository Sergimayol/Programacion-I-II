/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_tenis;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sergi
 */
public class Raqueta {

    private int x = 0;
    private int xa = 0;
    private final int WIDTH = 60;
    private final int HEIGHT = 10;
    private final int Y = 330;
    private lamina game;

    public Raqueta(lamina game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x = (x + xa);
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -game.velocidad_movimiento;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = game.velocidad_movimiento;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }
}
