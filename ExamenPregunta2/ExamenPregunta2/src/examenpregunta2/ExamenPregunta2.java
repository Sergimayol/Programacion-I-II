/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpregunta2;

/**
 *
 * @author Sergi
 */
public class ExamenPregunta2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ExamenPregunta2().metodoPrincipal();
    }

    private void metodoPrincipal() {
        System.out.println("Contenido fichero de texto:");
        creacionFicheroAleatorio();
        
        System.out.println("\n");
        System.out.println("Contenido fichero de acceso aleatorio:");
        lecturaFicheroAleatorio();
        
        System.out.println("\n");
        ordenacionFichero(1);
        System.out.println("Contenido fichero ordenado por isla y superficie:");
        lecturaFicheroAleatorio();
        
        System.out.println("\n");
        ordenacionFichero(2);
        System.out.println("Contenido fichero ordenado por isla y población:");
        lecturaFicheroAleatorio();
        
        System.out.println("\n");
        ordenacionFichero(3);
        System.out.println("Contenido fichero ordenado por isla y constitución:");
        lecturaFicheroAleatorio();
    }

    public void creacionFicheroAleatorio() {
        String listaMunicipios = "MunicipisBalears.txt";
        String municipiosAleatorio = "creacionFicheroAleatorio.dat";
        FicheroLecturaMunicipio lecturaMunicipios;
        FicheroMunicipiosInOut municipioAleatorio;
        Municipio municipio;
        try {
            lecturaMunicipios = new FicheroLecturaMunicipio(listaMunicipios);
            municipioAleatorio = new FicheroMunicipiosInOut(municipiosAleatorio);
            try {
                municipio = lecturaMunicipios.lectura();
                while (!municipio.esCentinela()) {
                    System.out.println(municipio.toString());
                    municipioAleatorio.escritura(municipio);
                    municipio = lecturaMunicipios.lectura();
                }
                municipioAleatorio.escritura(Municipio.getCentinela());
            } catch (Exception error) {
                System.out.println("ERROR 2(creacionFicheroAleatorio): " + error.toString());
            } finally {
                try {
                    //Cierre enlace ficheros
                    lecturaMunicipios.close();
                    municipioAleatorio.cierre();
                } catch (Exception error) {
                    System.out.println("ERROR 3(creacionFicheroAleatorio): " + error.toString());
                }
            }
        } catch (Exception error) {
            System.out.println("ERROR 1(creacionFicheroAleatorio): " + error.toString());
        }
    }

    private void lecturaFicheroAleatorio() {
        FicheroMunicipiosInOut accesoAleatorio;
        String municipiosAleatorio = "creacionFicheroAleatorio.dat";
        Municipio municipio;
        try {
            accesoAleatorio = new FicheroMunicipiosInOut(municipiosAleatorio);
            try {
                municipio = accesoAleatorio.lectura();
                while (!municipio.esCentinela()) {
                    System.out.println(municipio.toString());
                    municipio = accesoAleatorio.lectura();
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

    private void ordenacionFichero(int i) {
        FicheroMunicipiosInOut accesoAleatorio;
        String municipiosAleatorio = "creacionFicheroAleatorio.dat";
        try {
            accesoAleatorio = new FicheroMunicipiosInOut(municipiosAleatorio);
            accesoAleatorio.ordena(i);
//            System.out.println(accesoAleatorio);
//                for (int indice1 = 0; indice1 < accesoAleatorio.getNumMunicipios() - 1; indice1++) {
//                    int posicion_menor = indice1;
//                    Municipio objetoMunicipioMenor = new Municipio();
//                    objetoMunicipioMenor = accesoAleatorio.lectura(indice1);
//                    Municipio objetoPalabra_indice1 = new Municipio();
//                    Municipio.copiar(objetoMunicipioMenor, objetoPalabra_indice1);
//                    for (int indice2 = indice1 + 1; indice2 < accesoAleatorio.getNumMunicipios(); indice2++) {
//                        Municipio objetoPalabraActual = new Municipio();
//                        objetoPalabraActual = accesoAleatorio.lectura(indice2);
//                        if (objetoPalabraActual.menor(objetoMunicipioMenor, i)) {
//                            posicion_menor = indice2;
//                            Municipio.copiar(objetoPalabraActual, objetoMunicipioMenor);
//                        }
//                    }
//                    accesoAleatorio.escritura(objetoMunicipioMenor, indice1);
//                    accesoAleatorio.escritura(objetoPalabra_indice1, posicion_menor);
//                }
        } catch (Exception error) {
            System.out.println("ERROR 1: " + error.toString());
        }
    }
}
