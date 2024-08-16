package co.edu.uniquindio;

public class VehiculoTransporte extends Vehiculo {
    private final int maxPasajeros;

    public VehiculoTransporte(String placa, String modelo, String marca, String color, int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }
}
