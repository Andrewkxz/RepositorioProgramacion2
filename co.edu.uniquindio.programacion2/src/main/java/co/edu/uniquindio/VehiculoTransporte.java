package co.edu.uniquindio;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Clase que representa un vehiculo de transporte.
 * Este vehiculo tiene un número máximo de pasajeros y una colección de usuarios asociados.
 */

public class VehiculoTransporte extends Vehiculo {
    private final int maxPasajeros;
    private final Collection <Usuario> usuarios;

    /**
     * Constructor que inicializa los atributos del vehículo de transporte.
     */
    public VehiculoTransporte(String placa, String modelo, String marca, String color, int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        this.usuarios = new LinkedList<>();
    }

    /**
     * Obtiene el número máximo de pasajeros que puede transportar el vehículo.
     * @return el número máximo de pasajeros.
     */

    public int getMaxPasajeros() {
        return maxPasajeros;
    }
    /**
     * Añade un usuario al vehículo, siempre que no exceda el límite de pasajeros.
     * @param usuario Usuario a añadir al vehículo.
     */

    public void addUsuario(Usuario usuario) {
        if(usuarios.size() <= maxPasajeros) {
            usuarios.add(usuario);
        } else {
            System.out.println("Error: el vehículo con placa: " + getPlaca() + "se encuentra lleno");
        }

    }

    /**
     * Obtiene el número actual de usuarios en el vehículo.
     * @return El número de usuarios en el vehículo.
     */
    public int getNumeroUsuarios() {
        return usuarios.size();
    }

    /**
     * Obtiene una colección no modificable de los usuarios asociados al vehículo.
     * @return una colección no modificable de los usuarios.
     */
    public Collection <Usuario> getUsuarios() {
        return Collections
                .unmodifiableCollection(usuarios);
    }

}
