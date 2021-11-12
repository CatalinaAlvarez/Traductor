package diccionario;

public class Diccionario {
    String palabraEspanol;
    String palabraIngles;

    public Diccionario() {
    }

    //Constructor de la clase Diccionario
    public Diccionario(String palabraEspanol, String palabraIngles) {
        this.palabraEspanol = palabraEspanol;
        this.palabraIngles = palabraIngles;
    }

    public String getPalabraEspanol() {
        return palabraEspanol;
    }

    public String getPalabraIngles() {
        return palabraIngles;
    }


}
