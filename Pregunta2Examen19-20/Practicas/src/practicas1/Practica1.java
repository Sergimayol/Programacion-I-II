/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas1;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Sergi
 */
public class Practica1 {

    public static void main(String[] args) {
        new Practica1().metodoPrincipal();
    }

    private void metodoPrincipal() {
        boolean fin = false;
        try {
            while (!fin) {
                visualizacionMenu();
                int opcion = LT.readInt();
                switch (opcion) {
                    case 1:
                        InicializacionPablacion();
                        LecturaFicheroIniPoblacion();
                        continuar();
                        break;
                    case 2:
                        InicializacionRegistro();
                        LecturaFicheroAleatorio();
                        continuar();
                        break;
                    case 3:
                        ActualizacionRegistro();
                        LecturaFicheroAleatorio();
                        continuar();
                        break;
                    default:
                        fin = true;
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR metodo Principal: " + error.toString());
        }
    }

    private void continuar() {
        System.out.print("\n\n< CONTINUAR --> RETURN > ");
        try {
            System.in.read();
        } catch (IOException error) {
            System.out.println("ERROR: " + error.toString());
        }
    }

    private void InicializacionPablacion() {
        String listaNombres = "LlistaNoms.txt";
        String ficheroPoblacion = "Poblacion.dat";
        FicheroLecturaPersonas ficheroLectura;
        FicheroObjetosPersonaOut objectoPersona;
        Persona persona = null;
        String nombre = "";
        int x = 0;
        final int maxPersonas = 100;
        try {
            ficheroLectura = new FicheroLecturaPersonas(listaNombres);
            objectoPersona = new FicheroObjetosPersonaOut(ficheroPoblacion);
            try {
                nombre = ficheroLectura.lectura();
                while (nombre != null && x <= maxPersonas) {
                    if (leer()) {
                        persona = new Persona();
                        persona.setnombre(nombre);
                        persona.setestado(setEstadoAleatorio());
                        persona.setcodigo(setCodigoAleatorio());
                        objectoPersona.escritura(persona);
                        x++;
                    }
                    nombre = ficheroLectura.lectura();
                }
                objectoPersona.escritura(Persona.getCentinela());
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    ficheroLectura.close();
                    objectoPersona.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void InicializacionRegistro() {
        String ficheroRegistros = "registro.dat";
        FicheroGrupoInOut accesoAleatorio;
        int x = 0;
        Grupos grupo;
        try {
            accesoAleatorio = new FicheroGrupoInOut(ficheroRegistros);
            try {
                while (x < 20) {
                    grupo = new Grupos();
                    accesoAleatorio.escritura(grupo);
                    x++;
                }
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    accesoAleatorio.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void ActualizacionRegistro() {
        FicheroGrupoInOut accesoAleatorio;
        String ficheroRegistros = "registro.dat";
        String ficheroPoblacion = "Poblacion.dat";
        FicheroObjetosPersonaIn objectoPersona;
        Persona persona;
        Grupos grupo;
        int matriz[][];
        int grupoMatriz = 0;
        int estadoMatriz = 0;
        int x = 0;
        try {
            matriz = new int[20][4];
            accesoAleatorio = new FicheroGrupoInOut(ficheroRegistros);
            objectoPersona = new FicheroObjetosPersonaIn(ficheroPoblacion);
            try {
                persona = objectoPersona.lectura();
                while (!persona.esCentinela()) {
                    //persona = new Persona();
                    //System.out.println(persona.toString());
                    grupoMatriz = persona.getcodigo();
                    estadoMatriz = estadoToInt(persona.getestado());
                    //System.out.println(persona.getestado());
                    //System.out.println(estadoMatriz);
                    x = matriz[grupoMatriz][estadoMatriz];
                    x++;
                    matriz[grupoMatriz][estadoMatriz] = x;
                    persona = objectoPersona.lectura();
                }
                //System.out.println(Arrays.deepToString(matriz));
                for (int i = 0; i < 20; i++) {
                    grupo = new Grupos();
                    for (int j = 0; j < 4; j++) {
                        //System.out.println(Arrays.toString(matriz));
                        switch (j) {
                            case 0:
                                grupo.setSanos(matriz[i][j]);
                                break;
                            case 1:
                                grupo.setInfectados(matriz[i][j]);
                                break;
                            case 2:
                                grupo.setCurados(matriz[i][j]);
                                break;
                            case 3:
                                grupo.setDifuntos(matriz[i][j]);
                                break;
                            default:
                                break;
                        }
                    }
                    accesoAleatorio.escritura(grupo);
                }
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    objectoPersona.cierre();
                    accesoAleatorio.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void LecturaFicheroAleatorio() {
        FicheroGrupoInOut accesoAleatorio;
        String ficheroRegistros = "registro.dat";
        Grupos grupo;
        int x = 0;
        try {
            accesoAleatorio = new FicheroGrupoInOut(ficheroRegistros);
            try {
                grupo = accesoAleatorio.lectura();
                while (grupo != null) {
                    System.out.println("Grupo de riesgo " + x + ": " + grupo);
                    grupo = accesoAleatorio.lectura();
                    x++;
                }
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    accesoAleatorio.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private void LecturaFicheroIniPoblacion() {
        FicheroObjetosPersonaIn lecturaPoblacion;
        String ficheroPoblacion = "Poblacion.dat";
        Persona persona;
        try {
            lecturaPoblacion = new FicheroObjetosPersonaIn(ficheroPoblacion);
            try {
                persona = lecturaPoblacion.lectura();
                while (!persona.esCentinela()) {
                    System.out.println(persona);
                    persona = lecturaPoblacion.lectura();
                }
            } catch (Exception error) {
                System.out.println("ERROR 2: " + error.toString());
            } finally {
                //Cierre enlace ficheros
                try {
                    lecturaPoblacion.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3: " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }

    private String setEstadoAleatorio() {
        String estado = null;
        Random ran = new Random();
        int x = ran.nextInt(4);
        switch (x) {
            case 0:
                estado = "sano";
                break;
            case 1:
                estado = "infectado";
                break;
            case 2:
                estado = "curado";
                break;
            case 3:
                estado = "difunto";
                break;
        }
        return estado;
    }

    private int setCodigoAleatorio() {
        int codigo = 0;
        Random ran = new Random();
        codigo = ran.nextInt(20);
        return codigo;
    }

    private int estadoToInt(String s) {
        int estado = 0;
        switch (s) {
            case "sano":
                estado = 0;
                break;
            case "infectado":
                estado = 1;
                break;
            case "curado":
                estado = 2;
                break;
            case "difunto":
                estado = 3;
                break;
        }
        return estado;
    }

    private boolean leer() {
        boolean leer = false;
        Random ran = new Random();
        int x = ran.nextInt(2);
        switch (x) {
            case 0:
                leer = false;
                break;
            case 1:
                leer = true;
                break;
        }
        return leer;
    }

    private void visualizacionMenu() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "FICHERO DE INFECCIÓN\n\n\n");
        System.out.print("         1. Iniciar fichero población.\n");
        System.out.print("         2. Iniciar fichero registro.\n");
        System.out.print("         3. Actualizar datos de resgitro con las de población.\n");
        System.out.print("         0. Salir.\n\n\n");
        System.out.print("[] opcion: ");
    }
}
