import java.util.Scanner;

public class menu {

    public static int displaymenu(){

        int option = 0;

        System.out.println("Que desea hacer: \n" +
                "[1] Obtener ruta mas corta entre dos ciudades \n" +
                "[2] Centro del Grafo\n[3] Modificar el Grafo\n" +
                "[4] Finalizar Programa");

        while(option > 4 || option < 1){ //Menu
            try{
                System.out.println("Ingrese un numero entre 1 y 4");
                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();
            } catch (Exception e) { }
        }

        return option;
    }






}
