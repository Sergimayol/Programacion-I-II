/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class interface_5 {

    //DECLARACIÓN JFrame
    private JFrame ventana;
    //DECLARACIÓN OBJETO Container PARA REPRESENTAR EL PANEL DE
    //CONTENIDOS DEL OBJETO JFrame
    private Container panelContenidos;
    //DECLARACIÓN COMPONENTES JButton
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton boton7;
    //DECLARACIÓN JComponent
    private panelDibujo dibujo;
    private Color color;

    public static void main(String[] args) {
        new interface_5().inicio();
    }

    private void inicio() {
        //CONFIGURACIÓN CONTENEDOR JFrame
        ventana = new JFrame();
        //Añadimos un titulo a la ventana
        ventana.setTitle("interface_5");
        //Alamacena en la variable nuestro sistema nativo de ventanas
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        //Tamañano de la pantalla del usuario
        Dimension tampant = pantalla.getScreenSize();
        //Obtener el alto de resolución de pantalla
        int altpant = tampant.height;
        //Obtener el ancho de resolución de pantalla
        int anchopant = tampant.width;
        //Localización(x,y) + tamaño(ancho,alto). De esta manera siempre
        //la ventana estará situada en el centro
        ventana.setBounds(anchopant / 4, altpant / 4, anchopant / 2, altpant / 2);
        //Activar el cierre interactivo del contenedor JFrame ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Asignación al objeto Container panelContenidos DEL PANEL JContentPane 
        //del JFrame 
        panelContenidos = ventana.getContentPane();
        //asignación administrador de Layout BordeLayout al panel de contenidos
        //del JFrame
        panelContenidos.setLayout(new BorderLayout());

        //Metodo encargado de la gestion de la interface
        metodoPrincipal();

        //Activar visualización contenedor JFrame ventana
        ventana.setVisible(true);
    }

    private void metodoPrincipal() {
        //DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JPanel contenedor de 
        //botones colores
        JPanel panelColores = new JPanel();
        //asignación color de fondo al contenedor JPanel panelColores
        panelColores.setBackground(Color.LIGHT_GRAY);
        panelColores.setLayout(new GridLayout(6, 1));
        //DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JPanel contenedor de 
        //botones colores
        JPanel panelSalir = new JPanel();
        //asignación color de fondo al contenedor JPanel panelColores
        panelSalir.setBackground(Color.BLACK);

        //CONFIGURACIÓN JButton
        boton1 = new JButton("ROJO");
        boton2 = new JButton("VERDE");
        boton3 = new JButton("AZUL");
        boton4 = new JButton("CYAN");
        boton5 = new JButton("MAGENTA");
        boton6 = new JButton("AMARILLO");
        boton7 = new JButton("SALIR");
        //Asignación color a cada boton
        boton1.setBackground(Color.RED);
        boton2.setBackground(Color.GREEN);
        boton3.setBackground(Color.BLUE);
        boton4.setBackground(Color.CYAN);
        boton5.setBackground(Color.MAGENTA);
        boton6.setBackground(Color.YELLOW.darker());
        boton7.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        boton1.setForeground(Color.BLACK);
        boton2.setForeground(Color.BLACK);
        boton3.setForeground(Color.BLACK);
        boton4.setForeground(Color.BLACK);
        boton5.setForeground(Color.BLACK);
        boton6.setForeground(Color.BLACK);
        boton7.setForeground(Color.WHITE);
        //inclusión de los componentes JButton en el contenedor JPanel
        //panelColores
        panelColores.add(boton1);
        panelColores.add(boton2);
        panelColores.add(boton3);
        panelColores.add(boton4);
        panelColores.add(boton5);
        panelColores.add(boton6);
        //inclusión de los componentes JButton en el contenedor JPanel
        //panelSalir
        panelSalir.add(boton7);

        //Asociación componente JButton boton1-boton7 con gestor de evento
        //gestorEventoBotones
        boton1.addActionListener(new interface_5.gestorEventoBotones());
        boton2.addActionListener(new interface_5.gestorEventoBotones());
        boton3.addActionListener(new interface_5.gestorEventoBotones());
        boton4.addActionListener(new interface_5.gestorEventoBotones());
        boton5.addActionListener(new interface_5.gestorEventoBotones());
        boton6.addActionListener(new interface_5.gestorEventoBotones());
        boton7.addActionListener(new interface_5.gestorEventoBotones());

        //CONFIGURACIÓN panelDibujo
        dibujo = new panelDibujo();

        //ADICION DE LA COMPONENTE JPanel al panel de contenidos del contenedor
        //ventana
        panelContenidos.add(panelColores, BorderLayout.WEST);
        panelContenidos.add(panelSalir, BorderLayout.SOUTH);
        panelContenidos.add(dibujo, BorderLayout.CENTER);
    }
    //MANIPULADOR EVENTOS COMPONENTES JButton 

    private class gestorEventoBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == boton1) {
                //Seleccionamos el color rojo y pintamos de nuevo el fondo
                dibujo.setRED();
                dibujo.repaint();
            } else if (evento.getSource() == boton2) {
                //Seleccionamos el color verde y pintamos de nuevo el fondo
                dibujo.setGREEN();
                dibujo.repaint();
            } else if (evento.getSource() == boton3) {
                //Seleccionamos el color azul y pintamos de nuevo el fondo
                dibujo.setBLUE();
                dibujo.repaint();
            } else if (evento.getSource() == boton4) {
                //Seleccionamos el color cyan y pintamos de nuevo el fondo
                dibujo.setCYAN();
                dibujo.repaint();
            } else if (evento.getSource() == boton5) {
                //Seleccionamos el color magenta y pintamos de nuevo el fondo
                dibujo.setMAGENTA();
                dibujo.repaint();
            } else if (evento.getSource() == boton6) {
                //Seleccionamos el color amarillo y pintamos de nuevo el fondo
                dibujo.setYELLOW();
                dibujo.repaint();
            } else if (evento.getSource() == boton7) {
                //Sale de la aplicación con el cierre de la ventana y la 
                //finalización de la ejecución
                System.exit(0);
            }
        }
    }

    private class panelDibujo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //asignamos un color inicial al rectángulo
            g.setColor(Color.LIGHT_GRAY);
            //asignar el color del fondo dependiendo del color que se le asigne
            g.setColor(getColor());
            //se visualiza un rectángulo de dimensión igual a la dimensión  de
            //del contenedor JPanel que se está instanciando
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        //Métodos para hacer un set de color
        private void setRED() {
            color = Color.RED;
        }

        private void setGREEN() {
            color = Color.GREEN;
        }

        private void setBLUE() {
            color = Color.BLUE;
        }

        private void setCYAN() {
            color = Color.CYAN;
        }

        private void setMAGENTA() {
            color = Color.MAGENTA;
        }

        private void setYELLOW() {
            color = Color.YELLOW.darker();
        }

        //Devuelve el color que esta guardado en la variable
        private Color getColor() {
            return color;
        }
    }

}
