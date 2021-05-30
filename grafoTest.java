import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class grafoTest {

    @Test
    public void creargrafo(){
        grafo g = new grafo(50);
        g.printboth();
    }

    @Test
    public void agregarArcos(){
        grafo g = new grafo(3);
        g.addEdge(0, 1,30);
        g.addEdge(0, 2,20);
        g.addEdge(1, 2,10);
        g.addEdge(2, 0,20);
        g.addEdge(2, 2,90);
        g.printboth();
        g.addEdge(2, 0,20);
        g.addEdge(2, 0,40);
        g.addEdge(2, 2,90);
        g.printboth();
    }

    @Test
    public void eliminarArcos(){
        grafo g = new grafo(3);
         g.addEdge(0, 1,30);
         g.addEdge(0, 2,20);
         g.addEdge(1, 2,10);
         g.addEdge(2, 0,20);
         g.addEdge(2, 2,90);
         g.printboth();
         g.removeEdge(1, 2);
         g.removeEdge(2, 0);
         g.removeEdge(2, 2);
         g.printboth();
    }
    @Test
    public void floyd(){
        grafo g = new grafo(3);
        g.addEdge(0, 1,30);
        g.addEdge(0, 2,20);
        g.addEdge(1, 2,10);
        g.addEdge(2, 0,20);
        g.addEdge(2, 2,90);
        g.floyd();
        g.printboth();
        g.removeEdge(1, 2);
        g.removeEdge(2, 0);
        g.removeEdge(2, 2);
        g.printboth();
        g.floyd();
        g.printboth();
        g.floyd();
        g.printboth();
        g.addEdge(2, 0,20);
        g.addEdge(2, 0,40);
        g.addEdge(2, 2,90);
        g.printboth();
        g.floyd();
        g.printboth();
    }

}