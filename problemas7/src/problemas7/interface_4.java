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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sergi
 */
public class interface_4 {

    //DECLARACIÓN COMPONENTES JButton
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    //DECLARACIÓN OBJETO Container PARA REPRESENTAR EL PANEL DE
    //CONTENIDOS DEL OBJETO JFrame
    private Container panelContenidos;
    //DECLARACIÓN JTextArea
    private JTextArea display;
    //DECLARACIÓN JFrame
    private JFrame ventana;

    public static void main(String[] args) {
        new interface_4().inicio();
    }

    private void inicio() {
        //CONFIGURACIÓN CONTENEDOR JFrame
        ventana = new JFrame();
        //Añadimos un titulo a la ventana
        ventana.setTitle("interface_4");
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
        //DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JPanel
        JPanel panelBotones = new JPanel();
        //asignación color de fondo al contenedor JPanel panelBotones
        panelBotones.setBackground(Color.LIGHT_GRAY);

        //DECLARACIÓN Y CONFIGURACIÓN JButton
        boton1 = new JButton("SELECCIONAR");
        boton2 = new JButton("LEER");
        boton3 = new JButton("VISUALIZAR");
        boton4 = new JButton("BORRAR");
        boton5 = new JButton("SALIR");
        //Asignación color a cada boton
        boton1.setBackground(Color.RED);
        boton2.setBackground(Color.MAGENTA);
        boton3.setBackground(Color.BLUE.darker());
        boton4.setBackground(Color.LIGHT_GRAY.darker());
        boton5.setBackground(Color.YELLOW.darker());
        //Asignación color de letra a cada boton
        boton1.setForeground(Color.WHITE);
        boton2.setForeground(Color.WHITE);
        boton3.setForeground(Color.WHITE);
        boton4.setForeground(Color.WHITE);
        boton5.setForeground(Color.WHITE);
        //inclusión de los componentes JButton en el contenedor JPanel
        //panelBotones
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        //Asociación componente JButton boton1-boton5 con gestor de evento
        //gestorEventoBotones
        boton1.addActionListener(new gestorEventoBotones());
        boton2.addActionListener(new gestorEventoBotones());
        boton3.addActionListener(new gestorEventoBotones());
        boton4.addActionListener(new gestorEventoBotones());
        boton5.addActionListener(new gestorEventoBotones());

        //ADICION DE LA COMPONENTE JPanel al panel de contenidos del contenedor
        //ventana
        panelContenidos.add(panelBotones, BorderLayout.NORTH);

        //CONFIGURACIÓN CONTENEDOR JTextArea
        display = new JTextArea();
        //desactivación EDICIÓN en la componente JTextArea 
        display.setEditable(false);
        //asignación color de fondo a la componente JTextArea 
        display.setBackground(Color.WHITE);

        //DECLARACIÓN Y CONFIGURACIÓN CONTENEDOR JScrollPane
        JScrollPane barraScroll = new JScrollPane(display);

        //ADICION DE LA COMPONENTE JScrollPane al panel de contenidos del 
        //contenedor ventana, con ello también se introduce en el contenedor la 
        //JTextArea display a la que se le ha asociado
        panelContenidos.add(barraScroll, BorderLayout.CENTER);
    }

    //MANIPULADOR EVENTOS COMPONENTES JButton 
    private class gestorEventoBotones implements ActionListener {
        
        //Atributo que contendrá en path del fichero
        private String fichero = "";
        private String contenidoFichero = "";

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == boton1) {
                //LLeva a cabo la selccion de fichero
                //Declaración componente JFileChooser
                JFileChooser ventanaSeleccion = new JFileChooser();
                // ABRE VENTANA DE DIRECTORIOS Y FICHEROS
                int op = ventanaSeleccion.showOpenDialog(ventana);
                if (op == JFileChooser.APPROVE_OPTION) {
                    //System.out.println(ventanaSeleccion.getSelectedFile());
                    fichero = ventanaSeleccion.getSelectedFile().getAbsolutePath();
                    //System.out.println(fichero);
                }
            } else if (evento.getSource() == boton2) {
                //LLeva a cabo la lectura del fichero seleccionado en el boton1
                //Declarar clase FicheroIn para leer un fichero 
                FicheroIn ficheroLectura;
                boolean bucle = false;
                String frase;
                try {
                    if (fichero != null && !fichero.isEmpty()) {
                        ficheroLectura = new FicheroIn(fichero);
                        try {
                            while (!bucle) {
                                if (contenidoFichero != null && !contenidoFichero.isEmpty()) {
                                    frase = ficheroLectura.lectura();
                                    contenidoFichero = contenidoFichero + frase;
                                } else {
                                    bucle = true;
                                }
                            }
                        } catch (Exception error) {
                            System.out.println("Error 1: " + error.toString());
                        }
                    } else {
                        display.setText("NO HAY FICHERO SELECCIONADO.");
                    }
                } catch (Exception error) {
                    System.out.println("Error 2: " + error.toString());
                }
            } else if (evento.getSource() == boton3) {
                //Visualiza el contenido del fichero seleccionado
                if ((fichero != null && !fichero.isEmpty())
                        && (contenidoFichero != null && !contenidoFichero.isEmpty())) {
                    display.setText(contenidoFichero);
                } else {
                    display.setText("NO HAY FICHERO SELECCIONADO/LEIDO.");
                }
            } else if (evento.getSource() == boton4) {
                //Lleva a cabo el borrado del contenido del área de visualización  
                //de la interface así como la inicialización de selección
                //y lectura
                display.setText(" ");
                contenidoFichero = "";
                fichero = "";
            } else if (evento.getSource() == boton5) {
                //Sale de la aplicación con el cierre de la ventana y la 
                //finalización de la ejecución
                System.exit(0);
            }
        }
    }
}
