import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    /**
     * Muestra el menu principal
     * Contiene programacion defensiva
     * @return La opcion escogida
     */
    public static int displaymenu(){

        int option = 0;

        System.out.println("=======\n\nQue desea hacer: \n" +
                "[1] Obtener ruta mas corta entre dos ciudades \n" +
                "[2] Centro del Grafo\n[3] Modificar el Grafo\n" +
                "[4] Finalizar Programa");

        while(option > 4 || option < 1){ //Menu
            try{
                System.out.printf("Ingrese un numero entre 1 y 4\n>");
                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();
            } catch (Exception e) { }
        }

        return option;
    }

    /**
     * Muestra el menu de modificar
     * Contiene programacion defensiva
     * @return La opcion escogida
     */
    public static int modificarmenu(){
        int option = 0;

        System.out.println("Que desea hacer: \n" +
                "[1] Reportar una ruta cerrada \n" +
                "[2] Agragar una ruta entre las ciudades existentes");

        while(option > 2 || option < 1){ //Menu
            try{
                System.out.println("Ingrese un numero entre 1 y 2");
                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();
            } catch (Exception e) { }
        }
        return option;
    }

    /**
     * Menu para escribir dos cuidades primero el origen y luego el destino
     * Contiene programacion defensiva
     * @param g Obtiene el grafo como parametro
     * @return Una lista con ambas ciudades
     */
    public static ArrayList<String> dosciudadesmenu(grafo g){

        ArrayList<String> lista =  new ArrayList<String>();

        String inicio = "";
        String destino = "";

        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese el nombre del inicio");
            inicio = scan.nextLine();
            if (g.containstitles(inicio)){
                lista.add(inicio);
                break;
            }
            System.out.println("Lo que ha ingresado no es una ciudad valida");
        } while (true);

        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese el nombre del destino");
            destino = scan.nextLine();
            if (g.containstitles(destino)){
                lista.add(destino);
                break;
            }
            System.out.println("Lo que ha ingresado no es una ciudad valida");
        } while (true);
        return lista;
    }

    /**
     * Obtiene una distancia
     * Contiene programacion defensiva
     * @return la distancia
     */
    public static int menurecorrido(){
        int recorrido = 0;

        System.out.println("Ingrese la distancia entre ambos destinos (Numero entero positivo menor a 400)");
        while (true){
            try{
                Scanner scan = new Scanner(System.in);
                recorrido = scan.nextInt();
                if (recorrido > 0 && recorrido < 400) {
                    break;
                } else {
                    System.out.println("Ingrese numeros positivos no iguales a cero y menores que 400");
                }
            } catch (Exception e ) {
                System.out.println("Lo que ha ingresado no es valido");}
        }
        return recorrido;
    }
}
