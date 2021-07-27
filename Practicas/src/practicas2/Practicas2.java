/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas2;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sergi
 */
public class Practicas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Practicas2().metodoPrincipal();
    }

    private void metodoPrincipal() {
        boolean fin = false;
        try {
            while (!fin) {
                visualizacionMenu();
                int opcion = LT.readInt();
                switch (opcion) {
                    case 1:
                        IniFicheroColores();
                        leerObjectosColor();
                        continuar();
                        break;
                    case 2:
                        CalculoColorPromedio();
                        continuar();
                        break;
                    case 3:
                        ArrayColorOrdenado();
                        continuar();
                        break;
                    default:
                        fin = true;
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR(metodo Principal): " + error.toString());
        }
    }

    private void IniFicheroColores() {
        FicheroObjetosColoresOut objetoColor;
        String ficheroColores = "Colores.dat";
        int x = 0;
        SetzeColors color = SetzeColors.BLACK;
        try {
            objetoColor = new FicheroObjetosColoresOut(ficheroColores);
            try {
                while (x <= 16) {
                    color = color.setColorAleatorio();
                    objetoColor.escritura(color);
                    x++;
                }
                objetoColor.escritura(SetzeColors.BLACK);
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                try {
                    objetoColor.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void leerObjectosColor() {
        FicheroObjetosColoresIn lecturaColores;
        String ficheroColores = "Colores.dat";
        SetzeColors color;
        try {
            lecturaColores = new FicheroObjetosColoresIn(ficheroColores);
            try {
                color = lecturaColores.lectura();
                System.out.println("CONTEDIDO DE " + ficheroColores + ":");
                while (color != SetzeColors.BLACK) {
                    System.out.println(color);
                    color = lecturaColores.lectura();
                }
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    lecturaColores.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void CalculoColorPromedio() {
        FicheroObjetosColoresIn objetoColor;
        String ficheroColores = "Colores.dat";
        SetzeColors color;
        int rojo = 0, verde = 0, azul = 0, x = 0;
        try {
            objetoColor = new FicheroObjetosColoresIn(ficheroColores);
            try {
                color = objetoColor.lectura();
                if (color != SetzeColors.BLACK) {
                    while (color != SetzeColors.BLACK) {
                        rojo = rojo + color.getRed();
                        verde = verde + color.getGreen();
                        azul = azul + color.getBlue();
                        x++;
                        color = objetoColor.lectura();
                    }
                    color.setColores(rojo / x, verde / x, azul / x);
                    System.out.println("Color promedio: " + color.toColor());
                } else {
                    throw new DatosInsuficientes("Datos insuficientes para"
                            + "realizar el promedio.");
                }
            } catch (DatosInsuficientes error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                try {
                    objetoColor.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void ArrayColorOrdenado() {
        FicheroObjetosColoresIn lecturaColores;
        String ficheroColores = "Colores.dat";
        SetzeColors color1;
        SetzeColors color2;
        ArrayList arrayColores = new ArrayList();
        try {
            lecturaColores = new FicheroObjetosColoresIn(ficheroColores);
            try {
                color1 = lecturaColores.lectura();
                color2 = lecturaColores.lectura();
                while (color1 != SetzeColors.BLACK && 
                        color2 != SetzeColors.BLACK) {
                    if (color1.menor(color2)) {
                        arrayColores.add(color1);
                    } else {
                        arrayColores.add(color2);
                    }
                    color2 = color1;
                    color1 = lecturaColores.lectura();
                }
                System.out.println(arrayColores);
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                try {
                    lecturaColores.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void visualizacionMenu() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "FICHERO DE INFECCIÓN\n\n\n");
        System.out.print("         1. Iniciar fichero de colores.\n");
        System.out.print("         2. Cálculo del color promedio.\n");
        System.out.print("         3. Array de Color ordenado.\n");
        System.out.print("         0. Salir.\n\n\n");
        System.out.print("[] opcion: ");
    }

    private void continuar() {
        System.out.print("\n\n< CONTINUAR --> RETURN > ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }
}
