package co.edu.uniquindio;

public class VehiculoCarga extends Vehiculo {
    private final double capacidadCarga;
    private final int numeroEjes;

    public VehiculoCarga(String placa, String modelo, String marca, String color,double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }
}
