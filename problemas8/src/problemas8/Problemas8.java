/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;

/**
 *
 * @author Sergi
 */
public class Problemas8 extends JFrame {

    //DECLARACIÓN OBJETO Container PARA REPRESENTAR EL PANEL DE
    //CONTENIDOS DEL OBJETO JFrame
    private Container panelContenidos;
    //DECLARACIÓN DE ATRIBUTO COLOR PARA GESTIONAR EL COLOR DE FONDO
    private Color colorFondo = Color.BLACK;
    //DECLARACIÓN JComponent
    private panelDibujo dibujo;
    //DECLARACIÓN DE ATRIBUTO INT PARA GESTIONAR LA FIGURA A DIBUJAR
    private int figura = 0;
    //DECLARACIÓN DE ATRIBUTO COLOR PARA GESTIONAR EL COLOR DE TRAZADO
    private Color colorTrazadoFiguras = Color.WHITE;
    //DECLARACIÓN ATRIBUTO BOOLEAN PARA PODER SLECCIONAR SI COLOREAR O NO UNA FIGURA
    private boolean coloreado = false;

    public static void main(String[] args) {
        new Problemas8().inicio();
    }

    private void inicio() {
        //Añadimos un titulo a la ventana
        setTitle("interface_7");
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
        setBounds(anchopant / 4, altpant / 4, anchopant / 2, altpant / 2);
        //Activar el cierre interactivo del contenedor JFrame ventana para finalizar
        //ejecución
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Asignación al objeto Container panelContenidos DEL PANEL JContentPane 
        //del JFrame 
        panelContenidos = getContentPane();
        //asignación administrador de Layout BordeLayout al panel de contenidos
        //del JFrame
        panelContenidos.setLayout(new BorderLayout());

        //Metodo encargado de la gestion de la interface
        metodoPrincipal();

        //Activar visualización contenedor JFrame ventana
        setVisible(true);
    }

