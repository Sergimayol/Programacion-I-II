/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

/**
 *
 * @author Sergi
 */
public class Taller2 extends JFrame {

    //DECLARACIÓN OBJETO Container PARA REPRESENTAR EL PANEL DE
    //CONTENIDOS DEL OBJETO JFrame
    private Container panelContenidos;
    //DECLARACIÓN DE ATRIBUTO COLOR PARA GESTIONAR EL COLOR DE FONDO
    private Color colorFondo;
    //DECLARACIÓN JComponent
    private panelDibujo dibujo;
    //DECLARACIÓN DE ATRIBUTO COLOR PARA GESTIONAR EL COLOR DE TRAZADO
    private Color colorTrazado;
    //DECLARACIÓN ATRIBUTO ObjetoGrafico PARA PODER DIBUJAR LAS FIGURAS
    private ObjetoGrafico[] objetos;
    //DECLARACIÓN ATRIBUTO final int PARA ESTABLECER UN MÁXIMO DE OBJETOS
    private final int MAX_OBJETOS = 20;
    //DECLARACIÓN ATRIBUTO int PARA DETERMINAR CUANTOS OBJETOS HAY DIBUJADOS
    private int numObjetosPantalla;
    //DECLARACIÓN ATRIBUTO BasicStroke PARA LA GESTIÓN DEL STROKE EN LOS DIBUJOS
    private BasicStroke atributoStroke;
    //DECLARACIÓN ATRIBUTO Paint PARA LA GESTIÓN DEL PINTADO DE LOS OBJETOS
    private Paint atributoPaint;
    //DECLARACIÓN ATRIBUTO boolean PARA LA GESTIÓN DE LA VISUALIZACIÓN DEL DIBUJO
    private boolean rellenoFigura;
    //DECLARACIÓN ATRIBUTO COMPONENTE JComponent indicadorColorTrazado
    private panelDibujoOpciones indicadorColorTrazado;
    //DECLARACIÓN ATRIBUTO COMPONENTE JComponent indicadorPaint
    private panelDibujoOpciones indicadorPaint;
    //DECLARACIÓN ATRIBUTO COMPONENTE JComponent indicadorStroke
    private panelDibujoOpciones indicadorStroke;

    //DECLARACIÓN ATRIBUTO TIPO ENUM PARA REPRESENTAR LOS DIFERENTES OBJETOS 
    enum ComponentesDibujoOpciones {
        stroke, trazado, paint
    }

    public static void main(String[] args) {
        new Taller2().inicio();
    }

    //CONSTRUCTOR
    public Taller2() {
        //INICIALIZACIÓN DE ATRIBUTOS
        colorFondo = Color.BLACK;
        colorTrazado = Color.YELLOW;
        atributoPaint = Color.RED;
        rellenoFigura = false;
        numObjetosPantalla = 0;
        atributoStroke = new BasicStroke(1.0f);
        objetos = new ObjetoGrafico[MAX_OBJETOS];
    }

