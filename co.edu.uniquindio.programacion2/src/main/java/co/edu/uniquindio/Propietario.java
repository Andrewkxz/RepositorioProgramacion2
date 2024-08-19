package co.edu.uniquindio;
/**
 * Clase que representa un propietario de un vehiculo en el sistema de gestion de transporte.
 * Cada propietario tiene unos datos, como lo son nombre, cédula, edad, email, celular y un vehiculo asociado.
 */
public class Propietario {
    private final String nombre;
    private final String cedula;
    private final int edad;
    private final String email;
    private final String celular;
    private Vehiculo vehiculo;

    /**
     * Constructor que inicializa los atributos de un propietario.
     */
    public Propietario (String nombre, String cedula, int edad, String email, String celular, Vehiculo vehiculo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.email = email;
        this.celular = celular;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {

        return nombre;
    }

    public String getCedula() {

        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {

        return email;
    }

    public String getCelular() {

        return celular;
    }

    public Vehiculo getVehiculo() {

        return vehiculo;
    }
}
