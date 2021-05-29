import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.PriorityQueue;


public class lectura {
    /**
     * Lee el achivo en la ruta especificada
     * Este codigo esta basado en hojas de trabajo pasadas
     * @return Lista que contiene los datos del archivo
     */
    public static ArrayList<String> leerdiccionario() {

        Scanner scanner = new Scanner(System.in);
        String linea = ""; //Temporal para cada linea del archivo
        String ruta = ""; //Ruta del archivo
        ArrayList<String> Lista = new ArrayList<String>(); //Temporal para incluir el archivo

        boolean loop = true;
        while (loop){
            System.out.println("Ingrese el pathname del diccionario");
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
}