    //Método de inicio del programa, contiene la configuración del JFrame
    //y el método principal
    private void inicio() {
        //Añadimos un titulo a la ventana
        setTitle("PROGRAMACIÓN II - TALLER EVALUABLE 2");
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

    //Método principal del programa, el cual contiene la configuración 
    //de las opciones que el usuario puede realizar
    private void metodoPrincipal() {
        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de botones 
        JPanel panelVarios = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelVarios.setBackground(Color.LIGHT_GRAY.darker());
        panelVarios.setLayout(new GridLayout(1, 3));

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JRadioButton
        JPanel panelVisualizacion = new JPanel();
        //asignación color de fondo al contenedor JPanel panelColoreado
        panelVisualizacion.setBackground(Color.BLACK);
        panelVisualizacion.setLayout(new GridLayout(2, 1));

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JButton
        JPanel panelCreacion = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelCreacion.setBackground(Color.LIGHT_GRAY.darker());
        panelCreacion.setLayout(new GridLayout(6, 1));

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de JButton
        JPanel panelContexto = new JPanel();
        //asignación color de fondo al contenedor JPanel panelAcciones
        panelContexto.setBackground(Color.LIGHT_GRAY.darker());
        panelContexto.setLayout(new GridLayout(4, 1));

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de Stroke
        JPanel contenedorStroke = new JPanel();
        contenedorStroke.setLayout(new BorderLayout());

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de Paint
        JPanel contenedorPaint = new JPanel();
        contenedorPaint.setLayout(new BorderLayout());

        //DECLARACIÓN y CONFIGURACIÓN CONTENEDOR JPanel contenedor de Color trazado
        JPanel contenedorColorTrazado = new JPanel();
        contenedorColorTrazado.setLayout(new BorderLayout());

        //DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu = new JMenuBar();

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JMENUS DE LA BARRA DE MENU
        JMenu generalMenu = new JMenu("GENERAL");

        //DECLARACIÓN JMenuitem asociados a generalMenu
        JMenuItem abrirMenu = new JMenuItem("ABRIR");
        JMenuItem guardarMenu = new JMenuItem("GUARDAR COMO");
        JMenuItem salirMenu = new JMenuItem("SALIR");

        //Asociación JMenuItem's con el gestor de eventos
        abrirMenu.addActionListener(new gestorEventosOpciones());
        guardarMenu.addActionListener(new gestorEventosOpciones());
        salirMenu.addActionListener(new gestorEventosOpciones());

        //Adición componentes JMenuItem con su correspondiente JMenu
        generalMenu.add(abrirMenu);
        generalMenu.add(guardarMenu);
        generalMenu.add(salirMenu);

        //Introducción de la componentes JMenu en el JMenuBar
        barraMenu.add(generalMenu);

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JButton
        JButton strokeBoton = new JButton("STROKE");
        JButton paintBoton = new JButton("PAINT");
        JButton colorTrazadoBoton = new JButton("COLOR TRAZADO");
        JButton colorFondoBoton = new JButton("COLOR FONDO");

        //Asignación colores fondo a cada boton
        strokeBoton.setBackground(Color.BLACK);
        paintBoton.setBackground(Color.BLACK);
        colorTrazadoBoton.setBackground(Color.BLACK);
        colorFondoBoton.setBackground(Color.BLACK);
        //Asignación colores letra a JButton
        strokeBoton.setForeground(Color.WHITE);
        paintBoton.setForeground(Color.WHITE);
        colorTrazadoBoton.setForeground(Color.WHITE);
        colorFondoBoton.setForeground(Color.WHITE);
        //Asignación de eventos a los JButton
        strokeBoton.addActionListener(new gestorEventosFiguras());
        paintBoton.addActionListener(new gestorEventosFiguras());
        colorTrazadoBoton.addActionListener(new gestorEventosFiguras());
        colorFondoBoton.addActionListener(new gestorEventosFiguras());

        //Adición de los JButton y panelDibujoOpciones en el contenedorStroke
        contenedorStroke.add(strokeBoton, BorderLayout.NORTH);
        indicadorStroke = new panelDibujoOpciones();
        indicadorStroke.setComponente(ComponentesDibujoOpciones.stroke);
        contenedorStroke.add(indicadorStroke, BorderLayout.CENTER);

        //Adición de los JButton y panelDibujoOpciones en el contenedorPaint
        contenedorPaint.add(paintBoton, BorderLayout.NORTH);
        indicadorPaint = new panelDibujoOpciones();
        indicadorPaint.setComponente(ComponentesDibujoOpciones.paint);
        contenedorPaint.add(indicadorPaint, BorderLayout.CENTER);

        //Adición de los JButton y panelDibujoOpciones en el contenedorColorTrazado
        contenedorColorTrazado.add(colorTrazadoBoton, BorderLayout.NORTH);
        indicadorColorTrazado = new panelDibujoOpciones();
        indicadorColorTrazado.setComponente(ComponentesDibujoOpciones.trazado);
        contenedorColorTrazado.add(indicadorColorTrazado, BorderLayout.CENTER);

        //Adicion de cada contenedor a JPanel panelContexto
        panelContexto.add(contenedorStroke);
        panelContexto.add(contenedorPaint);
        panelContexto.add(contenedorColorTrazado);
        panelContexto.add(colorFondoBoton);

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JButton 
        JButton lineaBoton = new JButton("LINEA");
        JButton rectanguloBoton = new JButton("RECTANGULO");
        JButton elipseBoton = new JButton("ELIPSE");
        JButton poligonoBoton = new JButton("POLIGONO");
        JButton textoBoton = new JButton("TEXTO");
        JButton imagenBoton = new JButton("IMAGEN");

        //Asignación color a cada boton
        lineaBoton.setBackground(Color.BLACK);
        rectanguloBoton.setBackground(Color.BLACK);
        elipseBoton.setBackground(Color.BLACK);
        poligonoBoton.setBackground(Color.BLACK);
        textoBoton.setBackground(Color.BLACK);
        imagenBoton.setBackground(Color.BLACK);

        //Asignación color de letra a cada boton
        lineaBoton.setForeground(Color.WHITE);
        rectanguloBoton.setForeground(Color.WHITE);
        elipseBoton.setForeground(Color.WHITE);
        poligonoBoton.setForeground(Color.WHITE);
        textoBoton.setForeground(Color.WHITE);
        imagenBoton.setForeground(Color.WHITE);

        //Asignación de eventos a los JButton
        lineaBoton.addActionListener(new gestorEventosFiguras());
        rectanguloBoton.addActionListener(new gestorEventosFiguras());
        elipseBoton.addActionListener(new gestorEventosFiguras());
        poligonoBoton.addActionListener(new gestorEventosFiguras());
        textoBoton.addActionListener(new gestorEventosFiguras());
        imagenBoton.addActionListener(new gestorEventosFiguras());

        //inclusión de los componentes JButton en el contenedor JPanel panelColores
        panelCreacion.add(lineaBoton);
        panelCreacion.add(rectanguloBoton);
        panelCreacion.add(elipseBoton);
        panelCreacion.add(poligonoBoton);
        panelCreacion.add(textoBoton);
        panelCreacion.add(imagenBoton);

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JButton 
        JButton borrarBoton = new JButton("BORRAR");
        JButton salirBoton = new JButton("SALIR");
        //Asignación evento salir del programa al boton salir
        salirBoton.addActionListener(new gestorEventosOpciones());
        //Asignación evento al JButton borrar
        borrarBoton.addActionListener(new gestorEventosOpciones());

        //Asignación color a cada boton
        borrarBoton.setBackground(Color.BLACK);
        salirBoton.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        borrarBoton.setForeground(Color.WHITE);
        salirBoton.setForeground(Color.WHITE);

        JRadioButton pintadoBoton = new JRadioButton("PINTADO", false);
        JRadioButton trazadoBoton = new JRadioButton("TRAZADO", true);
        //Asignacion eventos
        pintadoBoton.addActionListener(new gestorEventosFiguras());
        trazadoBoton.addActionListener(new gestorEventosFiguras());
        //AGRUPACIÓN DE LOS BOTONES JRadioButtonMenuItem colorearMenu y sinColorearMenu en el
        //grupo ButtonGroup grupoJRadioButtonMenu
        ButtonGroup grupoJRadioButton = new ButtonGroup();
        grupoJRadioButton.add(pintadoBoton);
        grupoJRadioButton.add(trazadoBoton);
        //Asignación color a cada boton
        pintadoBoton.setBackground(Color.BLACK);
        trazadoBoton.setBackground(Color.BLACK);
        //Asignación color de letra a cada boton
        pintadoBoton.setForeground(Color.WHITE);
        trazadoBoton.setForeground(Color.WHITE);

        //Adicion componentes JButton a panelColoreado
        panelVisualizacion.add(pintadoBoton);
        panelVisualizacion.add(trazadoBoton);

        //Adicion componentes JButton a panelVarios
        panelVarios.add(borrarBoton);
        panelVarios.add(panelVisualizacion);
        panelVarios.add(salirBoton);

        //DECLARACIÓN COMPONENTE AreaDibujo dibujo
        dibujo = new panelDibujo();

        //DECLARACIÓN Y CONFIGURACIÓN JSplitPane
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorEste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //Adición del contenedor JPanel panelMenu al separador separadorNorte
        separadorNorte.add(barraMenu);
        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorNorte.add(new JLabel(""));

        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorSur.add(new JLabel(""));
        //INCLUSIÓN DEL CONTENEDOR JPanel panelVarios EN EL SEPARADOR separadorSur  
        separadorSur.add(panelVarios);

        //INCLUSIÓN DEL CONTENEDOR JPanel panelAcciones EN EL SEPARADOR separadorOeste 
        separadorOeste.add(panelCreacion);
        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorOeste.add(new JLabel(""));

        //inclusión en el separador separadorOeste de una JLabel vacia para remarcar
        //separación visual
        separadorEste.add(new JLabel(""));
        //INCLUSIÓN DEL CONTENEDOR JPanel panelAcciones EN EL SEPARADOR separadorOeste 
        separadorEste.add(panelContexto);

        //ADICION DE LA COMPONENTES JPanels al panel de contenidos del contenedor
        //ventana
        panelContenidos.add(separadorNorte, BorderLayout.NORTH);
        panelContenidos.add(separadorSur, BorderLayout.SOUTH);
        panelContenidos.add(separadorOeste, BorderLayout.WEST);
        panelContenidos.add(separadorEste, BorderLayout.EAST);
        panelContenidos.add(dibujo, BorderLayout.CENTER);
    }

    //Método para elegir el tipo de stroke que desea utilizar el usuario
    private void elegirTipoStroke() {
        float stroke = 1.0f;
        String[] opcionesStroke = {"ANCHO TRAZADO 1.0",
            "ANCHO TRAZADO 3.0", "ANCHO TRAZADO 5.0"};
        String[] opcionesPatronTrazado = {"TRAZADO CONTINUO", "TRAZADO DISCONTINUO"};
        try {
            //Ventana para que el usuario pueda elegir una opción
            int anchoTrazado = JOptionPane.showOptionDialog(null,
                    "ELIJA EL ANCHO DEL TRAZADO", "PULSAR BOTÓN",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesStroke, opcionesStroke[1]);
            if (anchoTrazado == 0) {
                stroke = 1.0f;
            } else if (anchoTrazado == 1) {
                stroke = 3.0f;
            } else {
                stroke = 5.0f;
            }
            //Ventana para que el usuario pueda elegir una opción
            int patronTrazado = JOptionPane.showOptionDialog(null,
                    "ELIJA EL PATRÓN DE TRAZADO", "PULSAR BOTÓN",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesPatronTrazado, opcionesPatronTrazado[0]);
            if (patronTrazado == 0) {
                //Trazado continuo
                atributoStroke = new BasicStroke(stroke, BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND, 2.0f);
            } else {
                //Trazado discontinuo
                atributoStroke = new BasicStroke(stroke, BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND, 2.0f, new float[]{15.0f, 8.0f}, 0.0f);
            }
        } catch (HeadlessException error) {
            System.out.println("Error: " + error.toString());
        }
    }

    //Método que permite seleccionar un archivo
    private File seleccionarArchivo() {
        //DECLARACIÓN Y CONFIGURACIÓN JFileChooser
        JFileChooser ventanaSeleccion = new JFileChooser();
        try {
            int x = ventanaSeleccion.showOpenDialog(ventanaSeleccion);
            //Asignamos como directorio user.dir, para que al abrir la ventana
            //de selección de archivo sea en la carpeta del proyecto
            File path = new File(System.getProperty("user.dir"));
            //Añadimos el directorio
            ventanaSeleccion.setCurrentDirectory(path);
            if (x == JFileChooser.APPROVE_OPTION) {
                //Devuelve el fichero
                return ventanaSeleccion.getSelectedFile();
            }
        } catch (HeadlessException error) {
            System.out.println("Error 1: " + error.toString());
            //error.printStackTrace();
        } catch (Exception error) {
            System.out.println("Error 2: " + error.toString());
            //error.printStackTrace();
        }
        //En el caso de que no se seleccione ningun direcctorio devolver null
        return null;
    }

    //Clase que gestiona la parte de visualización central
    public class panelDibujo extends JPanel {

        //Atributo de tipo BufferedImage para la gestión de imagenes
        private BufferedImage imagen;

        //CONSTRUCTOR
        public panelDibujo() {
            //Inicialización de BufferedImage
            imagen = null;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            //asignar el color del fondo dependiendo del color que se le asigne
            g2D.setColor(colorFondo);
            //declaración rectángulo con las dimensiones del panel
            g2D.fillRect(0, 0, this.getWidth(), this.getHeight());
            //Bucle para recorrer los objetos que hay en pantalla
            for (int i = 0; i < numObjetosPantalla; i++) {
                //Obtenemos el tipo de objeto, dependediendo de la posicion
                //que tiene en el array
                switch (objetos[i].getTipo()) {
                    case LINEA:
                        //Asignación de los datos corrspondientes al objeto
                        g2D.setStroke(objetos[i].getStroke());
                        g2D.setColor(objetos[i].getColorTrazado());
                        g2D.draw(objetos[i].getObjeto());
                        break;
                    case RECTANGULO:
                        //Asignación de los datos corrspondientes al objeto
                        g2D.setStroke(objetos[i].getStroke());
                        //En el caso de que el usuario escoja que se pinte 
                        //por dentro la figura rellenará la figura del color
                        //correspondiente
                        if (rellenoFigura) {
                            g2D.setPaint(objetos[i].getPaint());
                            g2D.fill(objetos[i].getObjeto());
                        }
                        g2D.setColor(objetos[i].getColorTrazado());
                        g2D.draw(objetos[i].getObjeto());
                        break;
                    case ELIPSE:
                        //Asignación de los datos corrspondientes al objeto
                        g2D.setStroke(objetos[i].getStroke());
                        //En el caso de que el usuario escoja que se pinte 
                        //por dentro la figura rellenará la figura del color
                        //correspondiente
                        if (rellenoFigura) {
                            g2D.setPaint(objetos[i].getPaint());
                            g2D.fill(objetos[i].getObjeto());
                        }
                        g2D.setColor(objetos[i].getColorTrazado());
                        g2D.draw(objetos[i].getObjeto());
                        break;
                    case POLIGONO:
                        //Asignación de los datos corrspondientes al objeto
                        g2D.setStroke(objetos[i].getStroke());
                        //En el caso de que el usuario escoja que se pinte 
                        //por dentro la figura rellenará la figura del color
                        //correspondiente
                        if (rellenoFigura) {
                            g2D.setPaint(objetos[i].getPaint());
                            g2D.fillPolygon((Polygon) objetos[i].getObjeto());
                        }
                        g2D.setColor(objetos[i].getColorTrazado());
                        g2D.drawPolygon((Polygon) objetos[i].getObjeto());
                        break;
                    case TEXTO:
                        //Asignación de los datos corrspondientes al objeto
                        g2D.setStroke(objetos[i].getStroke());
                        g2D.setColor(objetos[i].getColorTrazado());
                        g2D.drawString(objetos[i].getTexto(), objetos[i].getPosicionTexto()[0],
                                objetos[i].getPosicionTexto()[1]);
                        break;
                    case IMAGEN:
                        try {
                            //Asignación de la imagen mediante el método read 
                            //de la clase ImageIO
                            imagen = ImageIO.read(objetos[i].getFicheroImagen());
                        } catch (IOException error) {
                            System.out.println("Error: " + error.toString());
                            //error.printStackTrace();
                        }
                        //Dibujar la imagen ocupando toda el area de visualizacion
                        g2D.drawImage(imagen.getScaledInstance(this.getWidth(),
                                this.getHeight(), 0), 0, 0, this);
                        break;
                }
            }
        }

        //Método que permite guardar una imagen
        public void guardarImagen(File fichero) {
            try {
                //Creacción BufferedImage del tamaño de lo visualizado, con tipo
                //de imagen TYPE_INT_RGB
                BufferedImage imagen
                        = new BufferedImage(this.getWidth(), this.getHeight(),
                                BufferedImage.TYPE_INT_RGB);
                //Se crea temporalmente un objecto Graphics2D, de la imagen creada
                //para poder guardar en formato de imagen lo que el usuario dibuje,
                //ya que si no se crea no sería posible guardar el contenido.
                Graphics2D temp = imagen.createGraphics();
                //Para evitar errores y no guardar el dibujo anterior es necesario
                //eliminar el contenido que había antés. Esto es necesario en el
                //caso que el usuario deseea guardar más de un dibujo en la 
                //misma ejecución.
                this.print(temp);
                temp.dispose();
                //Guardamos la imagen con formato jpg en el directorio
                //especificado por parámetro
                ImageIO.write(imagen, "jpg", fichero);
            } catch (IOException error) {
                System.out.println("Error: " + error.toString());
            }
        }
    }

    //Clase que gestiona los componentes stroke, trazado y paint
    public class panelDibujoOpciones extends JComponent {

        //Atributo de tipo enum que contiene las componentes
        private ComponentesDibujoOpciones componente;

        //Método que permite dibujar las componentes
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(atributoStroke);
            //Dependiendo de la componente que se escoja se actualizará
            switch (componente) {
                case stroke:
                    g2.setColor(Color.WHITE);
                    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g2.setColor(Color.BLACK);
                    g2.drawLine(0, 0, this.getWidth(), this.getHeight());
                    break;
                case trazado:
                    g2.setColor(colorTrazado);
                    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                    break;
                case paint:
                    g2.setPaint(atributoPaint);
                    g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                    break;
            }
        }

        //Método que permite cambiar el valor del atributo componente al valor
        //que se le asigne
        public void setComponente(ComponentesDibujoOpciones componente) {
            this.componente = componente;
        }
    }

