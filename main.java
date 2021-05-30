import java.lang.reflect.Array;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Hoja de trabajo 10
 * por José Monzón
 *
 * Algunas interfaces implementadas fueron obtenidas del modulo de canvas y enlaces externos
 *
 * @author TheJPMZ
 */

import java.util.ArrayList;
public class main{


    public static void main(String[] args){

        grafo g = lectura.generargrafo(lectura.leerarchivo());

        g.floyd();

        g.printboth();
        do {
            int menumaster = menu.displaymenu();

            switch (menumaster) {
                case 1:
                    ArrayList<String> Lista1 = menu.dosciudadesmenu(g);
                    g.rutacorta(Lista1.get(0),Lista1.get(1));
                    break;
                case 2:
                    String centro = g.getcenter();
                    System.out.println("El centro del grafo es: " +  centro);
                    break;
                case 3:
                    int opcion = menu.modificarmenu();
                    ArrayList<String> Lista = menu.dosciudadesmenu(g);
                    switch (opcion){
                        case 1:
                            g.removeEdge(g.gettitles().indexOf(Lista.get(0)),g.gettitles().indexOf(Lista.get(1)));
                            break;
                        case 2:
                            int recorrido = menu.menurecorrido();
                            g.addEdge(g.gettitles().indexOf(Lista.get(0)),g.gettitles().indexOf(Lista.get(1)),recorrido);
                            break;
                    }
                    g.floyd();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}