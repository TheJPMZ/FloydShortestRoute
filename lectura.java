import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class lectura {
    /**
     * Lee el archivo guategrafo y lo regresa en una Arraylist
     * @return Arraylist con lineas del archivo
     */
    public static ArrayList<String> leerarchivo() {

        Scanner scanner = new Scanner(System.in);

        String linea = "";
        String ruta = "";
        ArrayList<String> Lista = new ArrayList<String>();

        boolean loop = true;
        while (loop){
            System.out.println("Ingrese el pathname del documento");
            ruta = scanner.nextLine();
            File file = new File(ruta);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                while ((linea = br.readLine())!= null) { Lista.add(linea.toLowerCase(Locale.ROOT)); }
                loop = false;

            } catch (Exception e) { System.out.println("Ha ocurrido un error al leer el archivo, intente otra vez"); }
        }
        return Lista;
    }

    /**
     * Genera un grafo en base de una arraylist
     * @param lista arraylist con los valores del grafo
     * @return El grafo
     */
    public static grafo generargrafo(ArrayList<String> lista){

        ArrayList<String> nombres = new ArrayList<String>();

        for (String LineaString:lista) {

            LineaString.toUpperCase();
            String[] linea = LineaString.split(" ");

            for (int x = 0; x < 2; x++) {
                if (!nombres.contains(linea[x])){
                    nombres.add(linea[x]);
                }
            }
        }

        grafo g = new grafo(nombres.size());
        g.settitles(nombres);

        for (String LineaString:lista) {

            LineaString.toUpperCase();
            String[] linea = LineaString.split(" ");

            int recorrido = Integer.parseInt(linea[2]);

            g.addEdge(nombres.indexOf(linea[0]), nombres.indexOf(linea[1]),recorrido);

        }

        return g;
    }
}