    //Clase encargada de la gestión de eventos sobre las opciones que dispone
    //el usuario
    private class gestorEventosOpciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            switch (evento.getActionCommand()) {
                case "GUARDAR COMO":
                    //Selección de la imagen, a través del método seleccionarArchivo
                    File fichero = seleccionarArchivo();
                    //Si se ha seleccionado el archivo correctamente, se procederá
                    //a actualizar la pantalla de visualización
                    if (fichero != null) {
                        dibujo.guardarImagen(fichero);
                    }
                    break;
                case "ABRIR":
                    //Selección de la imagen, a través del método seleccionarArchivo
                    File archivo = seleccionarArchivo();
                    //Si se ha seleccionado el archivo correctamente, se procederá
                    //a actualizar la pantalla de visualización
                    if (archivo != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.IMAGEN,
                                archivo);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "BORRAR":
                    //Asignamos a numObjetosPantalla el valor cero, para indicar
                    //que no hay ningun objto a dibujar en la pantalla
                    numObjetosPantalla = 0;
                    break;
                case "SALIR":
                    //Sale de la aplicación con el cierre de la ventana y la 
                    //finalización de la ejecución
                    System.exit(0);
                    break;
            }
            dibujo.repaint();
        }

    }

    //MANIPULADOR EVENTOS COMPONENTES JButton y JMenuItem
    private class gestorEventosFiguras implements ActionListener {

        //Atributo Color para la gestión
        //de los colores
        private Color color;
        //Atributo JFrame para insertar LOS JDialog de la clase lecturaDatos
        private Taller2 ventana;

        @Override
        public void actionPerformed(ActionEvent evento) {
            //Para cada posible evento se crea un case
            switch (evento.getActionCommand()) {
                case "LINEA":
                    //Array String que contiene las frases que se enseñaran en la ventana
                    //para indicar las coordenadas de la figura que se desea dibujar
                    String[] posLinea = {"COORDENADA X (PUNTO 1)", "COORDENADA Y (PUNTO 1)",
                        "COORDENADA X (PUNTO 2)", "COORDENADA Y (PUNTO 2)"};
                    //Se crea la ventana que se mostrará al ussuario con los 
                    //datos correspondientes
                    posLinea = new lecturaDatos(ventana, posLinea).getDatosTexto();
                    //Si en la venatana se han introducido de forma correcta los datos
                    //se procedera a dibujar la figura
                    if (posLinea != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.LINEA, posLinea);
                        objetos[numObjetosPantalla].setColorTrazado(colorTrazado);
                        objetos[numObjetosPantalla].setStroke(atributoStroke);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "RECTANGULO":
                    //Array String que contiene las frases que se enseñaran en la ventana
                    //para indicar las coordenadas de la figura que se desea dibujar
                    String[] posRect = {"COORDENADA X", "COORDENADA Y", "DIMENSION X", "DIMENSION Y"};
                    //Se crea la ventana que se mostrará al ussuario con los 
                    //datos correspondientes
                    posRect = new lecturaDatos(ventana, posRect).getDatosTexto();
                    //Si en la venatana se han introducido de forma correcta los datos
                    //se procedera a dibujar la figura
                    if (posRect != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.RECTANGULO, posRect);
                        objetos[numObjetosPantalla].setColorTrazado(colorTrazado);
                        objetos[numObjetosPantalla].setPaint(atributoPaint);
                        objetos[numObjetosPantalla].setStroke(atributoStroke);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "ELIPSE":
                    //Array String que contiene las frases que se enseñaran en la ventana
                    //para indicar las coordenadas de la figura que se desea dibujar
                    String[] posElipse = {"COORDENADA X", "COORDENADA Y", "DIMENSION X", "DIMENSION Y"};
                    //Se crea la ventana que se mostrará al ussuario con los 
                    //datos correspondientes
                    posElipse = new lecturaDatos(ventana, posElipse).getDatosTexto();
                    //Si en la venatana se han introducido de forma correcta los datos
                    //se procedera a dibujar la figura
                    if (posElipse != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.ELIPSE, posElipse);
                        objetos[numObjetosPantalla].setColorTrazado(colorTrazado);
                        objetos[numObjetosPantalla].setPaint(atributoPaint);
                        objetos[numObjetosPantalla].setStroke(atributoStroke);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "POLIGONO":
                    //Array String que contiene las frases que se enseñaran en la ventana
                    //para indicar las coordenadas de la figura que se desea dibujar
                    String[] posPoligono = new String[Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DE PUNTOS DEL POLÍGONO")) * 2];
                    for (int i = 0, j = 0; i < posPoligono.length; i += 2, ++j) {
                        posPoligono[i] = "COORDENADA X (PUNTO " + (j + 1) + ")";
                        posPoligono[i + 1] = "COORDENADA Y (PUNTO " + (j + 1) + ")";
                    }
                    //Se crea la ventana que se mostrará al ussuario con los 
                    //datos correspondientes
                    posPoligono = new lecturaDatos(ventana, posPoligono).getDatosTexto();
                    //Si en la venatana se han introducido de forma correcta los datos
                    //se procedera a dibujar la figura
                    if (posPoligono != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.POLIGONO, posPoligono);
                        objetos[numObjetosPantalla].setColorTrazado(colorTrazado);
                        objetos[numObjetosPantalla].setPaint(atributoPaint);
                        objetos[numObjetosPantalla].setStroke(atributoStroke);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "TEXTO":
                    //Array String que contiene las frases que se enseñaran en la ventana
                    //para indicar las coordenadas de la figura que se desea dibujar
                    String[] posTexto = {"TEXTO", "COORDENADA X ", "COORDENADA Y "};
                    //Se crea la ventana que se mostrará al ussuario con los 
                    //datos correspondientes
                    posTexto = new lecturaDatos(ventana, posTexto).getDatosTexto();
                    //Si en la venatana se han introducido de forma correcta los datos
                    //se procedera a dibujar la figura
                    if (posTexto != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.TEXTO, posTexto);
                        objetos[numObjetosPantalla].setColorTrazado(colorTrazado);
                        objetos[numObjetosPantalla].setPaint(atributoPaint);
                        objetos[numObjetosPantalla].setStroke(atributoStroke);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                    }
                    break;
                case "IMAGEN":
                    //Selección de la imagen, a través del método seleccionarArchivo
                    File imagen = seleccionarArchivo();
                    //Si se ha selccionado la imagen correctamente, se procederá
                    //a dibujarla
                    if (imagen != null) {
                        objetos[numObjetosPantalla] = new ObjetoGrafico(ObjetoGrafico.tipoObjetoGrafico.IMAGEN, imagen);
                        //Incremento del valor numObjetosPantalla en 1, para actualizar
                        //el array, así la próxima vez al dibujar un objeto sea en la
                        //siguiente posición de array
                        numObjetosPantalla = numObjetosPantalla + 1;
                        break;
                    }
                    break;
                case "STROKE":
                    //Se escoje el tipo de stroke con el método elegirTipoStroke()
                    //y se actualiza el panel de indicadorStroke
                    elegirTipoStroke();
                    indicadorStroke.repaint();
                    break;
                case "PAINT":
                    //Se asigna al atributo color uno con JColorChooser
                    color = JColorChooser.showDialog(null,
                            "SELECCIONE COLOR", Color.LIGHT_GRAY);
                    //Si se ha selccionado el color correctamente, se procederá
                    //a actualizar el atributo paint y el panel indicadorPaint
                    if (color != null) {
                        atributoPaint = color;
                        indicadorPaint.repaint();
                    }
                    break;
                case "TRAZADO":
                    rellenoFigura = false;
                    break;
                case "PINTADO":
                    rellenoFigura = true;
                    break;
                case "COLOR TRAZADO":
                    //Se asigna al atributo color uno con JColorChooser
                    color = JColorChooser.showDialog(null,
                            "SELECCIONE COLOR", Color.LIGHT_GRAY);
                    //Si se ha seleccionado el color correctamente, se procederá
                    //a actualizar el atributo colorTrazado y el panel indicadorColorTrazado
                    if (color != null) {
                        colorTrazado = color;
                        indicadorColorTrazado.repaint();
                    }
                    break;
                case "COLOR FONDO":
                    //Se asigna al atributo color uno con JColorChooser
                    color = JColorChooser.showDialog(null,
                            "SELECCIONE COLOR", Color.LIGHT_GRAY);
                    //Si se ha seleccionado el color correctamente, se procederá
                    //a actualizar el atributo colorFondo
                    if (color != null) {
                        colorFondo = color;
                    }
                    break;
            }
            //Actualizar la visualización de los objetos en pantalla
            dibujo.repaint();
        }
    }
}
