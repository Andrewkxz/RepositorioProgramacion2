package co.edu.uniquindio;

public class Usuario {
    private String edad;
    private final String nombre;

    public Usuario(String edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}
