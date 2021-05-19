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
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author Sergi
 */
public class interface_6 {

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
    //DECLARACIÓN COMPONENTE JTextField
    private JTextField texto;
    //DECLARACIÓN COMPONENTE JLabel
    private JLabel etiqueta;

    public static void main(String[] args) {
        new interface_6().inicio();
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
        //DECLARACIÓN Y CONFIGURACIÓN JSplitPane
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane separadorEste = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //CONFIGURACIÓN CONTENEDOR JPanel contenedor de botones acciones
        JPanel panelAcciones = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelAcciones.setBackground(Color.LIGHT_GRAY);
        //Asignación de un GridLayout
        panelAcciones.setLayout(new GridLayout(6, 1));

        //CONFIGURACIÓN CONTENEDOR JPanel contenedor del panel visual
        JPanel panelVisual = new JPanel();
        //Asignación color de fondo al contenedor JPanel panelVisual
        panelVisual.setBackground(Color.LIGHT_GRAY);
        //Asignación de un BorderLayout
        panelVisual.setLayout(new BorderLayout());

        //CONFIGURACIÓN CONTENEDOR JPanel contenedor del panelMenu
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.GREEN.darker());

        //DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu = new JMenuBar();

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JMENUS DE LA BARRA DE MENU
        JMenu primero = new JMenu("PRIMERO");
        JMenu segundo = new JMenu("SEGUNDO");
        JMenu tercero = new JMenu("TERCERO");
        JMenu cuarto = new JMenu("CUARTO");
        //DECLARACIÓN OPCIONES JMenuItem y JRadioButtonMenuItem
        //PRIMERO
        JMenuItem primeroOpcion1 = new JMenuItem("OPCIÓN 1");
        JMenuItem primeroOpcion2 = new JMenuItem("OPCIÓN 2");
        //SEGUNDO
        JMenuItem segundoOpcion1 = new JMenuItem("OPCIÓN 1");
        JMenuItem segundoOpcion2 = new JMenuItem("OPCIÓN 2");
        JMenuItem segundoOpcion3 = new JMenuItem("OPCIÓN 3");
        JMenuItem segundoOpcion4 = new JMenuItem("OPCIÓN 4");
        JMenuItem segundoOpcion5 = new JMenuItem("OPCIÓN 5");
        //TERCERO
        JMenuItem terceroOpcion1 = new JMenuItem("OPCIÓN 1");
        JMenuItem terceroOpcion2 = new JMenuItem("OPCIÓN 2");
        JMenuItem terceroOpcion3 = new JMenuItem("OPCIÓN 3");
        JMenuItem terceroOpcion4 = new JMenuItem("OPCIÓN 4");
        JMenuItem terceroOpcion5 = new JMenuItem("OPCIÓN 5");
        JMenuItem terceroOpcion6 = new JMenuItem("OPCIÓN 6");
        //CUARTO
        JRadioButtonMenuItem cuartoOpcion1 = new JRadioButtonMenuItem("OPCIÓN 1", true);
        JRadioButtonMenuItem cuartoOpcion2 = new JRadioButtonMenuItem("OPCIÓN 2", true);

        //Adición componentes JMenuItem con su correspondiente JMenu
        //PRIMERO
        primero.add(primeroOpcion1);
        primero.add(primeroOpcion2);
        //SEGUNDO
        segundo.add(segundoOpcion1);
        segundo.add(segundoOpcion2);
        segundo.add(segundoOpcion3);
        segundo.add(segundoOpcion4);
        segundo.add(segundoOpcion5);
        //TERCERO
        tercero.add(terceroOpcion1);
        tercero.add(terceroOpcion2);
        tercero.add(terceroOpcion3);
        tercero.add(terceroOpcion4);
        tercero.add(terceroOpcion5);
        tercero.add(terceroOpcion6);
        //CUARTO
        cuarto.add(cuartoOpcion1);
        cuarto.add(cuartoOpcion2);

        //Introducción de la componentes JMenu en el JMenuBar
        barraMenu.add(primero);
        barraMenu.add(segundo);
        barraMenu.add(tercero);
        barraMenu.add(cuarto);

        //Introducción de la componente menuBar en el contenedor
        panelMenu.add(barraMenu);

        //CONFIGURACIÓN etiqueta
        etiqueta = new JLabel("etiqueta");
        etiqueta.setBackground(Color.BLUE.brighter());
        etiqueta.setHorizontalAlignment(JLabel.CENTER);

        //Adición etiqueta al panel de contenidos panelVisual
        panelVisual.add(etiqueta, BorderLayout.CENTER);

        //CONFIGURACIÓN JButton
        boton1 = new JButton("ACCIÓN 1");
        boton2 = new JButton("ACCIÓN 2");
        boton3 = new JButton("ACCIÓN 3");
        boton4 = new JButton("ACCIÓN 4");
        boton5 = new JButton("ACCIÓN 5");
        boton6 = new JButton("SALIR");
        //inclusión de los componentes JButton en el contenedor JPanel
        //panelColores
        panelAcciones.add(boton1);
        panelAcciones.add(boton2);
        panelAcciones.add(boton3);
        panelAcciones.add(boton4);
        panelAcciones.add(boton5);
        panelAcciones.add(boton6);
        //Adición JSlitPane a panelAcciones
        //panelAcciones.add(separadorOeste);
        //Asociación componente JButton, boton1-boton5 y salir, con gestor de evento
        //gestorEventoBotones
        boton1.addActionListener(new interface_6.gestorEventoBotones());
        boton2.addActionListener(new interface_6.gestorEventoBotones());
        boton3.addActionListener(new interface_6.gestorEventoBotones());
        boton4.addActionListener(new interface_6.gestorEventoBotones());
        boton5.addActionListener(new interface_6.gestorEventoBotones());
        boton6.addActionListener(new interface_6.gestorEventoBotones());

        //CONFIGURACION COMPONENTE JTextField
        texto = new JTextField();
        //desactivación EDICIÓN en la componente JTextField texto
        texto.setEditable(false);
        //asignación color de fondo a la componente JTextField texto
        texto.setBackground(Color.MAGENTA);
        //asignación color de trazado a la componente JTextField texto
        texto.setForeground(Color.BLACK);
        //activación justificación centrada en la componente JTextField texto
        texto.setHorizontalAlignment(JTextField.CENTER);
        
        //ADICION DE LA COMPONENTE JPanel al panel de contenidos del contenedor
        //ventana
        panelContenidos.add(panelVisual, BorderLayout.CENTER);
        panelContenidos.add(panelAcciones, BorderLayout.WEST);
        panelContenidos.add(panelMenu, BorderLayout.NORTH);
        panelContenidos.add(texto, BorderLayout.SOUTH);
    }

    //MANIPULADOR EVENTOS COMPONENTES JButton 
    private class gestorEventoBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == boton1) {

            } else if (evento.getSource() == boton2) {

            } else if (evento.getSource() == boton3) {

            } else if (evento.getSource() == boton4) {

            } else if (evento.getSource() == boton5) {

            } else if (evento.getSource() == boton6) {
                //Sale de la aplicación con el cierre de la ventana y la 
                //finalización de la ejecución
                System.exit(0);
            }
        }
    }

    //MANIPULADOR EVENTOS COMPONENTES JMenuBar
    private class gestorEventoMenuBar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            System.out.println("OPCIÓN: " + evento.getActionCommand());
        }
    }
}
