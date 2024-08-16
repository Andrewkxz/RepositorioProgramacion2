package co.edu.uniquindio;

import java.util.Scanner;

public class MainTransporte {
    public static void main(String[] args) {

        EmpresaTransporte empresa = new EmpresaTransporte();

        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("Selecciona una de las siguientes opciones: ");
            System.out.println("1. Capturar datos de un propietario");
            System.out.println("2. Calcular el total de pasajeros de un vehículo: ");
            System.out.println("3. salir");
            System.out.println("opción a seleccionar: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Propietario propietario = capturarDatosPropietario();
                    empresa.addPropietario(propietario);
                    System.out.println("Él propietario y su vehículo han sido registrados correctamente");
                    break;

                case 2:
                    System.out.println("Ingresa la placa del vehículo: ");
                    String placa = sc.nextLine();
                    String totalPasajeros = empresa.calcularTotalPasajeros(placa);
                    System.out.println(totalPasajeros);
                    break;

                case 3:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no valida");
            }
        }
    }



    private static Propietario capturarDatosPropietario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el nombre del propietario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la cédula del propietario: ");
        String cedula = sc.nextLine();
        System.out.println("Ingresa el email del propietario: ");
        String email = sc.nextLine();
        System.out.println("Ingresa el celular del propietario: ");
        String celular = sc.nextLine();

        System.out.println("Ingresa el tipo de vehiculo ('carga' o 'transporte': ");
        String tipoVehiculo = sc.nextLine().toLowerCase();
        Vehiculo vehiculo = null;

        System.out.println("Ingresa la placa del vehículo: ");
        String placa = sc.nextLine();
        System.out.println("Ingresa el modelo del vehículo: ");
        String modelo = sc.nextLine();
        System.out.println("Ingresa la marca del vehículo: ");
        String marca = sc.nextLine();
        System.out.println("Ingresa el color del vehículo: ");
        String color = sc.nextLine();

        if(tipoVehiculo.equals("carga")) {
            System.out.println("Ingresa la capacidad del vehículo: ");
            double capacidad = sc.nextDouble();
            System.out.println("Ingresa el número de ejes del vehículo de carga: ");
            int ejes = sc.nextInt();

            vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes);

        } else if(tipoVehiculo.equals("transporte")) {
            System.out.println("Ingresa el número máximo de pasajeros del vehículo: ");
            int maxPasajeros = sc.nextInt();

            vehiculo = new VehiculoTransporte(placa, modelo, marca, color, maxPasajeros);

        } else{
            System.out.println("Error: el tipo de vehículo debe ser 'carga' o 'transporte'");
            System.exit(1);
        }

        sc.nextLine();
        return new Propietario(nombre, cedula, email, celular, vehiculo);
    }
}
