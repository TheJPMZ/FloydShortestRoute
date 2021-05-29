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

public class main{


    public static void main(String[] args){

        int vertices = 6;

        grafo g = new grafo(4);

        g.addEdge(0, 3,10);
        g.addEdge(0, 1,80);
        g.addEdge(1, 2,10);
        g.addEdge(2, 0,40);
        g.addEdge(3, 1,20);
        g.addEdge(3, 2,90);

        System.out.print(g.toString());

        g.floyd();

        g.printboth();

        g.rutacorta(0,2);
        /*
        int menumaster = menu.displaymenu();

        switch (menumaster) {
            case 1:
                //Ruta mas corta
            case 2:
                //Centro
            case 3:
                //Modificar
            case 4:
                System.exit(0);
        }*/
    }
}