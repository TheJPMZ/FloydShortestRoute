// Adjacency Matrix representation in Java https://www.programiz.com/dsa/graph-adjacency-matrix

import javax.sound.midi.Soundbank;

public class grafo {
    private int adjMatrix[][];
    private int intmatrix[][];
    private int numVertices;
    private int inf = 99;

    // Initialize the matrix
    public grafo(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = 999;
            }
            adjMatrix[i][i] = 00;
        }
    }

    // Add edges
    public void addEdge(int i, int j, int road) {
        adjMatrix[i][j] = road;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = inf;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void floyd () {
        intmatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++) {
                intmatrix[i][j] = j;
            }
            intmatrix[i][i] = -1;
        }



        for (int x = 0; x < numVertices; x++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (x == j || x==i ){
                        continue;
                    }
                    int tempsum = adjMatrix[x][i] + adjMatrix[j][x];
                    //System.out.println("X:"+x+" I:"+i+" J:"+j+" "+tempsum+" Es menor a "+adjMatrix[j][i]+"?");
                    if (tempsum < adjMatrix[j][i]){
                        //System.out.println("Si");
                        adjMatrix[j][i] = tempsum;
                        intmatrix[j][i] = x;
                    }
                    //System.out.println("No");
                }
            }
        }



    }

    public void printboth(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j :  adjMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        System.out.println(s);

        s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : intmatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        System.out.println(s);
    }

    public void recorrido(int inicio,int destino){
        int here = intmatrix[inicio][destino];
        //System.out.println(intmatrix[inicio][destino]);
        if (here != -1){
            System.out.println("De "+inicio+" a " + here + " son " + adjMatrix[inicio][here]);
            recorrido(here,destino);
        } else {
            System.out.printf("Ha llegado a su destino\n");
        }
    }

    public void rutacorta(int inicio,int destino){
        System.out.println("Los pasos a seguir son:");
        recorrido(inicio, destino);
        System.out.printf("Recorrido total: "+ adjMatrix[inicio][destino]);
    }


}