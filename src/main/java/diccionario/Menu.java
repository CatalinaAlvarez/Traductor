package diccionario;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    ManejadorArchivo datos = new ManejadorArchivo();
    Boolean continuar = true;

    //Se muestra el menú
    public void mostrarMenu(){
        System.out.println("Bienvenido al Diccionario español/inglés");
        System.out.println("-----------------------------------------");
        System.out.println("Por favor selecciona una opción");
        System.out.println("\n1. Agregar una palabra al diccionario");
        System.out.println("2. Imprimir todo el diccionario");
        System.out.println("3. Traducir una palabra");
        System.out.println("4. Salir");
        System.out.println("\nPor favor ingrese el número de la opción");
    }

    /*Este método permite seleccionar una opción del menú
    * Al recibir la opción, se despliega el método relacionado
    * en ManejadorArchivo.java */
    public void seleccionarOpcion(){
        mostrarMenu();
        String opcion = input.nextLine();
        Boolean continuar = true;
        while(continuar) {
            switch (opcion) {
                case "1": {
                    System.out.println("Dame la palabra en español: ");
                    String palabraEspanol = input.nextLine();
                    System.out.println("Dame la palabra en inglés: ");
                    String palabraIngles = input.nextLine();
                    Diccionario palabra = new Diccionario(palabraEspanol, palabraIngles);
                    datos.agregarDatos(palabra);
                    continuar = mostrarMenuContinuar();
                    break;
                }
                case "2": {
                    datos.imprimirDiccionario();
                    continuar = mostrarMenuContinuar();
                    break;
                }
                case "3": {
                    System.out.println("Dame la palabra que quieres traducir: ");
                    String palabra = input.nextLine();
                    datos.buscarPalabraEspanol(palabra);
                    continuar = mostrarMenuContinuar();
                    break;
                }
                case "4": {
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;
                }
                default: {
                    System.out.println("Esta opción no es valida. ");

                }
            }
        }
    }

    /*Este método muestra el menú auxiliar que permite continuar
    * o salir del programa. Retorna un booleano para saber
    * si se continúa o no. */
    public Boolean mostrarMenuContinuar(){
        System.out.println("____________________________________");
        System.out.println("\nPor favor seleccione una opción: ");
        System.out.println("\n1. Volver al menú anterior");
        System.out.println("2. Salir");
        System.out.println("Ingrese el número de la opción: ");
        String opcion = input.nextLine();
        switch (opcion) {
            case "1": {
                seleccionarOpcion();
            }
            case "2": {
                System.out.println("Hasta luego");
                continuar = false;
                break;
            }
            default: {
                System.out.println("Esta opción no es valida");
            }
        }
        return continuar;
    }
}
