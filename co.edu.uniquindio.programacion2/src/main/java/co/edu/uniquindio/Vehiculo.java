package co.edu.uniquindio;

public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private  final String marca;
    private final String color;

    public Vehiculo(String placa, String modelo, String marca, String color){
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }
}
