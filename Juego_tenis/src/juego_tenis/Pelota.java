/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_tenis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Pelota extends JPanel {

    private final int DIAMETRO_PELOTA = 30;
    private int x = 0;
    private int y = 0;
    private int xa = 1;
    private int ya = 1;
    private lamina game;

    public Pelota(lamina game) {
        this.game = game;
    }

    public void move() {
        if (x + xa < 0) {
            xa = game.velocidad_movimiento;
        } else if (x + xa > game.getWidth() - DIAMETRO_PELOTA) {
            xa = -game.velocidad_movimiento;
        } else if (y + ya < 0) {
            ya = game.velocidad_movimiento;
        } else if (y + ya > game.getHeight() - DIAMETRO_PELOTA) {
            game.gameOver();
        } else if (colision()) {
            ya = -game.velocidad_movimiento;
            y = game.raqueta.getTopY() - DIAMETRO_PELOTA;
            game.velocidad_movimiento++;
        }
        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETRO_PELOTA, DIAMETRO_PELOTA);
    }

    private boolean colision() {
        return game.raqueta.getBounds().intersects(getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETRO_PELOTA, DIAMETRO_PELOTA);
    }
}
