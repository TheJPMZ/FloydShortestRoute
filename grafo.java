// Adjacency Matrix representation in Java https://www.programiz.com/dsa/graph-adjacency-matrix

import java.util.ArrayList;

public class grafo {
    private int adjMatrix[][];
    private int intmatrix[][];
    private int numVertices;
    private int inf = 999;
    private ArrayList<String> titles = new ArrayList<String>();

    //TODO funcion de agregar nodos al grafo

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

    // Add edges
    public void addEdge(int i, int j, int road) {

        adjMatrix[i][j] = road;
    }

    // Remove edges
    public void removeEdge(int i, int j) {

        adjMatrix[i][j] = inf;
    }

    public void settitles(ArrayList<String> listanombres){
        for (String punto:listanombres) {
            this.titles.add(punto);
        }
    }

    public boolean containstitles(String nombre){
        return titles.contains(nombre);
    }

    public ArrayList<String> gettitles(){
        return titles;
    }

    // Print the matrix
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

    public void genintmatrix(){
        intmatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++) {
                intmatrix[i][j] = j;
            }
            intmatrix[i][i] = -1;
        }
    }

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

    public void printboth(){

        System.out.println(toString(adjMatrix));

        System.out.println(toString(intmatrix));

    }

    private void recorrido(int inicio,int destino){

        int here = intmatrix[inicio][destino];

        if (here != -1){
            System.out.println(">De "+titles.get(inicio)+" a " + titles.get(here) + " son " + adjMatrix[inicio][here] + "km");
            recorrido(here,destino);
        }   else {
            System.out.println("Ha llegado a su destino");
        }
    }

    public void rutacorta(String pinicio,String pdestino){

        int inicio = titles.indexOf(pinicio);
        int destino = titles.indexOf(pdestino);
        
        if (adjMatrix[inicio][destino] < inf){
            System.out.println("Los pasos a seguir son:");
            recorrido(inicio, destino);
            System.out.println("Recorrido total: "+ adjMatrix[inicio][destino] + "km");
        } else {
            System.out.println("No hay ruta hacia el destino");
        }

    }

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