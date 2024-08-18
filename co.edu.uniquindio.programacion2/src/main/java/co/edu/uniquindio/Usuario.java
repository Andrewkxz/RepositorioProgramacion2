package co.edu.uniquindio;

public class Usuario {
    private final String nombre;
    private final int edad;
    private final double peso;
    private Vehiculo vehiculo;

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

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
