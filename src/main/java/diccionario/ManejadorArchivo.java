package diccionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Locale;

public class ManejadorArchivo {
    Diccionario palabra = new Diccionario();
    private String archivo = "diccionario.txt";


    /*Este método recibe un objeto de tipo Diccionario Y
    agrega los datos al archivo de Texto*/
    public void agregarDatos(Diccionario palabra) {
        try {
            FileWriter myWriter = new FileWriter(archivo, true);
            myWriter.write(palabra.getPalabraEspanol().toLowerCase() + "=" + palabra.getPalabraIngles().toLowerCase() + "\n");
            myWriter.close();
            System.out.println("Se agregó la palabra");
        } catch (IOException e) {
            System.out.println("No se pudo agregar");
            e.printStackTrace();
        }
    }

    /*Este método imprime todos los elementos del diccionario*/
    public void imprimirDiccionario(){
        try {
            FileReader r = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";
            String check = buffer.readLine();
            if(check== null){
                System.out.println("No se encontró nada en el diccionario");
            }else {
                System.out.println("----DICCIONARIO----");
                System.out.println(check);
                while (temp != null) {
                    temp = buffer.readLine();
                    if (temp == null) {
                        break;
                    }
                    System.out.println(temp);
                }
                ;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    /*Este método recibe un String con la palabra en español
    * a traducir, busca si la palabra está, y devuelve su traducción*/
    public void buscarPalabraEspanol(String palabraEspanol){
        palabraEspanol = palabraEspanol.toLowerCase();
        try {
            FileReader r = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";

            while (temp != null) {
                temp = buffer.readLine();
                if (temp == null) {
                    System.out.println("Aun no tenemos esta palabra en el diccionario");
                    break;}
                else{
                    String[] listaTemp = temp.split("=");
                    if (listaTemp[0].equals(palabraEspanol)){
                    System.out.println("La Traducción de " + palabraEspanol + " es: " + listaTemp[1]);
                    break;
                    }
                }
            }
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