    private void metodoPrincipal() {
        //MANIPULADOR EVENTOS COMPONENTES JMenuBar y JButton para el cambio de colores
        ActionListener gestorEventosColores = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                switch (evento.getActionCommand()) {
                    case "ROJO":
                        colorFondo = Color.RED;
                        break;
                    case "VERDE":
                        colorFondo = Color.GREEN;
                        break;
                    case "AZUL":
                        colorFondo = Color.BLUE;
                        break;
                    case "CYAN":
                        colorFondo = Color.CYAN;
                        break;
                    case "MAGENTA":
                        colorFondo = Color.MAGENTA;
                        break;
                    case "AMARILLO":
                        colorFondo = Color.YELLOW;
                        break;
                }
                //Refrescar ventana gráfica Dibujo
                dibujo.repaint();
            }
        };
        //MANIPULADOR EVENTOS COMPONENTES JButton para finalizar programa
        ActionListener gestorEventoElegirColor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                switch (evento.getActionCommand()) {
                    case "COLOR TRAZADO":
                        //Mostramos el dialogo, indicamos el panel, el titulo del dialogo y un color por defecto
                        //Devuelve un color
                        colorTrazadoFiguras = JColorChooser.showDialog(panelContenidos, "Elige un color", Color.BLACK);
                        break;
                }
                //Refrescar ventana gráfica Dibujo
                dibujo.repaint();
            }
        };
        //MANIPULADOR EVENTOS COMPONENTES JButton para finalizar programa
        ActionListener gestorEventoSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                switch (evento.getActionCommand()) {
                    case "SALIR":
                        //Sale de la aplicación con el cierre de la ventana y la 
                        //finalización de la ejecución
                        System.exit(0);
                        break;
                }
            }
        };
        //MANIPULADOR EVENTOS COMPONENTES JButton y JMenu para colorear o no una figura
        ActionListener gestorEventosColorear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                switch (evento.getActionCommand()) {
                    case "COLOREADO":
                        coloreado = true;
                        break;
                    case "SIN COLOREAR":
                        coloreado = false;
                        break;
                }
                //Refrescar ventana gráfica Dibujo
                dibujo.repaint();
            }
        };
        //MANIPULADOR EVENTOS COMPONENTES JButton para finalizar programa
        ActionListener gestorEventosFiguras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                switch (evento.getActionCommand()) {
                    case "RECTANGULO":
                        figura = 1;
                        break;
                    case "ELIPSE":
                        figura = 2;
                        break;
                    case "POLILINEA":
                        figura = 3;
                        break;
                    case "POLIGONO":
                        figura = 4;
                        break;
                    case "TEXTO":
                        figura = 5;
                        break;
                    case "BORRAR":
                        figura = 0;
                        break;
                }
                //Refrescar ventana gráfica Dibujo
                dibujo.repaint();
            }
        };
        //CONFIGURACIÓN CONTENEDOR JPanel contenedor del panelMenu
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.LIGHT_GRAY.darker());

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de botones 
        JPanel panelVarios = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelVarios.setBackground(Color.LIGHT_GRAY.darker());

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JRadioButton
        JPanel panelColoreado = new JPanel();
        //asignación color de fondo al contenedor JPanel panelColoreado
        panelColoreado.setBackground(Color.BLACK);
        panelColoreado.setLayout(new BorderLayout());

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JButton
        JPanel panelColores = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelVarios.setBackground(Color.LIGHT_GRAY.darker());
        panelColores.setLayout(new GridLayout(6, 1));
        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JButton
        JPanel panelFiguras = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelFiguras.setBackground(Color.LIGHT_GRAY.darker());
        panelFiguras.setLayout(new GridLayout(5, 1));

        //DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu = new JMenuBar();

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JMENUS DE LA BARRA DE MENU
        JMenu generalMenu = new JMenu("GENERAL");
        JMenu figurasMenu = new JMenu("FIGURAS");
        JMenu coloresMenu = new JMenu("COLOR FONDO");
        JMenu coloreadoMenu = new JMenu("COLOREADO");
        //DECLARACIÓN OPCIONES JMenuItem y JRadioButtonMenuItem
        //generalMenu
        JMenuItem colorTrazadoMenu = new JMenuItem("COLOR TRAZADO");
        JMenuItem borrarMenu = new JMenuItem("BORRAR");

        //Asignacion evento al cambio de color de trazado
        colorTrazadoMenu.addActionListener(gestorEventoElegirColor);
        borrarMenu.addActionListener(gestorEventosFiguras);

        //figurasMenu
        JMenuItem rectanguloMenu = new JMenuItem("RECTANGULO");
        JMenuItem elipseMenu = new JMenuItem("ELIPSE");
        JMenuItem polilineaMenu = new JMenuItem("POLILINEA");
        JMenuItem poligonoMenu = new JMenuItem("POLIGONO");
        JMenuItem textoMenu = new JMenuItem("TEXTO");
        //coloresMenu
        JMenuItem rojoMenu = new JMenuItem("ROJO");
        JMenuItem verdeMenu = new JMenuItem("VERDE");
        JMenuItem azulMenu = new JMenuItem("AZUL");
        JMenuItem cyanMenu = new JMenuItem("CYAN");
        JMenuItem magentaMenu = new JMenuItem("MAGENTA");
        JMenuItem amarilloMenu = new JMenuItem("AMARILLO");

        //Asignación de eventos a los JMenu colores
        rojoMenu.addActionListener(gestorEventosColores);
        verdeMenu.addActionListener(gestorEventosColores);
        azulMenu.addActionListener(gestorEventosColores);
        cyanMenu.addActionListener(gestorEventosColores);
        magentaMenu.addActionListener(gestorEventosColores);
        amarilloMenu.addActionListener(gestorEventosColores);

        //Asignación de eventos a los JMenu figuras
        rectanguloMenu.addActionListener(gestorEventosFiguras);
        elipseMenu.addActionListener(gestorEventosFiguras);
        polilineaMenu.addActionListener(gestorEventosFiguras);
        poligonoMenu.addActionListener(gestorEventosFiguras);
        textoMenu.addActionListener(gestorEventosFiguras);

        //coloreadoMenu
        JRadioButtonMenuItem colorearMenuBoton = new JRadioButtonMenuItem("COLOREADO", false);
        JRadioButtonMenuItem sinColorearMenuBoton = new JRadioButtonMenuItem("SIN COLOREAR", true);
        //Asignacion eventos
        colorearMenuBoton.addActionListener(gestorEventosColorear);
        sinColorearMenuBoton.addActionListener(gestorEventosColorear);

        //AGRUPACIÓN DE LOS BOTONES JRadioButtonMenuItem colorearMenu y sinColorearMenu en el
        //grupo ButtonGroup grupoJRadioButtonMenu
        ButtonGroup grupoJRadioButtonMenu = new ButtonGroup();
        grupoJRadioButtonMenu.add(colorearMenuBoton);
        grupoJRadioButtonMenu.add(sinColorearMenuBoton);

        //Adición componentes JMenuItem con su correspondiente JMenu
        //PRIMERO
        generalMenu.add(colorTrazadoMenu);
        generalMenu.add(borrarMenu);
        //SEGUNDO
        figurasMenu.add(rectanguloMenu);
        figurasMenu.add(elipseMenu);
        figurasMenu.add(polilineaMenu);
        figurasMenu.add(poligonoMenu);
        figurasMenu.add(textoMenu);
        //TERCERO
        coloresMenu.add(rojoMenu);
        coloresMenu.add(verdeMenu);
        coloresMenu.add(azulMenu);
        coloresMenu.add(cyanMenu);
        coloresMenu.add(magentaMenu);
        coloresMenu.add(amarilloMenu);
        //CUARTO
        coloreadoMenu.add(colorearMenuBoton);
        coloreadoMenu.add(sinColorearMenuBoton);

        //Introducción de la componentes JMenu en el JMenuBar
        barraMenu.add(generalMenu);
        barraMenu.add(figurasMenu);
        barraMenu.add(coloresMenu);
        barraMenu.add(coloreadoMenu);

        //Introducción de la componente menuBar en el contenedor
        panelMenu.add(barraMenu);

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JButton 
        JButton rojo = new JButton("ROJO");
        JButton verde = new JButton("VERDE");
        JButton azul = new JButton("AZUL");
        JButton cyan = new JButton("CYAN");
        JButton magenta = new JButton("MAGENTA");
        JButton amarillo = new JButton("AMARILLO");
        //Asignación color a cada boton
        rojo.setBackground(Color.RED);
        verde.setBackground(Color.GREEN);
        azul.setBackground(Color.BLUE);
        cyan.setBackground(Color.CYAN);
        magenta.setBackground(Color.MAGENTA);
        amarillo.setBackground(Color.YELLOW);
        //Asignación color de letra a cada boton
        rojo.setForeground(Color.BLACK);
        verde.setForeground(Color.BLACK);
        azul.setForeground(Color.BLACK);
        cyan.setForeground(Color.BLACK);
        magenta.setForeground(Color.BLACK);
        amarillo.setForeground(Color.BLACK);
        //Asignación de eventos a los JButton
        rojo.addActionListener(gestorEventosColores);
        verde.addActionListener(gestorEventosColores);
        azul.addActionListener(gestorEventosColores);
        cyan.addActionListener(gestorEventosColores);
        magenta.addActionListener(gestorEventosColores);
        amarillo.addActionListener(gestorEventosColores);
        //inclusión de los componentes JButton en el contenedor JPanel
        //panelColores
        panelColores.add(rojo);
        panelColores.add(verde);
        panelColores.add(azul);
        panelColores.add(cyan);
        panelColores.add(magenta);
        panelColores.add(amarillo);

        JButton rectangulo = new JButton("RECTANGULO");
        JButton elipse = new JButton("ELIPSE");
        JButton polilinea = new JButton("POLILINEA");
        JButton poligono = new JButton("POLIGONO");
        JButton texto = new JButton("TEXTO");

        //Asignación de eventos a los JButton figuras
        rectangulo.addActionListener(gestorEventosFiguras);
        elipse.addActionListener(gestorEventosFiguras);
        polilinea.addActionListener(gestorEventosFiguras);
        poligono.addActionListener(gestorEventosFiguras);
        texto.addActionListener(gestorEventosFiguras);

        //Asignación color a cada boton
        rectangulo.setBackground(Color.BLACK);
        elipse.setBackground(Color.BLACK);
        polilinea.setBackground(Color.BLACK);
        poligono.setBackground(Color.BLACK);
        texto.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        rectangulo.setForeground(Color.WHITE);
        elipse.setForeground(Color.WHITE);
        polilinea.setForeground(Color.WHITE);
        poligono.setForeground(Color.WHITE);
        texto.setForeground(Color.WHITE);

        //inclusión de los componentes JButton en el contenedor JPanel
        //panelColores
        panelFiguras.add(rectangulo);
        panelFiguras.add(elipse);
        panelFiguras.add(polilinea);
        panelFiguras.add(poligono);
        panelFiguras.add(texto);

        JButton colorTrazado = new JButton("COLOR TRAZADO");
        JButton borrar = new JButton("BORRAR");
        JButton salir = new JButton("SALIR");
        //Asignación evento salir del programa al boton salir
        salir.addActionListener(gestorEventoSalir);
        //Asignacion evento al cambio de color de trazado
        colorTrazado.addActionListener(gestorEventoElegirColor);
        //Asignación evento al JButton borrar
        borrar.addActionListener(gestorEventosFiguras);

        //Asignación color a cada boton
        colorTrazado.setBackground(Color.BLACK);
        borrar.setBackground(Color.BLACK);
        salir.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        colorTrazado.setForeground(Color.WHITE);
        borrar.setForeground(Color.WHITE);
        salir.setForeground(Color.WHITE);

        JRadioButton colorear = new JRadioButton("COLOREADO", false);
        JRadioButton sinColorear = new JRadioButton("SIN COLOREAR", true);
        //Asignacion eventos
        colorear.addActionListener(gestorEventosColorear);
        sinColorear.addActionListener(gestorEventosColorear);
        //AGRUPACIÓN DE LOS BOTONES JRadioButtonMenuItem colorearMenu y sinColorearMenu en el
        //grupo ButtonGroup grupoJRadioButtonMenu
        ButtonGroup grupoJRadioButton = new ButtonGroup();
        grupoJRadioButton.add(colorear);
        grupoJRadioButton.add(sinColorear);
        //Asignación color a cada boton
        colorear.setBackground(Color.BLACK);
        sinColorear.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        colorear.setForeground(Color.WHITE);
        sinColorear.setForeground(Color.WHITE);

        //Adicion componentes JButton a panelColoreado
        panelColoreado.add(colorear, BorderLayout.NORTH);
        panelColoreado.add(sinColorear, BorderLayout.SOUTH);

        //Adicion componentes JButton a panelVarios
        panelVarios.add(colorTrazado);
        panelVarios.add(borrar);
        panelVarios.add(panelColoreado);
        panelVarios.add(salir);

        //DECLARACIÓN COMPONENTE AreaDibujo dibujo
        dibujo = new panelDibujo();

        //DECLARACIÓN Y CONFIGURACIÓN JSplitPane
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorEste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //Adición del contenedor JPanel panelMenu al separador separadorNorte
        separadorNorte.add(panelMenu);
        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorNorte.add(new JLabel(""));

        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorSur.add(new JLabel(""));
        //INCLUSIÓN DEL CONTENEDOR JPanel panelVarios EN EL SEPARADOR separadorSur  
        separadorSur.add(panelVarios);

        //INCLUSIÓN DEL CONTENEDOR JPanel panelAcciones EN EL SEPARADOR separadorOeste 
        separadorOeste.add(panelColores);
        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorOeste.add(new JLabel(""));

        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorEste.add(new JLabel(""));
        //INCLUSIÓN DEL CONTENEDOR JPanel panelAcciones EN EL SEPARADOR separadorOeste 
        separadorEste.add(panelFiguras);

        //ADICION DE LA COMPONENTES JPanels al panel de contenidos del contenedor
        //ventana
        panelContenidos.add(separadorNorte, BorderLayout.NORTH);
        panelContenidos.add(separadorSur, BorderLayout.SOUTH);
        panelContenidos.add(separadorOeste, BorderLayout.WEST);
        panelContenidos.add(separadorEste, BorderLayout.EAST);
        panelContenidos.add(dibujo, BorderLayout.CENTER);

    }

    private class panelDibujo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //asignar el color del fondo dependiendo del color que se le asigne
            g2.setColor(colorFondo);
            //declaración rectángulo con las dimensiones del panel
            Rectangle2D rectangulo = new Rectangle2D.Float(0, 0, getWidth(), getHeight());
            //pintar el rectángulo relleno
            g2.fill(rectangulo);
            Rectangle2D rectangulo2 = new Rectangle2D.Float(30, 15, getWidth() - 60, getHeight() - 40);
            double CenX = rectangulo.getCenterX(); // Almacenamos el centro del rectg(Eje x)
            double CenY = rectangulo.getCenterY(); // Almacenamos el centro del rectg(Eje Y)
            int x = (int) CenX;
            int y = (int) CenY;
            switch (figura) {
                case 0:
                    g2.fill(rectangulo);
                    break;
                case 1:
                    g2.setColor(colorTrazadoFiguras);
                    g2.draw(rectangulo2);
                    if (coloreado) {
                        g2.fill(rectangulo2);
                    }
                    break;
                case 2:
                    Ellipse2D elipse = new Ellipse2D.Double();
                    g2.setColor(colorTrazadoFiguras);
                    // Frame imaginario donde irá la elipse
                    elipse.setFrame(rectangulo2);
                    g2.draw(elipse);
                    if (coloreado) {
                        g2.fill(elipse);
                    }
                    break;
                case 3:
                    //Dibujar una linea (dos primeros localización, otros diametros)
                    g2.setColor(colorTrazadoFiguras);
                    g2.drawLine(getWidth() - 15, getHeight() - 15, 100, 100);
                    g2.drawLine(getWidth() - 30, getHeight() - 100, 100, 100);
                    break;
                case 4:
                    g2.setColor(colorTrazadoFiguras);
                    int[] x1 = {100, 150, 170, 190, 200};
                    int[] y1 = {120, 280, 200, 250, 60};
                    g2.drawPolyline(x1, y1, x1.length);
                    break;
                case 5:
                    g2.setColor(colorTrazadoFiguras);
                    g2.drawString("Hola ¿Que tal? ", x - 50, y - 30);
                    break;
            }
        }
    }
}
