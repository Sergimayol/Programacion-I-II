/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primertallerevaluable;

/**
 *
 * @author Sergi
 */
public class Data implements java.io.Serializable {

    private int Dia;
    private int Mes;
    private int Anyo;
    private int Hora;
    private int Minuto;
    private String dia;
    private String mes;
    private String anyo;
    private String hora;
    private String minuto;

    public Data(String dato) {
        leerFecha(dato);
    }

    private void leerFecha(String dato) {
        char[] d = {'0', '0'};
        char[] m = {'0', '0'};
        char[] a = {'0', '0'};
        char[] h = {'0', '0'};
        char[] min = {'0', '0'};
        char[] fecha = dato.toCharArray();

        boolean numeroDia = false;
        boolean numeroMes = false;
        boolean numeroAnyo = false;
        boolean numeroHora = false;
        boolean numeroMin = false;

        try {
            for (int i = 0; i < fecha.length; i++) {
                while (numeroDia != true) {
                    if (fecha[i] == '/') {
                        Dia = aInt(d);
                        dia = aString(d);
                        numeroDia = true;
                        i++;
                    } else {
                        d[0] = d[1];
                        d[1] = fecha[i];
                        i++;
                    }
                }
                while (numeroMes != true) {
                    if (fecha[i] == '/') {
                        Mes = aInt(m);
                        mes = aString(m);
                        numeroMes = true;
                        i++;
                    } else {
                        m[0] = m[1];
                        m[1] = fecha[i];
                        i++;
                    }
                }
                while (numeroAnyo != true) {
                    if (fecha[i] == ' ') {
                        anyo = aString(a);
                        Anyo = aInt(a);
                        numeroAnyo = true;
                        i++;
                    } else {
                        a[0] = a[1];
                        a[1] = fecha[i];
                        i++;
                    }
                }
                while (numeroHora != true) {
                    if (fecha[i] == ':') {
                        Hora = aInt(h);
                        hora = aString(h);
                        numeroHora = true;
                        i++;
                    } else {
                        h[0] = h[1];
                        h[1] = fecha[i];
                        i++;
                    }
                }
                while (numeroMin != true) {
                    min[0] = min[1];
                    min[1] = fecha[i];
                    i++;
                    min[0] = min[1];
                    min[1] = fecha[i];
                    Minuto = aInt(min);
                    minuto = aString(min);
                    numeroMin = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public int toValor() {
        String valorData = "";
        int valor = 0;
        valorData += anyo;
        valorData += mes;
        valorData += dia;
        valorData += hora;
        valorData += minuto;
        try {
            valor = Integer.parseInt(valorData);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        } catch (Exception e2) {
            System.out.println("Error: " + e2.toString());
        }
        return valor;
    }

    @Override
    public String toString() {
        return Dia + "/" + Mes + "/" + Anyo + " " + hora + ":" + minuto;
    }

    private int aInt(char[] d) {
        int valor = 0;
        try {
            char[] datos = d;
            valor = Integer.parseInt(new String(datos));
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
        return valor;
    }

    private String aString(char[] d) {
        char[] datos = d;
        String valor = new String(datos);
        return valor;
    }
}
