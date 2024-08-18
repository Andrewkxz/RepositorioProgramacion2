package co.edu.uniquindio;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class VehiculoTransporte extends Vehiculo {
    private final int maxPasajeros;
    private final Collection <Usuario> usuarios;

    public VehiculoTransporte(String placa, String modelo, String marca, String color, int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        this.usuarios = new LinkedList<>();
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void addUsuario(Usuario usuario) {
        if(usuarios.size() <= maxPasajeros) {
            usuarios.add(usuario);
        } else {
            System.out.println("Error: el vehículo con placa: " + getPlaca() + "se encuentra lleno");
        }

    }

    public int getNumeroUsuarios() {
        return usuarios.size();
    }

    public Collection <Usuario> getUsuarios() {
        return Collections
                .unmodifiableCollection(usuarios);
    }

}
