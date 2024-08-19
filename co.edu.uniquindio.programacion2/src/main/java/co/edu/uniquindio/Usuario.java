package co.edu.uniquindio;
/**
 * Clase que representa un usuario en el sistema de gestión de transporte.
 * Cada usuario tiene un nombre, edad, peso y puede estar asociado a un vehículo.
 */
public class Usuario {
    private final String nombre;
    private final int edad;
    private final double peso;
    private Vehiculo vehiculo;

    /**
     * Constructor que inicializa los atributos de un usuario.
     */
    public Usuario(String nombre, int edad, double peso, Vehiculo vehiculo) {
        this.edad = edad;
        this.nombre = nombre;
        this.peso = peso;
        this.vehiculo = vehiculo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
/**
 * Asocia un vehículo al usuario.
 * @param vehículo el Vehículo que se desea asociar al usuario.
 */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
