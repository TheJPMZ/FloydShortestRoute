/**
 * Se utilizo como referencia lo visto en clase, la hoja de encontrar el centro del grafo
 * y Adjacency Matrix representation in Java https://www.programiz.com/dsa/graph-adjacency-matrix
 * Este ultimo principalmente para la creacion del grafo e impresion
 * El resto de operaciones son originales
 *
 * Ejemplo de la estructura de la matriz de adyacencia y auxiliar
 *
 * Matriz de Adyacencia
 * 0: 0 30 40 10
 * 1: 50 0 10 60
 * 2: 40 70 0 50
 * 3: 70 20 30 0
 *
 * Matriz Auxiliar
 * 0: -1 3 3 3
 * 1: 2 -1 2 2
 * 2: 0 3 -1 0
 * 3: 2 1 1 -1
 *
 * @author Jose Pablo Monzon
 */

import java.util.ArrayList;

public class grafo {

    private int adjMatrix[][];
    private int intmatrix[][];
    private int numVertices;
    private int inf = 999;
    private ArrayList<String> titles = new ArrayList<String>();

    //TODO funcion de agregar nodos al grafo

    /**
     * Crea un grafo de un respectivo size, su respectiva matriz de adyacencia y
     * una matriz auxiliar para hacer el algoritmo de floyd
     * @param numVertices El numero de vertices del grafo
     */
    public grafo(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = inf;
            }
            adjMatrix[i][i] = 00;
        }
        genintmatrix();
    }

    /**
     * Agrega un arco entre dos nodos
     * @param i El indice de la ciudad de inicio
     * @param j El indice de la ciudad destino
     * @param road El largo del trayecto
     */
    public void addEdge(int i, int j, int road) {
        adjMatrix[i][j] = road;
    }

    /**
     * Elimina arcos existentes en el grafo
     * Le asigna distancia infinita entre ambos nodos
     * @param i Indice de la ciudad de inicio
     * @param j Indice de la ciudad destino
     */
    public void removeEdge(int i, int j) {

        adjMatrix[i][j] = inf;
    }

    /**
     * Obtiene una lista de nombres como indices
     * Esto ya que el grafo furnciona con enteros como indices
     * @param listanombres La lista con los indices del mismo tama;o que el grafo
     */
    public void settitles(ArrayList<String> listanombres){
        for (String punto:listanombres) {
            this.titles.add(punto);
        }
    }

    /**
     * Verifica si el String dado se encuentra entre los indices del grafo
     * @param nombre Obtiene el nombre a comparar
     * @return Regresa verdadero si lo encuentra, falso si no
     */
    public boolean containstitles(String nombre){
        return titles.contains(nombre);
    }

    /**
     * Obtiene los indices del grafico
     * @return Regresa un arraylist con los indices
     */
    public ArrayList<String> gettitles(){
        return titles;
    }

    /**
     * Genera el formato para imprimir la matriz dada
     * @param matriz Obtiene la matriz
     * @return Un string con formato correcto
     */
    public String toString(int matriz[][]) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : matriz[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Genera la matriz complementaria para algoritmo de floyd
     */
    public void genintmatrix(){
        intmatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++) {
                intmatrix[i][j] = j;
            }
            intmatrix[i][i] = -1;
        }
    }

    /**
     * Lleva a cabo el algoritmo de floyd con el grafo, para ello es necesaria la matriz complementaria
     */
    public void floyd() {

        genintmatrix();

        for (int x = 0; x < numVertices; x++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (x == j || x==i ){
                        continue;
                    }
                    int tempsum = adjMatrix[x][i] + adjMatrix[j][x];
                    //System.out.println("X:"+x+" I:"+i+" J:"+j+" "+tempsum+" Es menor a "+adjMatrix[j][i]+"?");
                    if (tempsum <= adjMatrix[j][i]){
                        //System.out.println("Si");
                        adjMatrix[j][i] = tempsum;
                        intmatrix[j][i] = x;
                    }
                    //System.out.println("No");
                }
            }
        }
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) { 
                if (adjMatrix[i][j] == inf){
                    intmatrix[i][j] = inf;
                }
            }
        }
        
    }

    /**
     * Imprime el grafo y su respectiva matriz complementaria
     */
    public void printboth(){

        System.out.println(toString(adjMatrix));

        System.out.println(toString(intmatrix));

    }

    /**
     * Funcion recursiva para obtener el recorrido mas corto de un punto a otro
     * Si la posicion actual es -1 esto significa que se encuentra en el destino por lo que se detiene la recursion
     * @param inicio Indice del nodo de inicio
     * @param destino Indice del nodo destino
     */
    private void recorrido(int inicio,int destino){

        int here = intmatrix[inicio][destino]; //El lugar a donde tiene que ir

        if (here != -1){ //Si es -1 signific que ya esta en ese lugar
            System.out.println(">De "+titles.get(inicio)+" a " + titles.get(here) + " son " + adjMatrix[inicio][here] + "km");
            recorrido(here,destino);
        }   else {
            System.out.println("Ha llegado a su destino");
        }
    }

    /**
     * Master para obtener la ruta mas corta, verifica que la ruta exista
     */
    public void rutacorta(String pinicio,String pdestino){

        int inicio = titles.indexOf(pinicio);
        int destino = titles.indexOf(pdestino);
        
        if (adjMatrix[inicio][destino] < inf){ //Si la distancia es infinita no hay manera de llegar al destino
            System.out.println("Los pasos a seguir son:");
            recorrido(inicio, destino);
            System.out.println("Recorrido total: "+ adjMatrix[inicio][destino] + "km");
        } else {
            System.out.println("No hay ruta hacia el destino");
        }

    }

    /**
     * Obtiene el centro del grafo, basado en la hoja dada
     * @return Un string con el nombre del centro del grafo
     */
    public String getcenter(){

        ArrayList<Integer> lista = new ArrayList<Integer>();

        int menorglobal = inf;

        for (int x = 0; x < numVertices; x++) {

            int mayorlocal = mayorcolumna(x);
            if (mayorlocal < menorglobal){
                menorglobal = mayorlocal;
            }

            lista.add(mayorlocal);
        }

        int mayor= lista.indexOf(menorglobal);

        return titles.get(mayor);
    }

    /**
     * Es utilizado por getcenter() para obtener el numero mayor en la columa dada
     * @param x El numero de la columna
     * @return El numero mayor en la columa de la matrz
     */
    private int mayorcolumna(int x){
        int mayorlocal = 0;
        for (int i = 0; i < numVertices; i++) {
            int here = adjMatrix[i][x];
            if (here > mayorlocal){
                mayorlocal = here;
            }
        }
        return mayorlocal;
    }
}