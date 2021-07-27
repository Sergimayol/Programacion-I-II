/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas2;

import java.awt.Color;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Sergi
 */
public enum SetzeColors implements java.io.Serializable {
    AQUA(0, 255, 255),
    BLACK(0, 0, 0),
    BLUE(0, 0, 255),
    FUCHSIA(255, 0, 255),
    GRAY(128, 128, 128),
    GREEN(0, 128, 0),
    LIME(0, 255, 0),
    MAROON(128, 0, 0),
    NAVY(0, 0, 128),
    OLIVE(128, 128, 0),
    PURPLE(128, 0, 128),
    RED(255, 0, 0),
    SILVER(192, 192, 192),
    TEAL(0, 128, 128),
    WHITE(255, 255, 255),
    YELLOW(255, 255, 0);

    private Integer red, green, blue;

    private SetzeColors(final Integer red, final Integer green, final Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setColores(int i, int j, int x) {
        red = i;
        green = j;
        blue = x;
    }

    public Integer getRed() {
        return red;
    }

    public Integer getGreen() {
        return green;
    }

    public Integer getBlue() {
        return blue;
    }

    public Color toColor() {
        return new Color(red, green, blue);
    }

    public SetzeColors setColorAleatorio() {
        Random ran = new Random();
        int x = ran.nextInt(16);
        SetzeColors color;
        SetzeColors[] colores = new SetzeColors[16];
        colores = SetzeColors.values();
        color = colores[x];
//        colores[0] = AQUA;
//        colores[1] = BLACK;
//        colores[2] = BLUE;
//        colores[3] = FUCHSIA;
//        colores[4] = GRAY;
//        colores[5] = GREEN;
//        colores[6] = LIME;
//        colores[7] = MAROON;
//        colores[8] = NAVY;
//        colores[9] = OLIVE;
//        colores[10] = PURPLE;
//        colores[11] = RED;
//        colores[12] = SILVER;
//        colores[13] = TEAL;
//        colores[14] = WHITE;
//        colores[15] = YELLOW;
//        color = colores[x];
        return color;
    }
    
    public boolean menor(SetzeColors c){
        if(red < c.getRed()){
            return true; 
        } else if((Objects.equals(red, c.getRed()))&& (green < c.getGreen())){
            return true;
        } else if ((Objects.equals(red, c.getRed()))&&(blue<c.getBlue())
                &&(Objects.equals(green, c.getGreen()))){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = this.name();
        for (int i = this.name().length(); i < 7; i++) {
            s += " ";
        }
        return s;
    }
}
